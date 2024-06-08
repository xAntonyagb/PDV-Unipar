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
import org.example.pdvapi.dtos.response.ProdutoResponseDTO;
import org.example.pdvapi.exceptions.NotFoundException;
import org.example.pdvapi.service.ProdutoService;
import org.example.pdvapi.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SecuritySchemes(value = {
        @SecurityScheme(
                name = "token",
                type = SecuritySchemeType.HTTP,
                scheme = "bearer",
                bearerFormat = "JWT"
        ) }
)

@RestController
@RequestMapping("/produto")
@Tag(name = "Produto", description = "Operações relacionadas a produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    {@Content(mediaType = "application/json", schema =
                    @Schema(implementation = Cliente.class))}),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "401", description = "Usuário não autorizado / Credenciais inválidas",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(summary = "Busca um produto pelo ID")
    @SecurityRequirement(name = "token")

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> getById(@PathVariable int id) throws NotFoundException {
        return ResponseEntity.ok(produtoService.getById(id));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    {@Content(mediaType = "application/json", schema =
                    @Schema(implementation = Cliente.class))}),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "401", description = "Usuário não autorizado / Credenciais inválidas",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(summary = "Busca todos os produtos")
    @SecurityRequirement(name = "token")

    @GetMapping("/all")
    public ResponseEntity<List<ProdutoResponseDTO>> getAll() throws NotFoundException {
        return ResponseEntity.ok(produtoService.getAll());
    }

}
