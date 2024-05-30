/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.app.pdv.resquestApi;

import com.mycompany.app.pdv.dtos.ProdutoDTO;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 *
 * @author gabri
 */
public interface IProdutoRequest {
    @GET("produtos/{id}")
    Call<ProdutoDTO> findById(@Path("id") Integer id, @Header("Authorization") String token);

    @GET("produto/all")
    Call<List<ProdutoDTO>> findAll(@Header("Authorization") String token);

    @GET("produto/{descricao}")
    Call<List<ProdutoDTO>> findByDesc(@Path("descricao") String descricao, @Header("Authorization") String token);
    
}
