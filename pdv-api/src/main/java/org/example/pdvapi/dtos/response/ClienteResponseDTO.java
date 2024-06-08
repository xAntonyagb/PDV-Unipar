package org.example.pdvapi.dtos.response;

import org.example.pdvapi.dtos.request.ClienteRequestDTO;
import org.example.pdvapi.entities.Cliente;

import java.util.List;

public class ClienteResponseDTO {

    private int id;
    private String nome;
    private String email;
    private String telefone;

    public ClienteResponseDTO() {
    }

    public ClienteResponseDTO(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public ClienteResponseDTO fromEntity(Cliente cliente) {
        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
    }

    public List<ClienteResponseDTO> fromEntityList(List<Cliente> clientes) {
        return clientes.stream().map(this::fromEntity).toList();
    }

    public ClienteResponseDTO fromRequest(ClienteRequestDTO cliente) {
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
        clienteResponseDTO.setId(cliente.getId());
        return clienteResponseDTO;
    }

    public Cliente toEntity(ClienteResponseDTO cliente) {
        Cliente clienteEntity = new Cliente();
        clienteEntity.setId(cliente.getId());
        return clienteEntity;
    }
}
