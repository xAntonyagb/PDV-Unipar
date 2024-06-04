package org.example.pdvapi.dtos;


import org.example.pdvapi.entities.Produto;
import org.example.pdvapi.enums.CategoriaEnum;

public class ProdutoDTO {
    private int id;

    private String descricao;

    private double preco;

    private CategoriaEnum categoria;

    public ProdutoDTO() {
    }

    public ProdutoDTO(int id, String descricao, double preco, CategoriaEnum categoria) {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public CategoriaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEnum categoria) {
        this.categoria = categoria;
    }

    public Produto toEntity() {
        Produto produto = new Produto();
        produto.setId(this.id);
        produto.setDescricao(this.descricao);
        produto.setPreco(this.preco);
        produto.setCategoria(this.categoria);
        return produto;
    }
    public static ProdutoDTO toDTO(Produto produto) {
        return new ProdutoDTO(produto.getId(), produto.getDescricao(), produto.getPreco(), produto.getCategoria());
    }
}
