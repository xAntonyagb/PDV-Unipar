
package com.mycompany.app.pdv.dtos.response;


import com.mycompany.app.pdv.dtos.request.ItemVendaRequestDTO;

import java.util.List;

public class ItemVendaResponseDTO {

    private long id;
    private int quantidade;
    private double valorUnitario;
    private double valorTotal;
    private double valorSubtotal;
    private ProdutoResponseDTO produto;

    private double desconto;

    
    public ItemVendaResponseDTO() {
    }

    public ItemVendaResponseDTO(long id, int quantidade, double valorUnitario, double valorTotal, double valorSubtotal, ProdutoResponseDTO produto, double desconto) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.valorSubtotal = valorSubtotal;
        this.produto = produto;
        this.desconto = desconto;
    }

    public static ItemVendaResponseDTO toResponseDTO (ItemVendaRequestDTO itemVendaRequestDTO) {
        ItemVendaResponseDTO itemVendaResponseDTO = new ItemVendaResponseDTO();

        itemVendaResponseDTO.setQuantidade(itemVendaRequestDTO.getQuantidade());
        itemVendaResponseDTO.setProduto(
                ProdutoResponseDTO.toResponseDTO(itemVendaRequestDTO.getProduto()));
        itemVendaResponseDTO.setDesconto(itemVendaRequestDTO.getDesconto());

        return itemVendaResponseDTO;
    }

    public static List<ItemVendaResponseDTO> toResponseDTOList(List<ItemVendaRequestDTO> itensVenda) {
        return itensVenda.stream().map(ItemVendaResponseDTO::toResponseDTO).toList();
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ProdutoResponseDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoResponseDTO produto) {
        this.produto = produto;
    }


    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValorSubtotal() {
        return valorSubtotal;
    }

    public void setValorSubtotal(double valorSubtotal) {
        this.valorSubtotal = valorSubtotal;
    }

    @Override
    public String toString() {
        return "ItemVendaResponseDTO{" + "id=" + id + ", quantidade=" + quantidade + ", valorUnitario=" + valorUnitario + ", valorTotal=" + valorTotal + ", valorSubtotal=" + valorSubtotal + ", produto=" + produto + ", desconto=" + desconto + '}';
    }

}
