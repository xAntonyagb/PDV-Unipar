package org.example.pdvapi.service;


import jakarta.annotation.PostConstruct;
import org.example.pdvapi.entities.Categoria;
import org.example.pdvapi.enums.CategoriaEnum;
import org.example.pdvapi.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    @PostConstruct
    public void initCategorias() {
        for (CategoriaEnum categoriaEnum : CategoriaEnum.values()) {
            if (!repository.existsByDescricaoIgnoreCase(categoriaEnum.name())) {
                Categoria categoria = new Categoria();
                categoria.setDescricao(categoriaEnum.name());
                repository.save(categoria);
            }
        }
    }

    public Categoria insert(Categoria categoria) {
        return repository.save(categoria);
    }

    public Categoria getById(Long id) {
        Optional<Categoria> categoria = repository.findById(id);
        return categoria.orElse(null);
    }
    
    public List<Categoria> getAll() {
        return repository.findAll();
    }

    public Categoria update(Categoria categoria) {
        return repository.save(categoria);
    }

    public List<Categoria> findByNome(String nome) {
        return repository.findByDescricaoIsContainingIgnoreCase(nome);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
