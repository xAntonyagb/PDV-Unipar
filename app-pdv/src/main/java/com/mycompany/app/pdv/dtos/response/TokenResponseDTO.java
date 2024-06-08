package com.mycompany.app.pdv.dtos.response;

import com.mycompany.app.pdv.utils.TimeUtils;
import java.sql.Timestamp;

/**
 *
 * @author Antony
 */
public class TokenResponseDTO {
    private String acessToken;
    private long expiresIn;
    private Timestamp createdAt;

    public TokenResponseDTO() {
    }

    public TokenResponseDTO(String acessToken, long expiresIn, Timestamp createdAt) {
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = TimeUtils.stringToTimestamp(createdAt);
    }

    @Override
    public String toString() {
        return "TokenDTO{" + "acessToken=" + acessToken + ", expiresIn=" + expiresIn + ", createdAt=" + createdAt + '}';
    }
    
}
