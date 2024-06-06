package org.example.pdvapi.controllers;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.example.pdvapi.dtos.ProdutoDTO;
import org.example.pdvapi.exceptions.NotFoundException;
import org.example.pdvapi.service.ProdutoService;
import org.example.pdvapi.entities.Cliente;
import org.example.pdvapi.entities.Produto;
import org.example.pdvapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content =
                    {@Content(mediaType = "application/json", schema =
                    @Schema(implementation = Cliente.class))}),
            @ApiResponse(responseCode = "400", description = "ID invalido informado"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
    })


    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getById(@PathVariable int id) throws NotFoundException {
        ProdutoDTO produto = ProdutoDTO.toDTO(produtoService.getById(id));
        return ResponseEntity.ok(produto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProdutoDTO>> getAll() throws NotFoundException {
        List<ProdutoDTO> produtos = ProdutoDTO.toDTOList(produtoService.getAll());
        return ResponseEntity.ok(produtos);
    }

//    @PostMapping
//    public ResponseEntity<Produto> insert(@RequestBody @Valid Produto produto,
//                                          UriComponentsBuilder builder) {
//
//        produtoService.insert(produto);
//
//        URI uri =
//                builder.path("/produto/{id}").
//                        buildAndExpand(produto.getId()).toUri();
//
//        return ResponseEntity.created(uri).body(produto);
//
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Produto> update(@PathVariable int id,
//                                          @RequestBody Produto produto) {
//        produtoService.update(produto);
//
//        return ResponseEntity.ok(produto);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        produtoService.delete(id);
//        return ResponseEntity.noContent().build();
//    }


}
