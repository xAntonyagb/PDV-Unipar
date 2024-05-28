package org.example.pdvapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "item_venda")
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotBlank
    private int quantidade;
    @NotNull
    @NotBlank
    private double valorUnitario;
    @NotNull
    @NotBlank
    private double valorTotal;
    @ManyToOne
    private Produto produto;
    @ManyToOne
    private Venda venda;

    public ItemVenda() {
    }

    public ItemVenda(int id, int quantidade, double valorUnitario, double valorTotal, Produto produto, Venda venda) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.produto = produto;
        this.venda = venda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @NotBlank
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@NotNull @NotBlank int quantidade) {
        this.quantidade = quantidade;
    }

    @NotNull
    @NotBlank
    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(@NotNull @NotBlank double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @NotNull
    @NotBlank
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(@NotNull @NotBlank double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
}
