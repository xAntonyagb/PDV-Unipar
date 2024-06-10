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
import org.example.pdvapi.dtos.request.VendaRequestDTO;
import org.example.pdvapi.dtos.response.VendaResponseDTO;
import org.example.pdvapi.exceptions.NotFoundException;
import org.example.pdvapi.exceptions.ValidationException;
import org.example.pdvapi.service.VendaService;
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
@RequestMapping("/venda")
@Tag(name = "Venda", description = "Operações relacionadas a vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;


    // ----------------------------- CALCULAR VENDA -----------------------------
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = VendaRequestDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Venda fora de padrão ou inválida",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "401", description = "Usuário não autorizado / Credenciais inválidas",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Itens da venda / Cliente não encontrados",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(summary = "Valida e calcula o valor total de uma venda")
    @SecurityRequirement(name = "token")

    @PostMapping("/calc")

    public ResponseEntity<VendaResponseDTO> doCalc(@RequestBody VendaRequestDTO vendaRequestDTO) throws ValidationException, NotFoundException {
        VendaResponseDTO vendaResponseDTO = new VendaResponseDTO();
        vendaResponseDTO = vendaService.doCalc(vendaRequestDTO);
        return ResponseEntity.ok(vendaResponseDTO);
    }


    // ----------------------------- FINALIZAR/INSERIR VENDA -----------------------------
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json", schema =

                    @Schema(implementation = VendaRequestDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Venda fora de padrão ou inválida",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "401", description = "Usuário não autorizado / Credenciais inválidas",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Itens da venda / Cliente não encontrados",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                    content = { @Content(mediaType = "application/json") })
    })
    @Operation(summary = "Valida, finaliza e insere a venda")
    @SecurityRequirement(name = "token")

    @PostMapping
    public ResponseEntity<VendaResponseDTO> insert(@RequestBody VendaRequestDTO vendaRequestDTO) throws ValidationException, NotFoundException {
        VendaResponseDTO vendaResponseDTO = new VendaResponseDTO();
        vendaResponseDTO = vendaService.insert(vendaRequestDTO);
        return ResponseEntity.ok(vendaResponseDTO);
    }
    // ----------------------------- RETORNAR VENDAS -----------------------------
    @Operation(summary = "Retorna todas as vendas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = VendaResponseDTO.class)) }),
            @ApiResponse(responseCode = "400", description = "Venda fora de padrão ou inválida",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "401", description = "Usuário não autorizado / Credenciais inválidas",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Itens da venda / Cliente não encontrados",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor",
                    content = { @Content(mediaType = "application/json") })
    })
    @SecurityRequirement(name = "token")
    @GetMapping ("/all")
    public ResponseEntity<List<VendaResponseDTO>> findAll() {
        return ResponseEntity.ok(vendaService.findAll());
    }

}
