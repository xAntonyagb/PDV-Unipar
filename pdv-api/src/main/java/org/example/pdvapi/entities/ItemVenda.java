package org.example.pdvapi.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "item_venda")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Min(value = 0)
    private int quantidade;

    @NotNull
    @DecimalMin(value = "0.0")
    @NumberFormat(pattern = "#.##")
    private double valorUnitario;

    @NotNull
    @DecimalMin(value = "0.0")
    @NumberFormat(pattern = "#.##")
    private double valorTotal;

    @NotNull
    @ManyToOne
    private Produto produto;

    @NotNull
    @ManyToOne
    private Venda venda;

    @Column(nullable = true)
    private double desconto;

    public ItemVenda() {
    }

    public ItemVenda(int id, int quantidade, double valorUnitario, double valorTotal, Produto produto, Venda venda, double desconto) {
        this.id = id;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.produto = produto;
        this.venda = venda;
        this.desconto = desconto;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NotNull
    @Min(value = 0)
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@NotNull  @Min(value = 0) int quantidade) {
        this.quantidade = quantidade;
    }

    @NotNull
    @DecimalMin(value = "0.0")
    @NumberFormat(pattern = "#.##")
    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(@NotNull  @DecimalMin(value = "0.0") @NumberFormat(pattern = "#.##") double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @NotNull
    @DecimalMin(value = "0.0")
    @NumberFormat(pattern = "#.##")
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(@NotNull  @DecimalMin(value = "0.0") @NumberFormat(pattern = "#.##") double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public @NotNull Produto getProduto() {
        return produto;
    }

    public void setProduto(@NotNull Produto produto) {
        this.produto = produto;
    }

    public @NotNull Venda getVenda() {
        return venda;
    }

    public void setVenda(@NotNull Venda venda) {
        this.venda = venda;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

}
