package com.mycompany.app.pdv.dtos;


import java.util.List;



public class VendaDTO {

    private int id;

    private ClienteDTO cliente;

    private List<ItemVendaDTO> itemVenda;

    private double valorTotal;

    private double valorDesconto;

    private int quantidadeItens;

    public VendaDTO() {
    }

    public VendaDTO(int id, ClienteDTO cliente, double valorTotal, double valorDesconto, int quantidadeItens) {
        this.id = id;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.valorDesconto = valorDesconto;
        this.quantidadeItens = quantidadeItens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(int quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public List<ItemVendaDTO> getItemVenda() {
        return itemVenda;
    }

    public void setItemVenda(List<ItemVendaDTO> itemVenda) {
        this.itemVenda = itemVenda;
    }
}
