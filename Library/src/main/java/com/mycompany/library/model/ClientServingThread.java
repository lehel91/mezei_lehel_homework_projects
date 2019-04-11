package com.mycompany.library.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientServingThread extends Thread {

    private Socket socket;

    public ClientServingThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try (
                InputStream is = this.socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                OutputStream os = this.socket.getOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(os);) {

            String choiceFromClient;
            while ((choiceFromClient = br.readLine()) != null) {
                if ("All books".equals(choiceFromClient)) {
                    DBManager.getDbManager().fillBookList(1);
                } else if ("Available books".equals(choiceFromClient)) {
                    DBManager.getDbManager().fillBookList(2);
                } else {
                    DBManager.getDbManager().fillBookList(3);
                }

                for (int i = 0; i < DBManager.getDbManager().getBookList().size(); i++) {
                    oos.writeObject(DBManager.getDbManager().getBookList().get(i));
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(ClientServingThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
