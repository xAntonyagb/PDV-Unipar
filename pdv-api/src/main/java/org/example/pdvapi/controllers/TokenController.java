package org.example.pdvapi.controllers;

import org.example.pdvapi.dtos.LoginRequestDTO;
import org.example.pdvapi.dtos.LoginResponseDTO;
import org.example.pdvapi.entities.Role;
import org.example.pdvapi.exceptions.ApiException;
import org.example.pdvapi.repositories.UserRepository;
import org.example.pdvapi.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.time.Instant;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestController
public class TokenController {
    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest)  throws ApiException{
        LoginResponseDTO loginResponseDTO = tokenService.login(loginRequest);
        return ResponseEntity.ok(loginResponseDTO);

    }
}
