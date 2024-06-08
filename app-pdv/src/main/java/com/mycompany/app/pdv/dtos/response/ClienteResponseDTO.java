package com.mycompany.app.pdv.dtos.response;

import com.mycompany.app.pdv.dtos.request.ClienteRequestDTO;

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

    public static ClienteResponseDTO toResponseDTO(ClienteRequestDTO clienteRequestDTO) {
        ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();
        clienteResponseDTO.setId(clienteRequestDTO.getId());

        return clienteResponseDTO;
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
    
    

    
    
    
}
