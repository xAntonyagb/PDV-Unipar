package org.example.pdvapi.dtos;

import java.time.Instant;

public record LoginResponseDTO (String acessToken, Long expiresIn, Instant createdAt) {

}
