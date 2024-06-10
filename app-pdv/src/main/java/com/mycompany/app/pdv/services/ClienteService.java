package com.mycompany.app.pdv.services;

import com.mycompany.app.pdv.exceptions.ApiException;
import com.mycompany.app.pdv.dtos.response.ClienteResponseDTO;
import com.mycompany.app.pdv.retrofit.RetrofitConfig;
import com.mycompany.app.pdv.utils.ApiLoggerUtils;
import com.mycompany.app.pdv.utils.PDVUtils;
import java.time.LocalDateTime;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ClienteService {
    
    /*public Cliente insert(Cliente cliente){
        return new ClienteRepositoryImp(EntityManagerUtil.getManager()).insert(cliente);
    }
    */
    public ClienteResponseDTO findById(Integer id) throws ApiException, InterruptedException {
        final ClienteResponseDTO[] clienteDTO = new ClienteResponseDTO[1];
        final CountDownLatch latch = new CountDownLatch(1);
        final Throwable[] throwable = new Throwable[1];

        Call<ClienteResponseDTO> call = new RetrofitConfig()
                .clienteRequest().findById(id,"Bearer "+ PDVUtils.acessToken);
        call.enqueue(new Callback<ClienteResponseDTO>(){
            @Override
            public void onResponse(Call<ClienteResponseDTO> call, Response<ClienteResponseDTO> response) {
                Integer code =  response.code();
                ApiLoggerUtils.logOperation(LocalDateTime.now(), " GET(findById) - CLIENTE ", code.toString());
                
                if (response.isSuccessful()) {                 
                    clienteDTO[0] = response.body();
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
            public void onFailure(Call<ClienteResponseDTO> call, Throwable t) {
                Integer code = 500;
                ApiLoggerUtils.logOperation(LocalDateTime.now(), " GET(findById) - CLIENTE ", code.toString() + " - " + t.getMessage());
                throwable[0] = new ApiException("Tempo esgotado: Nenhum retorno recebido do host!");
                latch.countDown();
            }
        });

        latch.await(); // Espera até que a chamada assíncrona seja concluída

        if (throwable[0] != null) {
            throw (ApiException) throwable[0];
        }

        return clienteDTO[0];
    }

    public List<ClienteResponseDTO> findAll() throws ApiException, InterruptedException {
        final List<ClienteResponseDTO>[] clienteList = new List[1];
        final CountDownLatch latch = new CountDownLatch(1);
        final Throwable[] throwable = new Throwable[1];

        Call<List<ClienteResponseDTO>> call = new RetrofitConfig()
                .clienteRequest().findAll("Bearer "+ PDVUtils.acessToken);
        call.enqueue(new Callback<List<ClienteResponseDTO>>() {
            @Override
            public void onResponse(Call<List<ClienteResponseDTO>> call, Response<List<ClienteResponseDTO>> response) {
                Integer code =  response.code();
                ApiLoggerUtils.logOperation(LocalDateTime.now(), " GET(findAll) - CLIENTE ", code.toString());
                
                if (response.isSuccessful()) {
                    clienteList[0] = response.body();
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
            public void onFailure(Call<List<ClienteResponseDTO>> call, Throwable t) {
                Integer code = 500;
                ApiLoggerUtils.logOperation(LocalDateTime.now(), " GET(findAll) - CLIENTE ", code.toString() + " - " + t.getMessage());
                throwable[0] = new ApiException("Tempo esgotado: Nenhum retorno recebido do host!");
                latch.countDown();
            }
        });

        latch.await(); // Espera até que a chamada assíncrona seja concluída

        if (throwable[0] != null) {
            throw (ApiException) throwable[0];
        }

        return clienteList[0];
    }

//    public List<ClienteResponseDTO> findByName(String name) throws ApiException, InterruptedException {
//        final List<ClienteResponseDTO>[] clienteList = new List[1];
//        final CountDownLatch latch = new CountDownLatch(1);
//        final Throwable[] throwable = new Throwable[1];
//
//        Call<List<ClienteResponseDTO>> call = new RetrofitConfig()
//                .clienteRequest().findByName(name,"Bearer " + PDVUtils.acessToken);
//        call.enqueue(new Callback<List<ClienteResponseDTO>>() {
//            @Override
//            public void onResponse(Call<List<ClienteResponseDTO>> call, Response<List<ClienteResponseDTO>> response) {
//                Integer code =  response.code();
//                ApiLoggerUtils.logOperation(LocalDateTime.now(), " GET(findByName) - CLIENTE ", code.toString());
//                
//                if (response.isSuccessful()) {
//                    clienteList[0] = response.body();
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
//            public void onFailure(Call<List<ClienteResponseDTO>> call, Throwable t) {
//                Integer code = 500;
//                ApiLoggerUtils.logOperation(LocalDateTime.now(), " GET(findByName) - CLIENTE ", code.toString() + " - " + t.getMessage());
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
//        return clienteList[0];
//        
//    }
    
}
