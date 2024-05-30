/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app.pdv.resquestApi;


import com.mycompany.app.pdv.dtos.TokenDTO;
import com.mycompany.app.pdv.dtos.UsuarioDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 *
 * @author gabri
 */
public interface ITokenRequest {
    @POST("login")
    Call<TokenDTO> login(@Body UsuarioDTO usuarioDTO);
}
