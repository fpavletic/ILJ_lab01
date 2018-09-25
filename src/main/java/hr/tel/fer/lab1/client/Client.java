package hr.tel.fer.lab1.client;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable {

    private static int nextId = 0;

    private int id;
    private String hostname;
    private int port;
    private String request;

    public Client(String hostname, int port, String request){
        id = nextId++;
        this.hostname = hostname;
        this.port = port;
        this.request = request;
        System.out.format("Client %02d created with request: %s%n", id, request);
    }

    @Override
    public void run(){

        try ( Socket socket = new Socket(hostname, port);
                BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter socketOutput = new PrintWriter(socket.getOutputStream(), true)){
            System.out.format("Client %02d: Socket opened.%n", id);
            socketOutput.println(request);
            System.out.format("Client %02d: Request sent.%n", id);
            String response;
            while ( (response = socketInput.readLine()) != null ){
                System.out.format("Client %02d: %s%n", id, response);
            }
            System.out.format("Client %02d: Closing client.%n", id);
        } catch ( IOException e ) {
            System.err.format("Client %02d: Failed to create socket!%n", id);
        }
    }
}
