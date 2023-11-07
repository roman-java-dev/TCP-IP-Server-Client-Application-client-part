package org.example;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.SocketException;

public class ResponseHandler implements Runnable {
    private BufferedReader reader;
    private FileWriter logFile;

    public ResponseHandler(BufferedReader reader, FileWriter logFile) {
        this.reader = reader;
        this.logFile = logFile;
    }

    @Override
    public void run() {
        try {
            String response;
            try {
                while ((response = reader.readLine()) != null) {
                    if (response.contains("Counter")) {
                        System.out.println(response);
                    } else {
                        System.out.println("Received: " + response);
                        processResponse(response, logFile);
                    }
                }
            } catch (SocketException e) {
                System.out.println("Server was disconnected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processResponse(String response, FileWriter logFile) throws IOException {
        logFile.write(response + "\n");
        logFile.flush();
    }
}