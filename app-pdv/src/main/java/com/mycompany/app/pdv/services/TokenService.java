package com.mycompany.app.pdv.services;

import com.mycompany.app.pdv.dtos.response.TokenResponseDTO;
import com.mycompany.app.pdv.dtos.request.TokenRequestDTO;
import com.mycompany.app.pdv.exceptions.ApiException;
import com.mycompany.app.pdv.retrofit.RetrofitConfig;
import com.mycompany.app.pdvutils.ApiLogger;
import com.mycompany.app.pdvutils.GlobalVariables;
import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * @author Antony
 */
public class TokenService {
    
    public void doLogin(TokenRequestDTO usuarioDTO) throws ApiException, InterruptedException {
        TokenResponseDTO resposta = getToken(usuarioDTO);
        GlobalVariables.acessToken = resposta.getAcessToken();
    }
    
    private TokenResponseDTO getToken(TokenRequestDTO usuarioDTO) throws ApiException, InterruptedException {
        final TokenResponseDTO[] tokenDTO = new TokenResponseDTO[1];
        final CountDownLatch latch = new CountDownLatch(1);
        final Throwable[] throwable = new Throwable[1];

        Call<TokenResponseDTO> call = new RetrofitConfig()
                .tokenRequest().login(usuarioDTO); //Informando usuário
        
        //Fazer a chamada
        call.enqueue(new Callback<TokenResponseDTO>() {
            @Override
            public void onResponse(Call<TokenResponseDTO> call, Response<TokenResponseDTO> response) {
                Integer code =  response.code();
                ApiLogger.logOperation(LocalDateTime.now(), " GET(getToken) - LOGIN ", code.toString());
                
                if (response.isSuccessful()) {
                    tokenDTO[0] = response.body();
                } else {
                    if(response.code() == 401) {
                        throwable[0] = new ApiException(response.code() + ": Usuário ou senha incorretos!");
                    } else {
                        throwable[0] = new ApiException(new Throwable(
                                "Erro: " + response.code() + 
                                "\nMensagem:"+ response.message()));
                    }
                }
                latch.countDown();
            }

            @Override
            public void onFailure(Call<TokenResponseDTO> call, Throwable t) {
                Integer code = 500;
                ApiLogger.logOperation(LocalDateTime.now(), " GET(getToken) - LOGIN ", code.toString() + " - " + t.getMessage());
                
                throwable[0] = new ApiException("Tempo esgotado: Nenhum retorno recebido do host!");
                latch.countDown();
            }
        });

        latch.await(); // Espera até que a chamada assíncrona seja concluída

        if (throwable[0] != null) {
            throw (ApiException) throwable[0];
        }

        return tokenDTO[0];
    }
}
