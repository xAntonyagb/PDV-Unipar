package org.example.pdvapi.dtos;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.pdvapi.entities.Categoria;
import org.example.pdvapi.entities.Produto;
import org.example.pdvapi.enums.CategoriaEnum;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class ProdutoDTO {
    private int id;

    private String descricao;

    private double valor;

    private Categoria categoria;

    public ProdutoDTO(int id, String descricao, double valor, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }

    public ProdutoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Produto toEntity() {
        Produto produto = new Produto();
        produto.setId(this.id);
        produto.setDescricao(this.descricao);
        produto.setValor(this.valor);
        produto.setCategoria(this.categoria);
        return produto;
    }
    public static ProdutoDTO toDTO(Produto produto) {
        return new ProdutoDTO(produto.getId(), produto.getDescricao(), produto.getValor(), produto.getCategoria());
    }
    public static List<ProdutoDTO> toDTOList(List<Produto> produtos) {
        return produtos.stream().map(ProdutoDTO::toDTO).toList();
    }
}
