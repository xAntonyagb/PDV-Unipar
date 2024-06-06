package com.mycompany.app.pdv.dtos;

/**
 *
 * @author Antony
 */
public class CategoriaDTO {
    private long id;
    private String descricao;

    public CategoriaDTO() {
    }

    public CategoriaDTO(long id, String descricao) {
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
    
    
}
