package org.example.pdvapi.controllers;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.example.pdvapi.entities.ItemVenda;
import org.example.pdvapi.service.ItemVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/itemvenda")
public class ItemVendaController {

    @Autowired
    private ItemVendaService itemVendaService;


    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "ItemVenda criado com sucesso",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ItemVenda.class)) }),
            @ApiResponse(responseCode = "400", description = "Erro na requisição") })
    @PostMapping
    public ResponseEntity<ItemVenda> insert(@RequestBody @Valid ItemVenda itemVenda) {
        itemVendaService.insert(itemVenda);

        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequest().path("/{id}").
                buildAndExpand(itemVenda.getId()).toUri();

        return ResponseEntity.created(uri).body(itemVenda);
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ItemVenda encontrado com sucesso",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ItemVenda.class)) }),
            @ApiResponse(responseCode = "404", description = "ItemVenda não encontrado") })
    @GetMapping("/{id}")
    public ResponseEntity<ItemVenda> getById(@PathVariable Long id) {
        return ResponseEntity.ok(itemVendaService.getById(id));
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ItemVenda(s) encontrado(s) com sucesso",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ItemVenda.class)) }),
            @ApiResponse(responseCode = "404", description = "Nenhum ItemVenda encontrado") })
    @GetMapping("/all")
    public ResponseEntity<List<ItemVenda>> getAll() {
        return ResponseEntity.ok(itemVendaService.getAll());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "ItemVenda atualizado com sucesso",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ItemVenda.class)) }),
            @ApiResponse(responseCode = "404", description = "ItemVenda não encontrado") })
    @PutMapping("/{id}")
    public ResponseEntity<ItemVenda> update(@RequestBody @Valid ItemVenda itemVenda, @PathVariable int id) {
        itemVenda.setId(id);
        return ResponseEntity.ok(itemVendaService.update(itemVenda));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "ItemVenda deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "ItemVenda não encontrado") })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        itemVendaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
