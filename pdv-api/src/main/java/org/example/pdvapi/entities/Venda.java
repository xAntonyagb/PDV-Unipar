package org.example.pdvapi.entities;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.NumberFormat;


import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = true)
    private String observacao;

    @NotNull
    @PastOrPresent
    private Timestamp data;

    @NotNull
    @Column(name = "total")
    @DecimalMin(value = "0.0")
    @NumberFormat(pattern = "#.##")
    private double valorTotal;

    @ManyToOne
    @NotNull
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @NotNull
    @JoinColumn(name = "venda_id")
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

    public /*@NotNull @NotBlank @NotEmpty*/ String getObservacao() {
        return observacao;
    }

    public void setObservacao(@NotNull @NotBlank @NotEmpty String observacao) {
        this.observacao = observacao;
    }

    public @NotNull @PastOrPresent Timestamp getData() {
        return data;
    }

    public void setData(@NotNull @PastOrPresent Timestamp data) {
        this.data = data;
    }

    @NotNull
    @DecimalMin(value = "0.0")
    @NumberFormat(pattern = "#.##")
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(@NotNull @DecimalMin(value = "0.0") @NumberFormat(pattern = "#.##") double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public @NotNull Cliente getCliente() {
        return cliente;
    }

    public void setCliente(@NotNull Cliente cliente) {
        this.cliente = cliente;
    }

    @NotNull 
    public List<ItemVenda> getItensVenda() {
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
