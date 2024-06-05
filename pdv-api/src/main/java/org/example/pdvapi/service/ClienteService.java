package org.example.pdvapi.service;


import org.example.pdvapi.entities.Cliente;
import org.example.pdvapi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente insert(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente getById(int id) {
        Optional<Cliente> cliente = repository.findById(id);
        return cliente.orElse(null);
    }
    
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    public Cliente update(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> findByNome(String nome) {
        return repository.findByNomeIsContainingIgnoreCase(nome);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
