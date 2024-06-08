package com.mycompany.app.pdv.utils;

/**
 *
 * @author gabri
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ApiLoggerUtils {

    private static final String LOG_FILE_PATH = "./api_operations_log.txt";

    public static void logOperation(LocalDateTime operationDateTime, String operationType, String operationStatus) {
        String logMessage = String.format("%s - Operação: %s, Status: %s%n", operationDateTime, operationType, operationStatus);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
            writer.write(logMessage);
        } catch (IOException e) {
            System.out.println("Um erro ocorreu ao escrever o arquivo de log: " + e.getMessage());
        }
    }
    
    public static void logOperation(String logMessage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
            writer.write(logMessage);
        } catch (IOException e) {
            System.out.println("Um erro ocorreu ao escrever o arquivo de log: " + e.getMessage());
        }
    }
    
}