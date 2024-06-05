package org.example.pdvapi.service;


import org.example.pdvapi.entities.ItemVenda;
import org.example.pdvapi.repositories.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository repository;

    public ItemVenda insert(ItemVenda itemVenda) {
        return repository.save(itemVenda);
    }

    public ItemVenda getById(int id) {
        Optional<ItemVenda> itemVenda = repository.findById(id);
        return itemVenda.orElse(null);
    }

    public List<ItemVenda> getAll() {
        return repository.findAll();
    }

    public ItemVenda update(ItemVenda itemVenda) {
        return repository.save(itemVenda);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
