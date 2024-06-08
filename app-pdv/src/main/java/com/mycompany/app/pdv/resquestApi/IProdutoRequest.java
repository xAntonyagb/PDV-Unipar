package com.mycompany.app.pdv.resquestApi;

import com.mycompany.app.pdv.dtos.response.ProdutoResponseDTO;
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
    Call<ProdutoResponseDTO> findById(@Path("id") Integer id, @Header("Authorization") String token);

    @GET("produto/all")
    Call<List<ProdutoResponseDTO>> findAll(@Header("Authorization")String token);

    @GET("produto/{descricao}")
    Call<List<ProdutoResponseDTO>> findByDesc(@Path("descricao") String descricao, @Header("Authorization") String token);
    
}
