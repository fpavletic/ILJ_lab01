package hr.tel.fer.lab1;

import hr.tel.fer.lab1.client.Client;
import hr.tel.fer.lab1.server.Server;

import java.io.IOException;

/**
 * Example class showcasing the use of Server and Client classes
 */
public class Main {

    public static void main(String[] args) throws IOException{
        Server s = new Server(5, 9000, "./ilj_1lab_log.txt");
        Client c0 = new Client("localhost", 9000, "FILTER METHOD == \"HEAD\" STATUS == \"404\" RETURN -1");
        Client c1 = new Client("localhost", 9000, "FILTER VERSION==\"HTTP/1.0\" METHOD!=\"OPTIONS\" RETURN -1");
        Client c2 = new Client("localhost", 9000, "FILTER IP==\"62.112.157.53\" METHOD != \"POST\" RETURN -1");
        Client c3 = new Client("localhost", 9000, "FILTER DATETIME==12/Feb/2014:12:23:16 METHOD == \"GET\" STATUS == \"200\" RETURN -1");

        Client c4 = new Client("localhost", 9000, "FILTER DATETIME== 12/Feb/2014:12:31:47 IP ==\"127.0.0.1\" RETURN 5");

        new Thread(s).start();
        new Thread(c0).start();
//        new Thread(c1).start();
//        new Thread(c2).start();
//        new Thread(c3).start();
//        new Thread(c4).start();


    }
}
