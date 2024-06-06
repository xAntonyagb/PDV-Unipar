package org.example.pdvapi.controllers;

import org.example.pdvapi.dtos.LoginRequestDTO;
import org.example.pdvapi.dtos.LoginResponseDTO;
import org.example.pdvapi.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {
    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest)  throws Exception{
        LoginResponseDTO loginResponseDTO = tokenService.login(loginRequest);
        return ResponseEntity.ok(loginResponseDTO);
    }
}
