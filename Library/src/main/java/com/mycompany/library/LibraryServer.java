package com.mycompany.library;

import com.mycompany.library.model.ClientServingThread;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibraryServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1991)) {

            System.out.println("Server started");

            while (true) {
                try (Socket socket = serverSocket.accept()) {

                    System.out.println("Client connected");

                    ClientServingThread clientServingThread = new ClientServingThread(socket);
                    clientServingThread.start();

                    while (true) {

                    }
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(LibraryServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
