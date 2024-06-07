package org.example.pdvapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.pdvapi.dtos.LoginRequestDTO;
import org.example.pdvapi.dtos.LoginResponseDTO;
import org.example.pdvapi.exceptions.UnauthorizedException;
import org.example.pdvapi.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Token", description = "Operações relacionadas a tokens")
public class TokenController {
    @Autowired
    private TokenService tokenService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = LoginResponseDTO.class)) }),
            @ApiResponse(responseCode = "401", description = "Usuário não autorizado / Credenciais inválidas",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(summary = "Gera um token de autenticação apartir dos dados de login")

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) throws UnauthorizedException {
        LoginResponseDTO loginResponseDTO = tokenService.login(loginRequest);
        return ResponseEntity.ok(loginResponseDTO);
    }
}
