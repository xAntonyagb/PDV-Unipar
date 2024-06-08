package org.example.pdvapi.dtos.request;


import org.example.pdvapi.dtos.response.ProdutoResponseDTO;

/**
 *
 * @author Antony
 */
public class ProdutoRequestDTO {

    private int id;

    public ProdutoRequestDTO() {
    }

    public ProdutoRequestDTO(int id) {
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
