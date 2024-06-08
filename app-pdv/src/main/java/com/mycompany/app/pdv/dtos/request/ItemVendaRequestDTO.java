package com.mycompany.app.pdv.dtos.request;

import com.mycompany.app.pdv.dtos.response.ItemVendaResponseDTO;
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

    public static ItemVendaRequestDTO toRequestDTO (ItemVendaResponseDTO itemVendaResponseDTO) {
        return new ItemVendaRequestDTO(
                itemVendaResponseDTO.getQuantidade(),
                ProdutoRequestDTO.toRequestDTO(itemVendaResponseDTO.getProduto()),
                itemVendaResponseDTO.getDesconto());
    }

    public static List<ItemVendaRequestDTO> toRequestDTOList(List<ItemVendaResponseDTO> itensVenda) {
        return itensVenda.stream().map(ItemVendaRequestDTO::toRequestDTO).toList();
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
