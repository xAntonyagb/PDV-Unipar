package org.example.pdvapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.pdvapi.enums.CategoriaEnum;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotBlank
    @NotEmpty
    @Length(min = 5, max = 60)
    private String descricao;
    @NotNull
    @NotBlank
    @NotEmpty
    private double preco;

    private CategoriaEnum categoria;

    public Produto() {
    }

    public Produto(int id, String descricao, double preco, CategoriaEnum categoria) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull @NotBlank @NotEmpty @Length(min = 5, max = 60) String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull @NotBlank @NotEmpty @Length(min = 5, max = 60) String descricao) {
        this.descricao = descricao;
    }

    @NotNull
    @NotBlank
    @NotEmpty
    public double getPreco() {
        return preco;
    }

    public void setPreco(@NotNull @NotBlank @NotEmpty double preco) {
        this.preco = preco;
    }

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }
}
