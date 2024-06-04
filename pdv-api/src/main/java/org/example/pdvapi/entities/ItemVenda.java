package org.example.pdvapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "item_venda")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Min(value = 0)
    private int quantidade;

    @NotNull
    @NotBlank
    @NotEmpty
    @DecimalMin(value = "0.0")
    @Digits(integer = 0, fraction = 2)
    private double valorUnitario;

    @NotNull
    @NotBlank
    @NotEmpty
    @DecimalMin(value = "0.0")
    @Digits(integer = 0, fraction = 2)
    private double valorTotal;

    @NotNull
    @ManyToOne
    private Produto produto;

    @NotNull
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
    @NotEmpty
    @Min(value = 0)
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@NotNull @NotBlank @NotEmpty @Min(value = 0) int quantidade) {
        this.quantidade = quantidade;
    }

    @NotNull
    @NotBlank
    @NotEmpty
    @DecimalMin(value = "0.0")
    @Digits(integer = 0, fraction = 2)
    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(@NotNull @NotBlank @NotEmpty @DecimalMin(value = "0.0") @Digits(integer = 0, fraction = 2) double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @NotNull
    @NotBlank
    @NotEmpty
    @DecimalMin(value = "0.0")
    @Digits(integer = 0, fraction = 2)
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(@NotNull @NotBlank @NotEmpty @DecimalMin(value = "0.0") @Digits(integer = 0, fraction = 2) double valorTotal) {
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

    @Override
    public String toString() {
        return "ItemVenda{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", valorUnitario=" + valorUnitario +
                ", valorTotal=" + valorTotal +
                ", produto=" + produto +
                ", venda=" + venda +
                '}';
    }
}
