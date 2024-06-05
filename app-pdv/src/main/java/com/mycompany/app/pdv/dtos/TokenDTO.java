package com.mycompany.app.pdv.dtos;

import java.time.Instant;

/**
 *
 * @author Antony
 */
public class TokenDTO {
    private String acessToken;
    private long expiresIn;
    private Instant createdAt;

    public TokenDTO() {
    }

    public TokenDTO(String acessToken, long expiresIn, Instant createdAt) {
        this.acessToken = acessToken;
        this.expiresIn = expiresIn;
        this.createdAt = createdAt;
    }

    public String getAcessToken() {
        return acessToken;
    }

    public void setAcessToken(String acessToken) {
        this.acessToken = acessToken;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = Instant.parse(createdAt);
    }

    @Override
    public String toString() {
        return "TokenDTO{" + "acessToken=" + acessToken + ", expiresIn=" + expiresIn + ", createdAt=" + createdAt + '}';
    }
    
}
