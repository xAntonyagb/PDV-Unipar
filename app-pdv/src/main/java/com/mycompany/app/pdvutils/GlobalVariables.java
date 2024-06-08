package com.mycompany.app.pdvutils;

import com.mycompany.app.pdv.dtos.response.ClienteResponseDTO;
import com.mycompany.app.pdv.dtos.response.ProdutoResponseDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author gabri
 */
public class GlobalVariables {
   public static String acessToken;
   public static List<ProdutoResponseDTO> produtos;
   public static List<ClienteResponseDTO> clientes;
   public static ScheduledExecutorService scheduler;
   
   private static final String USUARIO = "postgres";
   private static final String SENHA = "oitoletras8";
   private static final String ENDERECO = "jdbc:postgresql://localhost:5432/PDV-Unipar";
   private static Connection conn = null;
   
   public static Connection getConexao() {
        try{
            if(conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(ENDERECO, USUARIO, SENHA);
                return conn;
            }
            
            return conn;
        } catch(Exception ex) {
            conn = null;
            System.out.println("Erro ao abrir conexão");
        }
        
        return null;
    }
   
     // Método para encerrar o agendamento
    public static void shutdownScheduler() {
        if (scheduler != null) {
            scheduler.shutdown();
            try {
                if (!scheduler.awaitTermination(60, TimeUnit.SECONDS)) {
                    scheduler.shutdownNow();
                    if (!scheduler.awaitTermination(60, TimeUnit.SECONDS))
                        System.err.println("O scheduler não pôde ser encerrado");
                }
            } catch (InterruptedException ie) {
                scheduler.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
   
}
