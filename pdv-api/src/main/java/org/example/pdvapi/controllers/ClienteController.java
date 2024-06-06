package org.example.pdvapi.controllers;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    { @Content(mediaType = "application/json", schema =
                    @Schema(implementation = Cliente.class)) }),
            @ApiResponse(responseCode = "400", description = "ID invalido informado"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado")})

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable int id) throws Exception {
        return ResponseEntity.ok(clienteService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> getAll()  throws Exception{
        return ResponseEntity.ok(clienteService.getAll());

    }
//    @PostMapping
//    public ResponseEntity<Cliente> insert(@RequestBody @Valid Cliente cliente,
//                                          UriComponentsBuilder builder) {
//
//        clienteService.insert(cliente);
//
//        URI uri =
//                builder.path("/cliente/{id}").
//                        buildAndExpand(cliente.getId()).toUri();
//
//        return ResponseEntity.created(uri).body(cliente);
//
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Cliente> update(@PathVariable int id,
//                                          @RequestBody Cliente cliente) {
//        clienteService.update(cliente);
//
//        return ResponseEntity.ok(cliente);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        clienteService.delete(id);
//        return ResponseEntity.noContent().build();
//    }



}
