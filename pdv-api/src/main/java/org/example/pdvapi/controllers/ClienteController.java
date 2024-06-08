package org.example.pdvapi.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.pdvapi.dtos.response.ClienteResponseDTO;
import org.example.pdvapi.service.ClienteService;
import org.example.pdvapi.entities.Cliente;
import org.example.pdvapi.repositories.ClienteRepository;
import org.example.pdvapi.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@SecuritySchemes(value = {
        @SecurityScheme(
                name = "token",
                type = SecuritySchemeType.HTTP,
                scheme = "bearer",
                bearerFormat = "JWT"
        ) }
)

@RestController
@RequestMapping("/cliente")
@Tag(name = "Cliente", description = "Operações relacionadas a clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = Cliente.class)) }),
            @ApiResponse(responseCode = "401", description = "Usuário não autorizado / Credenciais inválidas",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(summary = "Busca um cliente pelo ID")
    @SecurityRequirement(name = "token")

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> getById(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(clienteService.getById(id));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = Cliente.class)) }),
            @ApiResponse(responseCode = "401", description = "Usuário não autorizado / Credenciais inválidas",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(summary = "Busca todos os clientes")
    @SecurityRequirement(name = "token")

    @GetMapping("/all")
    public ResponseEntity<List<ClienteResponseDTO>> getAll()  throws Exception{
        return ResponseEntity.ok(clienteService.getAll());

    }

}
