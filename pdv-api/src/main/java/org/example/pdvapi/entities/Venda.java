package org.example.pdvapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @NotEmpty
    private String observacao;

    @NotNull
    @Future
    private Timestamp data;

    @NotNull
    @Column(name = "total")
    @DecimalMin(value = "0.0")
    @Digits(integer = 0, fraction = 2)
    private double valorTotal;

    @ManyToOne
    @NotNull
    private Cliente cliente;

    @OneToMany
    @NotNull
    private List<ItemVenda> itensVenda;

    public Venda() {
    }

    public Venda(int id, String observacao, Timestamp data, double valorTotal, Cliente cliente) {
        this.id = id;
        this.observacao = observacao;
        this.data = data;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull @NotBlank @NotEmpty String getObservacao() {
        return observacao;
    }

    public void setObservacao(@NotNull @NotBlank @NotEmpty String observacao) {
        this.observacao = observacao;
    }

    public @NotNull @Future Timestamp getData() {
        return data;
    }

    public void setData(@NotNull @Future Timestamp data) {
        this.data = data;
    }

    @NotNull
    @DecimalMin(value = "0.0")
    @Digits(integer = 0, fraction = 2)
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(@NotNull @DecimalMin(value = "0.0") @Digits(integer = 0, fraction = 2) double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public @NotNull Cliente getCliente() {
        return cliente;
    }

    public void setCliente(@NotNull Cliente cliente) {
        this.cliente = cliente;
    }

    public @NotNull List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(@NotNull List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", observacao='" + observacao + '\'' +
                ", data=" + data +
                ", valorTotal=" + valorTotal +
                ", cliente=" + cliente +
                ", itensVenda=" + itensVenda +
                '}';
    }
}
