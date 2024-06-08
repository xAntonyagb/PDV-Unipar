package org.example.pdvapi.service;


import org.example.pdvapi.dtos.response.ProdutoResponseDTO;
import org.example.pdvapi.entities.Produto;
import org.example.pdvapi.exceptions.NotFoundException;
import org.example.pdvapi.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public ProdutoResponseDTO getById(int id) throws NotFoundException {
        Optional<Produto> produto = repository.findById(id);
        if (produto.isEmpty()) {
            throw new NotFoundException("Produto não encontrado");
        }
        return new  ProdutoResponseDTO().fromEntity(produto.get());
    }
    
    public List<ProdutoResponseDTO> getAll() throws NotFoundException{
        List<Produto> produtos = repository.findAll();
        if (produtos.isEmpty()) {
            throw new NotFoundException("Nenhum produto foi encontrado");
        }
        return new ProdutoResponseDTO().fromEntityList(produtos);
    }

    public List<ProdutoResponseDTO> findByNome(String descricao)  throws NotFoundException{
        Optional<List<Produto>> produtos = repository.findByDescricaoContainingIgnoreCase(descricao);
        if (produtos.isEmpty()) {
            throw new NotFoundException("Produto não encontrado");
        }
        return new ProdutoResponseDTO().fromEntityList(produtos.get());
    }
}
