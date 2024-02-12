package org.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(4500);
            Server server = new Server(serverSocket);
            server.runServer();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}