package hr.tel.fer.lab1.server;

import hr.tel.fer.lab1.antlr.RequestLexer;
import hr.tel.fer.lab1.antlr.RequestParser;
import hr.tel.fer.lab1.logging.LogLine;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogRequestHandler implements Runnable {

    private static final Pattern CONDITION_PATTERN = Pattern.compile("(\"?)([^\"\\s]+?)\\1 ?([!=]=) ?(\"?)([^\"\\s]+)\\4");

    Socket socket;
    List<LogLine> logs;

    public LogRequestHandler(Socket socket, List<LogLine> logs){
        this.socket = socket;
        this.logs = logs;
    }

    @Override
    public void run(){
        System.out.println("Server: Waiting for request.");
        try ( BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter socketOutput = new PrintWriter(socket.getOutputStream(), true)) {
            String request = socketInput.readLine();
            System.out.format("Server: Request Recieved.%n%s%n", request);

            parserHandler(request, socketOutput);

            System.out.println("Server: Request served, closing user socket.");
        } catch ( IOException e ) {
            System.err.println("Server: failed to initialize log request handler.");
        }
    }

    /**
     * Method filters previously read logs according to the request
     * provided by the client using an ANLTR 4.7.1 generated parser.
     *
     * @param request - client provided request
     * @param socketOutput - client socket @PrintWriter
     */
    private void parserHandler(String request, PrintWriter socketOutput){

        RequestLexer lexer = new RequestLexer(CharStreams.fromString(request));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        RequestParser parser = new RequestParser(tokens);
        LogRequestContainer container = parser.request().result;

        //Filters the logs according to the parser generated condition list
        List<LogLine> validLines = logs.stream()
                .filter(container.getConditions().stream().reduce(Predicate::and).orElse(l -> false))
                .collect(Collectors.toList());

        //Prints out the filtered logs to the client socket PrintWriter
        int count = container.getCount();
//                Integer.parseInt(tree.getChild(tree.getChildCount() - 1).toStringTree());
        for (int i = 0; count-- != 0 && i < validLines.size(); i++ ){
            socketOutput.println(validLines.get(i).toString());
        }

    }

    /**
     * Method filters previously read logs according to the request
     * provided by the client using regex.
     *
     * NOTE: This is not how the lab exercise should be solved, but imho
     * makes way more sense than creating a grammar and generating a parser
     * which is just overkill for handling requests that cannot be nested.
     *
     * @param request - client provided request
     * @param socketOutput - client socket @PrintWriter
     */
    private void regexHandler(String request, PrintWriter socketOutput){

        String[] tokens = request.split("(?<![!=]=) +(?![!=]=)");

        //Generates a condition list from the client request
        List<Predicate<LogLine>> conditions = new ArrayList<>();
        for ( int i = 1; i < tokens.length - 2; i++){
            Matcher m = CONDITION_PATTERN.matcher(tokens[i]);
            if ( !m.find() ){
                continue;
            }
            conditions.add(l -> l.equals(m.group(2), m.group(5)) ^ m.group(3).equals("!=") ? true : false);
        }

        //Filters the logs according to the previously generated condition list
        List<LogLine> validLines = logs.stream()
                .filter(conditions.stream().reduce(Predicate::and).orElse(l -> false))
                .collect(Collectors.toList());

        //Prints out the filtered logs to the client socket PrintWriter
        int count = Integer.parseInt(tokens[tokens.length -1]);
        for (int i = 0; count-- != 0 && i < validLines.size(); i++ ){
            socketOutput.println(validLines.get(i).toString());
        }
    }
}
