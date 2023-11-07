package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CommandSender {
    private BufferedWriter writer;
    private FileWriter logFile;
    private Scanner scanner;

    public CommandSender(BufferedWriter writer, FileWriter logFile, Scanner scanner) {
        this.writer = writer;
        this.logFile = logFile;
        this.scanner = scanner;
    }

    public void sendCommand(String command) {
        try {
            writer.write(command);
            writer.newLine();
            writer.flush();
            logFile.write("Sent: " + command + "\n");
            logFile.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}