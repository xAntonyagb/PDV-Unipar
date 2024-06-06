package com.mycompany.app.pdv.services;

import com.mycompany.app.pdv.exceptions.ApiException;
import com.mycompany.app.pdv.dtos.ClienteDTO;
import com.mycompany.app.pdv.retrofit.RetrofitConfig;

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
    public ClienteDTO findById(Integer id, String token) throws ApiException, InterruptedException {
        final ClienteDTO[] clienteDTO = new ClienteDTO[1];
        final CountDownLatch latch = new CountDownLatch(1);
        final Throwable[] throwable = new Throwable[1];

        Call<ClienteDTO> call = new RetrofitConfig()
                .clienteRequest().findById(id,"Bearer "+ token);
        call.enqueue(new Callback<ClienteDTO>(){
            @Override
            public void onResponse(Call<ClienteDTO> call, Response<ClienteDTO> response) {
                if (response.isSuccessful()) {
                    clienteDTO[0] = response.body();
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
            public void onFailure(Call<ClienteDTO> call, Throwable t) {
                throwable[0] = new ApiException(t);
                latch.countDown();
            }
        });

        latch.await(); // Espera até que a chamada assíncrona seja concluída

        if (throwable[0] != null) {
            throw (ApiException) throwable[0];
        }

        return clienteDTO[0];
    }

    public List<ClienteDTO> findAll(String token) throws ApiException, InterruptedException {
        final List<ClienteDTO>[] clienteList = new List[1];
        final CountDownLatch latch = new CountDownLatch(1);
        final Throwable[] throwable = new Throwable[1];

        Call<List<ClienteDTO>> call = new RetrofitConfig()
                .clienteRequest().findAll("Bearer "+ token);
        call.enqueue(new Callback<List<ClienteDTO>>() {
            @Override
            public void onResponse(Call<List<ClienteDTO>> call, Response<List<ClienteDTO>> response) {
                if (response.isSuccessful()) {
                    clienteList[0] = response.body();
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
            public void onFailure(Call<List<ClienteDTO>> call, Throwable t) {
                throwable[0] = new ApiException(t);
                latch.countDown();
            }
        });

        latch.await(); // Espera até que a chamada assíncrona seja concluída

        if (throwable[0] != null) {
            throw (ApiException) throwable[0];
        }

        return clienteList[0];
    }

    public List<ClienteDTO> findByName(String name, String token) throws ApiException, InterruptedException {
        final List<ClienteDTO>[] clienteList = new List[1];
        final CountDownLatch latch = new CountDownLatch(1);
        final Throwable[] throwable = new Throwable[1];

        Call<List<ClienteDTO>> call = new RetrofitConfig()
                .clienteRequest().findByName(name,"Bearer " + token);
        call.enqueue(new Callback<List<ClienteDTO>>() {
            @Override
            public void onResponse(Call<List<ClienteDTO>> call, Response<List<ClienteDTO>> response) {
                if (response.isSuccessful()) {
                    clienteList[0] = response.body();
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
            public void onFailure(Call<List<ClienteDTO>> call, Throwable t) {
                throwable[0] = new ApiException(t);
                latch.countDown();
            }
        });

        latch.await(); // Espera até que a chamada assíncrona seja concluída

        if (throwable[0] != null) {
            throw (ApiException) throwable[0];
        }

        return clienteList[0];
        
    }
    /*
    public Cliente update(Cliente cliente){
        return new ClienteRepositoryImp(EntityManagerUtil.getManager()).update(cliente);
    }
    
    public boolean delete(Cliente cliente){
        return new ClienteRepositoryImp(EntityManagerUtil.getManager()).delete(cliente);
    }*/
}
