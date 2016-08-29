package com.tiy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by fenji on 8/25/2016.
 */
public class ServerLink {
    public static void main(String[] args) {
        Server server = new Server();

        server.startServer();
    }
}
