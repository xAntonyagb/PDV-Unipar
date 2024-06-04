package org.example.pdvapi.entities;

import jakarta.persistence.*;
import org.example.pdvapi.dtos.ClienteDTO;
import org.example.pdvapi.dtos.ItemVendaDTO;
import org.example.pdvapi.dtos.VendaDTO;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String observacao;
    private Timestamp data;
    private double valorTotal;
    @ManyToOne
    private Cliente cliente;
    @OneToMany
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public VendaDTO toDTO() {
        return new VendaDTO(this.id, this.observacao, this.data.toString(), this.valorTotal, (ClienteDTO) this.cliente.toDTO(), (List<ItemVendaDTO>) ItemVendaDTO.toDTOList(this.itensVenda));
    }
}
