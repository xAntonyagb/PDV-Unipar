/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app.pdvutils;

/**
 *
 * @author gabri
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ApiLogger {

    private static final String LOG_FILE_PATH = "./api_operations_log.txt";

    public void logOperation(LocalDateTime operationDateTime, String operationType, String operationStatus) {
        String logMessage = String.format("%s - Operation: %s, Status: %s%n", operationDateTime, operationType, operationStatus);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
            writer.write(logMessage);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the log file: " + e.getMessage());
        }
    }
}