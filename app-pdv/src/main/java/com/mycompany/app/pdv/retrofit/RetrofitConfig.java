package com.mycompany.app.pdv.retrofit;


import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import com.mycompany.app.pdv.resquestApi.IClienteRequest;
import com.mycompany.app.pdv.resquestApi.IProdutoRequest;
import com.mycompany.app.pdv.resquestApi.ITokenRequest;

public class RetrofitConfig {

    private Retrofit retrofit;
    private static final String BASE_URL = "http://localhost:8080/";

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

    }

    public IClienteRequest clienteRequest(){
        return this.retrofit.create(IClienteRequest.class);
    }
    
    public IProdutoRequest produtoRequest(){
        return this.retrofit.create(IProdutoRequest.class);
    }

    public ITokenRequest tokenRequest(){
        return this.retrofit.create(ITokenRequest.class);
        
    } 

}
