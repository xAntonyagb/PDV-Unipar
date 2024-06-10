package com.mycompany.app.pdv.services;

import com.mycompany.app.pdv.dtos.response.ProdutoResponseDTO;
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


public class ProdutoService {

     
    public ProdutoResponseDTO findById(Integer id) throws ApiException, InterruptedException {
        final ProdutoResponseDTO[] produtoDTO = new ProdutoResponseDTO[1];
        final CountDownLatch latch = new CountDownLatch(1);
        final Throwable[] throwable = new Throwable[1];

         Call<ProdutoResponseDTO> call = new RetrofitConfig()
                .produtoRequest().findById(id, PDVUtils.acessToken);
        call.enqueue(new Callback<ProdutoResponseDTO>() {
            @Override
            public void onResponse(Call<ProdutoResponseDTO> call, Response<ProdutoResponseDTO> response) {
                Integer code =  response.code();
                ApiLoggerUtils.logOperation(LocalDateTime.now(), " GET(findById) - PRODUTO ", code.toString());
                
                if (response.isSuccessful()) {
                    produtoDTO[0] = response.body();
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
            public void onFailure(Call<ProdutoResponseDTO> call, Throwable t) {
                Integer code = 500;
                ApiLoggerUtils.logOperation(LocalDateTime.now(), " GET(findById) - PRODUTO ", code.toString() + " - " + t.getMessage());
                throwable[0] = new ApiException("Tempo esgotado: Nenhum retorno recebido do host!");
                latch.countDown();
            }
        });

        latch.await(); // Espera até que a chamada assíncrona seja concluída

        if (throwable[0] != null) {
            throw (ApiException) throwable[0];
        }

        return produtoDTO[0];
    }
     
    public List<ProdutoResponseDTO> findAll() throws ApiException, InterruptedException {
        
        final List<ProdutoResponseDTO>[] produtoList = new List[1];
        final CountDownLatch latch = new CountDownLatch(1);
        final Throwable[] throwable = new Throwable[1];

        Call<List<ProdutoResponseDTO>> call = new RetrofitConfig()
                .produtoRequest().findAll("Bearer " + PDVUtils.acessToken);
        call.enqueue(new Callback<List<ProdutoResponseDTO>>() {
            @Override
            public void onResponse(Call<List<ProdutoResponseDTO>> call, Response<List<ProdutoResponseDTO>> response) {
                Integer code =  response.code();
                ApiLoggerUtils.logOperation(LocalDateTime.now(), " GET(findAll) - PRODUTO ", code.toString());
                
                if (response.isSuccessful()) {
                    produtoList[0] = response.body();
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
            public void onFailure(Call<List<ProdutoResponseDTO>> call, Throwable t) {
                Integer code = 500;
                ApiLoggerUtils.logOperation(LocalDateTime.now(), " GET(findAll) - PRODUTO ", code.toString() + " - " + t.getMessage());
                throwable[0] = new ApiException("Tempo esgotado: Nenhum retorno recebido do host!");
                latch.countDown();
            }
        });

        latch.await(); // Espera até que a chamada assíncrona seja concluída

        if (throwable[0] != null) {
            throw (ApiException) throwable[0];
        }

        return produtoList[0];
    }
     
//    public List<ProdutoResponseDTO> findByDesc(String desc) throws ApiException, InterruptedException {
//        final List<ProdutoResponseDTO>[] produtoList = new List[1];
//        final CountDownLatch latch = new CountDownLatch(1);
//        final Throwable[] throwable = new Throwable[1];
//
//        Call<List<ProdutoResponseDTO>> call = new RetrofitConfig()
//                .produtoRequest().findByDesc(desc, "Bearer " + PDVUtils.acessToken);
//        call.enqueue(new Callback<List<ProdutoResponseDTO>>() {
//            @Override
//            public void onResponse(Call<List<ProdutoResponseDTO>> call, Response<List<ProdutoResponseDTO>> response) {
//                Integer code =  response.code();
//                ApiLoggerUtils.logOperation(LocalDateTime.now(), " GET(findByDesc) - PRODUTO ", code.toString());
//                if (response.isSuccessful()) {
//                    produtoList[0] = response.body();
//                }
//                else if(response.code() == 401) {
//                    throwable[0] = new ApiException(response.code() + ": Seu login expirou!");
//                } 
//                else {
//                    throwable[0] = PDVUtils.getResponseError(response);
//                }
//                latch.countDown();
//            }
//
//            @Override
//            public void onFailure(Call<List<ProdutoResponseDTO>> call, Throwable t) {
//                Integer code = 500;
//                ApiLoggerUtils.logOperation(LocalDateTime.now(), " GET(findByDesc) - PRODUTO ", code.toString() + " - " + t.getMessage());
//                throwable[0] = new ApiException("Tempo esgotado: Nenhum retorno recebido do host!");
//                latch.countDown();
//            }
//        });
//
//        latch.await(); // Espera até que a chamada assíncrona seja concluída
//
//        if (throwable[0] != null) {
//            throw (ApiException) throwable[0];
//        }
//
//        return produtoList[0];
//    }  
    
}
