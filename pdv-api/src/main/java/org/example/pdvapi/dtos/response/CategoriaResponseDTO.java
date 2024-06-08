package org.example.pdvapi.dtos.response;

import org.example.pdvapi.entities.Categoria;

/**
 *
 * @author Antony
 */
public class CategoriaResponseDTO {
    private long id;
    private String descricao;

    public CategoriaResponseDTO() {
    }

    public CategoriaResponseDTO(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "CategoriaDTO{" + "id=" + id + ", descricao=" + descricao + '}';
    }

    public CategoriaResponseDTO fromEntity(Categoria categoria) {
        return new CategoriaResponseDTO(categoria.getId(), categoria.getDescricao());
    }
}
