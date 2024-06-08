package com.mycompany.app.pdv.resquestApi;

import com.mycompany.app.pdv.dtos.request.VendaRequestDTO;
import com.mycompany.app.pdv.dtos.response.VendaResponseDTO;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


/**
 *
 * @author Antony
 */
public interface IVendaRequest {
    @POST("venda")
    Call<VendaResponseDTO> insert(@Body VendaRequestDTO venda, @Header("Authorization") String token);
    
    @POST("venda/calc")
    Call<VendaResponseDTO> doCalc(@Body VendaRequestDTO venda, @Header("Authorization") String token);
    
    @GET("venda/all")
    Call<List<VendaResponseDTO>> findAll(@Header("Authorization") String token);
}
