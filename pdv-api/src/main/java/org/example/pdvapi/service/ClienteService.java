package org.example.pdvapi.service;


import org.example.pdvapi.dtos.response.ClienteResponseDTO;
import org.example.pdvapi.entities.Cliente;
import org.example.pdvapi.exceptions.NotFoundException;
import org.example.pdvapi.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ClienteResponseDTO getById(int id) throws NotFoundException {
        Optional<Cliente> cliente = repository.findById(id);
        if (cliente.isEmpty()) {
            throw new NotFoundException("Cliente não encontrado");
        }
        return new ClienteResponseDTO().fromEntity(cliente.get());
    }
    
    public List<ClienteResponseDTO> getAll() throws NotFoundException{
        List<Cliente> clientes = repository.findAll();
        if (clientes.isEmpty()) {
            throw new NotFoundException("Nenhum cliente foi encontrado");
        }
        return new ClienteResponseDTO().fromEntityList(clientes);
    }

    public List<ClienteResponseDTO> findByNome(String nome) throws NotFoundException{
        List<Cliente> clientes = repository.findByNomeIsContainingIgnoreCase(nome);
        if (clientes.isEmpty()) {
            throw new NotFoundException("Nenhum cliente foi encontrado");
        }
        return new ClienteResponseDTO().fromEntityList(clientes);
    }

}
