package com.mycompany.app.pdv.services;

import com.mycompany.app.pdv.dtos.TokenDTO;
import com.mycompany.app.pdv.dtos.UsuarioDTO;
import com.mycompany.app.pdv.exceptions.ApiException;
import com.mycompany.app.pdv.retrofit.RetrofitConfig;
import com.mycompany.app.pdvutils.GlobalVariables;
import java.util.concurrent.CountDownLatch;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *
 * @author Antony
 */
public class TokenService {
    
    public void doLogin(UsuarioDTO usuarioDTO) throws ApiException, InterruptedException {
        TokenDTO resposta = getToken(usuarioDTO);
        GlobalVariables.acessToken = resposta.getAcessToken();
    }
    
    private TokenDTO getToken(UsuarioDTO usuarioDTO) throws ApiException, InterruptedException {
        final TokenDTO[] tokenDTO = new TokenDTO[1];
        final CountDownLatch latch = new CountDownLatch(1);
        final Throwable[] throwable = new Throwable[1];

        Call<TokenDTO> call = new RetrofitConfig()
                .tokenRequest().login(usuarioDTO); //Informando usuário
        
        //Fazer a chamada
        call.enqueue(new Callback<TokenDTO>() {
            @Override
            public void onResponse(Call<TokenDTO> call, Response<TokenDTO> response) {
                if (response.isSuccessful()) {
                    tokenDTO[0] = response.body();
                } else {
                    if(response.code() == 401) {
                        throwable[0] = new ApiException(response.code() + ": Usuário ou senha incorretos!");
                    } else {
                        throwable[0] = new ApiException(new Throwable("Error: " + response.code()));
                    }
                }
                latch.countDown();
            }

            @Override
            public void onFailure(Call<TokenDTO> call, Throwable t) {
                throwable[0] = new ApiException(t);
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
