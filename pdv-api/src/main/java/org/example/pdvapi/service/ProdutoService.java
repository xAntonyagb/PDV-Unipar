package org.example.pdvapi.service;


import org.example.pdvapi.dtos.ItemVendaDTO;
import org.example.pdvapi.dtos.VendaDTO;
import org.example.pdvapi.entities.Cliente;
import org.example.pdvapi.entities.Produto;
import org.example.pdvapi.exceptions.NotFoundException;
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

    public Produto getById(int id) throws NotFoundException {
        Optional<Produto> produto = repository.findById(id);
        if (produto.isEmpty()) {
            throw new NotFoundException("Produto não encontrado");
        }
        return produto.get();
    }
    
    public List<Produto> getAll() throws NotFoundException{
        List<Produto> produtos = repository.findAll();
        if (produtos.isEmpty()) {
            throw new NotFoundException("Nenhum produto foi encontrado");
        }
        return produtos;
    }

    public List<Produto> findByNome(String descricao)  throws NotFoundException{
        Optional<List<Produto>> produtos = repository.findByDescricaoContainingIgnoreCase(descricao);
        if (produtos.isEmpty()) {
            throw new NotFoundException("Produto não encontrado");
        }
        return produtos.get();
    }
}
