package com.mycompany.app.pdv.services;

import com.mycompany.app.pdv.dtos.ProdutoDTO;
import com.mycompany.app.pdv.exceptions.ApiException;
import com.mycompany.app.pdv.retrofit.RetrofitConfig;
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
                if (response.isSuccessful()) {
                    produtoDTO[0] = response.body();
                } 
                latch.countDown();
            }

            @Override
            public void onFailure(Call<ProdutoDTO> call, Throwable t) {
                throwable[0] = new ApiException(t);
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
                .produtoRequest().findAll(token);
        call.enqueue(new Callback<List<ProdutoDTO>>() {
            @Override
            public void onResponse(Call<List<ProdutoDTO>> call, Response<List<ProdutoDTO>> response) {
                if (response.isSuccessful()) {
                    produtoList[0] = response.body();
                }
                latch.countDown();
            }

            @Override
            public void onFailure(Call<List<ProdutoDTO>> call, Throwable t) {
                throwable[0] = new ApiException(t);
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
                if (response.isSuccessful()) {
                    produtoList[0] = response.body();
                }
                latch.countDown();
            }

            @Override
            public void onFailure(Call<List<ProdutoDTO>> call, Throwable t) {
                throwable[0] = new ApiException(t);
                latch.countDown();
            }
        });

        latch.await(); // Espera até que a chamada assíncrona seja concluída

        if (throwable[0] != null) {
            throw (ApiException) throwable[0];
        }

        return produtoList[0];
    }    
    /*public Produto insert(Produto produto){
         return new ProdutoRepositoryImp(EntityManagerUtil.getManager()).insert(produto);
     }*/
     /*
     public Produto update(Produto produto){
         return new ProdutoRepositoryImp(EntityManagerUtil.getManager()).update(produto);
     }
     
     public boolean delete(Produto produto){
         return new ProdutoRepositoryImp(EntityManagerUtil.getManager()).delete(produto);
     }*/
}
