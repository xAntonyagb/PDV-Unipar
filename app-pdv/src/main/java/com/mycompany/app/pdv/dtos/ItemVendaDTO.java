
package com.mycompany.app.pdv.dtos;



public class ItemVendaDTO {

    private int id;
    private ProdutoDTO produto;
    private VendaDTO venda;
    private String descricao;
    private double quantidade;
    private double valorTotal;
    private double valorUnitario;
    private double descontoProduto;

    public ItemVendaDTO() {
    }

    public ItemVendaDTO(int id, ProdutoDTO produto, VendaDTO venda, String descricao, double quantidade, double valorTotal, double valorUnitario, double descontoProduto) {
        this.id = id;
        this.produto = produto;
        this.venda = venda;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.valorUnitario = valorUnitario;
        this.descontoProduto = descontoProduto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }

    public VendaDTO getVenda() {
        return venda;
    }

    public void setVenda(VendaDTO venda) {
        this.venda = venda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getDescontoProduto() {
        return descontoProduto;
    }

    public void setDescontoProduto(double descontoProduto) {
        this.descontoProduto = descontoProduto;
    }
}
