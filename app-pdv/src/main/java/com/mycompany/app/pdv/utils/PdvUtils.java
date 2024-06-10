package com.mycompany.app.pdv.utils;

import com.google.gson.Gson;
import com.mycompany.app.pdv.dtos.response.ClienteResponseDTO;
import com.mycompany.app.pdv.dtos.response.ErrorResponseDTO;
import com.mycompany.app.pdv.dtos.response.ProdutoResponseDTO;
import com.mycompany.app.pdv.dtos.response.VendaResponseDTO;
import com.mycompany.app.pdv.exceptions.ApiException;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import retrofit2.Response;

/**
 *
 * @author gabri
 */
public class PDVUtils {
   public static String acessToken;
   
   public static List<ProdutoResponseDTO> produtos;
   public static List<ClienteResponseDTO> clientes;
   public static List<VendaResponseDTO> vendas;
   public static ScheduledExecutorService scheduler;
   
   
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
    
    
    // Metodo para retornar Erro de API
    public static Throwable getResponseError(Response response) {
        Throwable t;
                
        try {
            // Obter a mensagem de erro
            String errorBody = response.errorBody().string();
            Gson gson = new Gson();
            ErrorResponseDTO errorResponse = gson.fromJson(errorBody, ErrorResponseDTO.class); // Binding

            t = new ApiException(
                    "Erro " + response.code() + ": " + errorResponse.getErrors());
        } 
        catch (Exception e) {
            //Caso não consiga ler o erro
            t = new ApiException(
                    "Erro: " + response.code() +
                    "\nMensagem: " + response.message() +
                    "\nErro ao ler o corpo da resposta de erro."
            );
        }
        
        return t;
    }
    
}
