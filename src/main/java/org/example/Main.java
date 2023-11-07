package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    private static final int PORT = 8080;
    private static final String HOST = "localhost";
    private static final String LOG_FILE = "LogFile";

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             FileWriter logFile = new FileWriter(LOG_FILE, true)) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Send your command to the server: ");

            ResponseHandler responseHandler = new ResponseHandler(reader, logFile);
            Thread responseThread = new Thread(responseHandler);
            responseThread.setDaemon(true);
            responseThread.start();

            CommandSender commandSender = new CommandSender(writer, logFile, scanner);
            while (true) {
                String command = scanner.nextLine();
                commandSender.sendCommand(command);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}