package com.mycompany.app.pdv.services;

import com.mycompany.app.pdv.dtos.request.VendaRequestDTO;
import com.mycompany.app.pdv.dtos.response.VendaResponseDTO;
import com.mycompany.app.pdv.exceptions.ApiException;
import com.mycompany.app.pdv.retrofit.RetrofitConfig;
import com.mycompany.app.pdv.utils.ApiLoggerUtils;
import com.mycompany.app.pdv.utils.PDVUtils;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class VendaService {
    
    public VendaResponseDTO insert(VendaRequestDTO venda) throws ApiException, InterruptedException {
        final VendaResponseDTO[] vendaDTO = new VendaResponseDTO[1];
        final CountDownLatch latch = new CountDownLatch(1);
        final Throwable[] throwable = new Throwable[1];

        Call<VendaResponseDTO> call = new RetrofitConfig()
                .vendaRequest().insert(venda, "Bearer " + PDVUtils.acessToken);
        
        //Fazer a chamada
        call.enqueue(new Callback<VendaResponseDTO>() {
            @Override
            public void onResponse(Call<VendaResponseDTO> call, Response<VendaResponseDTO> response) {
                Integer code =  response.code();
                ApiLoggerUtils.logOperation(LocalDateTime.now(), " POST(insert) - VENDA ", code.toString());
                
                if (response.isSuccessful()) {
                    vendaDTO[0] = response.body();
                } 
                else if(response.code() == 401) {
                    throwable[0] = new ApiException(response.code() + ": Seu login expirou!");
                } 
                else {
                    throwable[0] = PDVUtils.getResponseError(response);
                }
                
                latch.countDown();
            }

            @Override
            public void onFailure(Call<VendaResponseDTO> call, Throwable t) {
                Integer code = 500;
                ApiLoggerUtils.logOperation(LocalDateTime.now(), " POST(insert) - VENDA ", code.toString() + " - " + t.getMessage());
                
                throwable[0] = new ApiException("Tempo esgotado: Nenhum retorno recebido do host!");
                latch.countDown();
            }
        });

        latch.await(); // Espera até que a chamada assíncrona seja concluída

        if (throwable[0] != null) {
            throw (ApiException) throwable[0];
        }

        return vendaDTO[0];
    }
    
    
    public VendaResponseDTO doCalc(VendaRequestDTO venda) throws ApiException, InterruptedException {
        final VendaResponseDTO[] vendaDTO = new VendaResponseDTO[1];
        final CountDownLatch latch = new CountDownLatch(1);
        final Throwable[] throwable = new Throwable[1];

        Call<VendaResponseDTO> call = new RetrofitConfig()
                .vendaRequest().doCalc(venda, "Bearer " + PDVUtils.acessToken); 
        
        //Fazer a chamada
        call.enqueue(new Callback<VendaResponseDTO>() {
            @Override
            public void onResponse(Call<VendaResponseDTO> call, Response<VendaResponseDTO> response) {
                Integer code =  response.code();
                ApiLoggerUtils.logOperation(LocalDateTime.now(), " POST(doCalc) - VENDA ", code.toString());
                
                if (response.isSuccessful()) {
                    vendaDTO[0] = response.body();
                }
                else if(response.code() == 401) {
                    throwable[0] = new ApiException(response.code() + ": Seu login expirou!");
                } 
                else {
                    throwable[0] = PDVUtils.getResponseError(response);
                }
                
                latch.countDown();
            }

            @Override
            public void onFailure(Call<VendaResponseDTO> call, Throwable t) {
                Integer code = 500;
                ApiLoggerUtils.logOperation(LocalDateTime.now(), " POST(doCalc) - VENDA ", code.toString() + " - " + t.getMessage());
                
                throwable[0] = new ApiException("Tempo esgotado: Nenhum retorno recebido do host!");
                latch.countDown();
            }
        });

        latch.await(); // Espera até que a chamada assíncrona seja concluída

        if (throwable[0] != null) {
            throw (ApiException) throwable[0];
        }

        return vendaDTO[0];
    }
    
    
    public List<VendaResponseDTO> findAll() throws ApiException, InterruptedException {
        final List<VendaResponseDTO>[] vendaList = new List[1];
        final CountDownLatch latch = new CountDownLatch(1);
        final Throwable[] throwable = new Throwable[1];

        Call<List<VendaResponseDTO>> call = new RetrofitConfig()
                .vendaRequest().findAll("Bearer " + PDVUtils.acessToken);
        call.enqueue(new Callback<List<VendaResponseDTO>>() {
            @Override
            public void onResponse(Call<List<VendaResponseDTO>> call, Response<List<VendaResponseDTO>> response) {
                Integer code =  response.code();
                ApiLoggerUtils.logOperation(LocalDateTime.now(), " GET(findAll) - VENDA ", code.toString());
                if (response.isSuccessful()) {
                    vendaList[0] = response.body();
                }
                else if(response.code() == 401) {
                    throwable[0] = new ApiException(response.code() + ": Seu login expirou!");
                } 
                else {
                    throwable[0] = PDVUtils.getResponseError(response);
                }
                latch.countDown();
            }

            @Override
            public void onFailure(Call<List<VendaResponseDTO>> call, Throwable t) {
                Integer code = 500;
                ApiLoggerUtils.logOperation(LocalDateTime.now(), " GET(findAll) - VENDA ", code.toString() + " - " + t.getMessage());
                throwable[0] = new ApiException("Tempo esgotado: Nenhum retorno recebido do host!");
                latch.countDown();
            }
        });

        latch.await(); // Espera até que a chamada assíncrona seja concluída

        if (throwable[0] != null) {
            throw (ApiException) throwable[0];
        }

        return vendaList[0];
    }
    
}
