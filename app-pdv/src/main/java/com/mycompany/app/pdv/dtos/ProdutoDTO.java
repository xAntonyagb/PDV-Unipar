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
    
    private double valor;
    
    private CategoriaDTO categoria;

    public ProdutoDTO(){
    }

    public ProdutoDTO(int id, String descricao, double valorUnitario, int quantidade, double valor, CategoriaDTO categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.valor = valor;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ProdutoDTO{" + "id=" + id + ", descricao=" + descricao + ", valorUnitario=" + valorUnitario + ", quantidade=" + quantidade + ", valor=" + valor + ", categoria=" + categoria + '}';
    }
    
}
