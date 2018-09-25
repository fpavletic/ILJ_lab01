package hr.tel.fer.lab1.server;

import hr.tel.fer.lab1.logging.LogLine;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {

    int port;

    List<LogLine> logs;
    ExecutorService executorService;

    public Server(int maxConcurrentClients, int port, String path) throws IOException{

        this.port = port;

        logs = new ArrayList<>();
        readLogs(Paths.get(path));

        executorService = Executors.newFixedThreadPool(maxConcurrentClients);
    }

    private void readLogs(Path path) throws IOException{
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
                try ( Scanner logReader = new Scanner(file)){
                    while ( logReader.hasNextLine() ) {
                        logs.add(new LogLine(logReader.nextLine()));
                    }
                } catch ( IOException ioe ) {
                    System.err.println("Server: Failed to parse file: " + file.toString());
                }
                return FileVisitResult.CONTINUE;
            }
        });

    }

    @Override
    public void run(){

        try(ServerSocket ssc = new ServerSocket(port)) {
            System.out.println("Server: Listening");
            while ( true ) {
                LogRequestHandler handler = new LogRequestHandler(ssc.accept(), logs);
                System.out.println("Server: Opened user socket.");
                executorService.execute(handler);
            }
        } catch ( IOException e ) {
            System.err.println("Server: Failed to create server socket!");
        }
    }
}
