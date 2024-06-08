package org.example.pdvapi.dtos.response;

import java.time.Instant;

public record LoginResponseDTO (String acessToken, Long expiresIn, Instant createdAt) {

}
