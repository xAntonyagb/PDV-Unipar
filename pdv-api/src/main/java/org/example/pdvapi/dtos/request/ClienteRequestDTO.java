package org.example.pdvapi.dtos.request;


import org.example.pdvapi.dtos.response.ClienteResponseDTO;
import org.example.pdvapi.entities.Cliente;

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
