package org.example.pdvapi.service;


import org.example.pdvapi.entities.Produto;
import org.example.pdvapi.repositories.ProdutoRepository;
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

    public Produto getById(Long id) {
        Optional<Produto> produto = repository.findById(id);
        return produto.orElse(null);
    }
    
    public List<Produto> getAll() {
        return repository.findAll();
    }

    public Produto update(Produto produto) {
        return repository.save(produto);
    }

    public List<Produto> findByNome(String nome) {
        return repository.findByNomeIsContainingIgnoreCase(nome);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
