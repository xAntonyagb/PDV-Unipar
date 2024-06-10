package com.mycompany.app.pdv.resquestApi;


import com.mycompany.app.pdv.dtos.response.ClienteResponseDTO;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface IClienteRequest {

    @GET("cliente/{id}")
    Call<ClienteResponseDTO> findById(@Path("id")int id, @Header("Authorization")String token);
    
    @GET("cliente/all")
    Call<List<ClienteResponseDTO>> findAll(@Header("Authorization")String token);
    
//    @GET("cliente/{name}")
//    Call<List<ClienteResponseDTO>> findByName(@Path("name") String nome, @Header("Authorization") String token);
}
