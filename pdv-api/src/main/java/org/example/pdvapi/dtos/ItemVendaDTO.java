package org.example.pdvapi.dtos;

import org.example.pdvapi.entities.ItemVenda;
import org.example.pdvapi.entities.Produto;

import java.util.ArrayList;
import java.util.List;

public class ItemVendaDTO {
    private int id;
    private int quantidade;
    private double valorUnitario;
    private double valorTotal;
    private ProdutoDTO produto;

    public ItemVendaDTO() {
    }

    public ItemVendaDTO(int id, int quantidade, double valorUnitario, double valorTotal, ProdutoDTO produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.produto = produto;
    }

    public static List<ItemVenda> toEntityList(List<ItemVendaDTO> itensVenda) {
        itensVenda.forEach(itemVendaDTO -> {
            Produto produto = itemVendaDTO.getProduto().toEntity();
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setId(itemVendaDTO.getId());
            itemVenda.setQuantidade(itemVendaDTO.getQuantidade());
            itemVenda.setValorUnitario(itemVendaDTO.getValorUnitario());
            itemVenda.setValorTotal(itemVendaDTO.getValorTotal());
            itemVenda.setProduto(produto);
        });
        return null;
    }

    public static Object toDTOList(List<ItemVenda> itensVenda) {

        List<ItemVendaDTO> itemVendaDTOList = new ArrayList<>();
        for (ItemVenda itemVenda : itensVenda) {
            ItemVendaDTO itemVendaDTO = new ItemVendaDTO();
            itemVendaDTO.setId(itemVenda.getId());
            itemVendaDTO.setQuantidade(itemVenda.getQuantidade());
            itemVendaDTO.setValorUnitario(itemVenda.getValorUnitario());
            itemVendaDTO.setValorTotal(itemVenda.getValorTotal());
            itemVendaDTO.setProduto(ProdutoDTO.toDTO(itemVenda.getProduto()));
            itemVendaDTOList.add(itemVendaDTO);
        }
        return itemVendaDTOList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }
}
