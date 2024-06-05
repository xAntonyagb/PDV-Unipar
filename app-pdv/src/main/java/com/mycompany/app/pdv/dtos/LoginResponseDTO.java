/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app.pdv.dtos;

/**
 *
 * @author wallg
 */
public class LoginResponseDTO {
    private String acessToken;
    private long expiresIn;

    
    public String getAcessToken() {
        return acessToken;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setAcessToken(String token) {
        this.acessToken = token;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
    
}
