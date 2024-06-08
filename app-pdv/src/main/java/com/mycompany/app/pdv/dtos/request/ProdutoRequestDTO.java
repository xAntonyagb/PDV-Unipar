package com.mycompany.app.pdv.dtos.request;

import com.mycompany.app.pdv.dtos.response.ProdutoResponseDTO;

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

    public static ProdutoRequestDTO toRequestDTO(ProdutoResponseDTO produtoResponseDTO) {
        return new ProdutoRequestDTO(produtoResponseDTO.getId());
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
