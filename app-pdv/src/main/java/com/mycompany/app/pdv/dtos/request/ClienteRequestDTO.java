package com.mycompany.app.pdv.dtos.request;

import com.mycompany.app.pdv.dtos.response.ClienteResponseDTO;

/**
 *
 * @author Antony
 */
public class ClienteRequestDTO {
    
    private int id;

    
    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(int id) {
        this.id = id;
    }

    public static ClienteRequestDTO toRequestDTO(ClienteResponseDTO clienteResponseDTO) {
        return new ClienteRequestDTO(
                clienteResponseDTO.getId());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ClienteRequest{" + "id=" + id + '}';
    }


}
