package com.tiy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by fenji on 8/25/2016.
 */
public class Client {

    public static void main(String[] args) {
        String userName = "";
        String homeIp = "127.0.0.1";
        Scanner scan = new Scanner(System.in);
        try {
            // connect to the server on the target port

            Socket client = new Socket(homeIp, 8005);

            // once we connect to the server, we also have an input and output stream
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            // ask for userName for server side thread recognition
            System.out.println("what is your name?");
            userName = scan.nextLine();

            // send the server initial message containing the userName of the client
            out.println("name=" + userName);
            // read what the server returns
            String serverResponse = in.readLine();
            System.out.println(serverResponse);
            while(true){
                String output = scan.nextLine();
                if (output.equalsIgnoreCase("exitprogram")){
                    break;
                }
                out.println(output);
                serverResponse = in.readLine();
                System.out.println(serverResponse);
            }

            // close the connection
            client.close();
        } catch (IOException ioEx){
            ioEx.printStackTrace();
        }

    }
}
