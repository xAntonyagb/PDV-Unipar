package org.example.pdvapi.service;


import org.example.pdvapi.dtos.ItemVendaDTO;
import org.example.pdvapi.dtos.VendaDTO;
import org.example.pdvapi.entities.Cliente;
import org.example.pdvapi.entities.Produto;
import org.example.pdvapi.repositories.ClienteRepository;
import org.example.pdvapi.repositories.ProdutoRepository;
import org.example.pdvapi.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public Produto insert(Produto produto) {
        return repository.save(produto);
    }

    public Produto getById(int id) {
        Optional<Produto> produto = repository.findById(id);
        return produto.orElse(null);
    }
    
    public List<Produto> getAll() {
        return repository.findAll();
    }

    public List<Produto> findByNome(String descricao) {
        Optional<List<Produto>> produtos = repository.findByDescricaoContainingIgnoreCase(descricao);
        return produtos.orElse(null);
    }
}
