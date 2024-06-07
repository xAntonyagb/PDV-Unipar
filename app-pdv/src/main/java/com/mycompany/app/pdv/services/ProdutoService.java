package com.mycompany.app.pdv.services;

import com.mycompany.app.pdv.dtos.ProdutoDTO;
import com.mycompany.app.pdv.exceptions.ApiException;
import com.mycompany.app.pdv.retrofit.RetrofitConfig;
import com.mycompany.app.pdvutils.ApiLogger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ProdutoService {

     
    public ProdutoDTO findById(Integer id, String token) throws ApiException, InterruptedException {
        final ProdutoDTO[] produtoDTO = new ProdutoDTO[1];
        final CountDownLatch latch = new CountDownLatch(1);
        final Throwable[] throwable = new Throwable[1];

         Call<ProdutoDTO> call = new RetrofitConfig()
                .produtoRequest().findById(id, token);
        call.enqueue(new Callback<ProdutoDTO>() {
            @Override
            public void onResponse(Call<ProdutoDTO> call, Response<ProdutoDTO> response) {
                ApiLogger apiLogger = new ApiLogger();
                Integer code =  response.code();
                apiLogger.logOperation(LocalDateTime.now(), " GET(findById) - PRODUTO ", code.toString());
                if (response.isSuccessful()) {
                    produtoDTO[0] = response.body();
                } 
                else if(response.code() == 401) {
                    throwable[0] = new ApiException(response.code() + ": Seu login expirou!");
                } 
                else {
                    throwable[0] = new ApiException(new Throwable("Error: " + response.code()));
                }
                latch.countDown();
            }

            @Override
            public void onFailure(Call<ProdutoDTO> call, Throwable t) {
                ApiLogger apiLogger = new ApiLogger();
                Integer code = 500;
                apiLogger.logOperation(LocalDateTime.now(), " GET(findById) - PRODUTO ", code.toString() + " - " + t.getMessage());
                throwable[0] = new ApiException("Não foi possivel estabelecer conexão com o host!");
                latch.countDown();
            }
        });

        latch.await(); // Espera até que a chamada assíncrona seja concluída

        if (throwable[0] != null) {
            throw (ApiException) throwable[0];
        }

        return produtoDTO[0];
    }
     
    public List<ProdutoDTO> findAll(String token) throws ApiException, InterruptedException {
        
        final List<ProdutoDTO>[] produtoList = new List[1];
        final CountDownLatch latch = new CountDownLatch(1);
        final Throwable[] throwable = new Throwable[1];

        Call<List<ProdutoDTO>> call = new RetrofitConfig()
                .produtoRequest().findAll("Bearer " + token);
        call.enqueue(new Callback<List<ProdutoDTO>>() {
            @Override
            public void onResponse(Call<List<ProdutoDTO>> call, Response<List<ProdutoDTO>> response) {
                ApiLogger apiLogger = new ApiLogger();
                Integer code =  response.code();
                apiLogger.logOperation(LocalDateTime.now(), " GET(findAll) - PRODUTO ", code.toString());
                if (response.isSuccessful()) {
                    produtoList[0] = response.body();
                }
                else if(response.code() == 401) {
                    throwable[0] = new ApiException(response.code() + ": Seu login expirou!");
                } 
                else {
                    throwable[0] = new ApiException(new Throwable("Error: " + response.code()));
                }
                latch.countDown();
            }

            @Override
            public void onFailure(Call<List<ProdutoDTO>> call, Throwable t) {
                ApiLogger apiLogger = new ApiLogger();
                Integer code = 500;
                apiLogger.logOperation(LocalDateTime.now(), " GET(findAll) - PRODUTO ", code.toString() + " - " + t.getMessage());
                throwable[0] = new ApiException("Não foi possivel estabelecer conexão com o host!");
                latch.countDown();
            }
        });

        latch.await(); // Espera até que a chamada assíncrona seja concluída

        if (throwable[0] != null) {
            throw (ApiException) throwable[0];
        }

        return produtoList[0];
    }
     
    public List<ProdutoDTO> findByDesc(String desc, String token) throws ApiException, InterruptedException {
        final List<ProdutoDTO>[] produtoList = new List[1];
        final CountDownLatch latch = new CountDownLatch(1);
        final Throwable[] throwable = new Throwable[1];

        Call<List<ProdutoDTO>> call = new RetrofitConfig()
                .produtoRequest().findByDesc(desc, token);
        call.enqueue(new Callback<List<ProdutoDTO>>() {
            @Override
            public void onResponse(Call<List<ProdutoDTO>> call, Response<List<ProdutoDTO>> response) {
                ApiLogger apiLogger = new ApiLogger();
                Integer code =  response.code();
                apiLogger.logOperation(LocalDateTime.now(), " GET(findByDesc) - PRODUTO ", code.toString());
                if (response.isSuccessful()) {
                    produtoList[0] = response.body();
                }
                else if(response.code() == 401) {
                    throwable[0] = new ApiException(response.code() + ": Seu login expirou!");
                } 
                else {
                    throwable[0] = new ApiException(new Throwable("Error: " + response.code()));
                }
                latch.countDown();
            }

            @Override
            public void onFailure(Call<List<ProdutoDTO>> call, Throwable t) {
                ApiLogger apiLogger = new ApiLogger();
                Integer code = 500;
                apiLogger.logOperation(LocalDateTime.now(), " GET(findByDesc) - PRODUTO ", code.toString() + " - " + t.getMessage());
                throwable[0] = new ApiException("Não foi possivel estabelecer conexão com o host!");
                latch.countDown();
            }
        });

        latch.await(); // Espera até que a chamada assíncrona seja concluída

        if (throwable[0] != null) {
            throw (ApiException) throwable[0];
        }

        return produtoList[0];
    }  
    
    
    
}
