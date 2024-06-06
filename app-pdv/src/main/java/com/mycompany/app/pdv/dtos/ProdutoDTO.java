/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app.pdv.dtos;

/**
 *
 * @author gabri
 */
public class ProdutoDTO {
     private int id;

    private String descricao;

    private double valorUnitario;

    private int quantidade;
    
    private CategoriaDTO categoria;

    public ProdutoDTO(){
    }

    public ProdutoDTO(int id, String descricao, double valorUnitario, int quantidade, CategoriaDTO categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
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

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ProdutoDTO{" + "id=" + id + ", descricao=" + descricao + ", valorUnitario=" + valorUnitario + ", quantidade=" + quantidade + ", categoria=" + categoria + '}';
    }
    
}
