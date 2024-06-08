
package org.example.pdvapi.dtos.response;


import org.example.pdvapi.dtos.request.ItemVendaRequestDTO;
import org.example.pdvapi.entities.ItemVenda;
import org.example.pdvapi.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class ItemVendaResponseDTO {

    private long id;
    private int quantidade;
    private double valorUnitario;
    private double valorTotal;
    private ProdutoResponseDTO produto;

    private double desconto;

    
    public ItemVendaResponseDTO() {
    }

    public ItemVendaResponseDTO(long id, int quantidade, double valorUnitario, double valorTotal, ProdutoResponseDTO produto, double desconto) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.produto = produto;
        this.desconto = desconto;
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

    @Override
    public String toString() {
        return "ItemVendaResponseDTO{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", valorUnitario=" + valorUnitario +
                ", valorTotal=" + valorTotal +
                ", produto=" + produto +
                ", desconto=" + desconto +
                '}';
    }

    public List<ItemVendaResponseDTO> fromRequestList(List<ItemVendaRequestDTO> itensVenda) {
        List<ItemVendaResponseDTO> itemVendaResponseDTO = new ArrayList<>();
        for (ItemVendaRequestDTO itemVenda : itensVenda) {
            ItemVendaResponseDTO itemVendaResponseDTO1 = new ItemVendaResponseDTO();
            itemVendaResponseDTO1.setQuantidade(itemVenda.getQuantidade());
            itemVendaResponseDTO1.setDesconto(itemVenda.getDesconto());
            itemVendaResponseDTO1.setProduto(new ProdutoResponseDTO().fromRequest(itemVenda.getProduto()));
            itemVendaResponseDTO.add(itemVendaResponseDTO1);
        }
        return itemVendaResponseDTO;
    }

    public List<ItemVenda> toEntityList(List<ItemVendaResponseDTO> itensVenda) {
        List<ItemVenda> itemVendaList = new ArrayList<>();
        for (ItemVendaResponseDTO itemVenda : itensVenda) {
            ItemVenda itemVenda1 = new ItemVenda();
            itemVenda1.setQuantidade(itemVenda.getQuantidade());
            itemVenda1.setDesconto(itemVenda.getDesconto());
            itemVenda1.setProduto(new ProdutoResponseDTO().toEntity(itemVenda.getProduto()));
            itemVendaList.add(itemVenda1);
        }
        return itemVendaList;
    }

    public List<ItemVendaResponseDTO> fromEntityList(List<ItemVenda> itensVenda) {
        List<ItemVendaResponseDTO> itemVendaResponseDTO = new ArrayList<>();
        for (ItemVenda itemVenda : itensVenda) {
            ItemVendaResponseDTO itemVendaResponseDTO1 = new ItemVendaResponseDTO();
            itemVendaResponseDTO1.setId(itemVenda.getId());
            itemVendaResponseDTO1.setQuantidade(itemVenda.getQuantidade());
            itemVendaResponseDTO1.setDesconto(itemVenda.getDesconto());
            itemVendaResponseDTO1.setProduto(new ProdutoResponseDTO().fromEntity(itemVenda.getProduto()));
            itemVendaResponseDTO.add(itemVendaResponseDTO1);
        }
        return itemVendaResponseDTO;
    }
}
