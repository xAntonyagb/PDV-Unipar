package org.example.pdvapi.dtos.request;


import org.example.pdvapi.dtos.response.ItemVendaResponseDTO;

import java.util.List;

/**
 *
 * @author Antony
 */
public class ItemVendaRequestDTO {

    private int quantidade;
    private ProdutoRequestDTO produto;
    private double desconto;

    
    public ItemVendaRequestDTO() {
    }

    public ItemVendaRequestDTO(int quantidade, ProdutoRequestDTO produto, double desconto) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.desconto = desconto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutoRequestDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoRequestDTO produto) {
        this.produto = produto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "ItemVendaRequest{" + "quantidade=" + quantidade + ", produto=" + produto + ", desconto=" + desconto + '}';
    }
    
}
