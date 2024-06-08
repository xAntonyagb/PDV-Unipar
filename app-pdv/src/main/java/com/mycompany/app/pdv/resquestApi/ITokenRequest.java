package com.mycompany.app.pdv.resquestApi;

import com.mycompany.app.pdv.dtos.response.TokenResponseDTO;
import com.mycompany.app.pdv.dtos.request.TokenRequestDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 *
 * @author gabri
 */
public interface ITokenRequest {
    @POST("login")
    Call<TokenResponseDTO> login(@Body TokenRequestDTO usuarioDTO);
}
