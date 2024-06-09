package org.example.pdvapi.dtos.request;

import jakarta.validation.constraints.NotNull;

/**
 *
 * @author gabri
 */
public class TokenRequestDTO {
    @NotNull
    private String username;
    @NotNull
    private String password;

    public TokenRequestDTO() {
    }

    public TokenRequestDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
