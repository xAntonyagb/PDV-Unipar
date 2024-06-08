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
import org.example.pdvapi.dtos.VendaDTO;
import org.example.pdvapi.exceptions.NotFoundException;
import org.example.pdvapi.exceptions.ValidationException;
import org.example.pdvapi.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
                    @Schema(implementation = VendaDTO.class)) }),
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
    public ResponseEntity<VendaDTO> doCalc(@RequestBody VendaDTO vendaDTO) throws ValidationException, NotFoundException {
        vendaDTO = vendaService.doCalc(vendaDTO);
        return ResponseEntity.ok(vendaDTO);
    }


    // ----------------------------- FINALIZAR/INSERIR VENDA -----------------------------
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = VendaDTO.class)) }),
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
    public ResponseEntity<VendaDTO> insert(@RequestBody VendaDTO vendaDTO) throws ValidationException, NotFoundException {
        vendaDTO = vendaService.insert(vendaDTO);
        return ResponseEntity.ok(vendaDTO);

    }

}
