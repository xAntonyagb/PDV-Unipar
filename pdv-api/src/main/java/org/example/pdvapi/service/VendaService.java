package org.example.pdvapi.service;


import org.example.pdvapi.entities.Venda;
import org.example.pdvapi.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    public Venda insert(Venda venda) {
        return repository.save(venda);
    }

    public Venda getById(Long id) {
        Optional<Venda> venda = repository.findById(id);
        return venda.orElse(null);
    }
    
    public List<Venda> getAll() {
        return repository.findAll();
    }

    public Venda update(Venda venda) {
        return repository.save(venda);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
