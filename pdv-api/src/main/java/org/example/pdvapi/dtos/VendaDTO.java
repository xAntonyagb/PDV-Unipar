package org.example.pdvapi.dtos;




import org.example.pdvapi.entities.Venda;

import java.sql.Timestamp;
import java.util.List;

public class VendaDTO {

    private int id;
    private String observacao;
    private String data;
    private double valorTotal;
    private ClienteDTO cliente;
    private List<ItemVendaDTO> itensVenda;

    public VendaDTO() {
    }

    public VendaDTO(int id, String observacao, String data, double valorTotal, ClienteDTO cliente, List<ItemVendaDTO> itensVenda) {
        this.id = id;
        this.observacao = observacao;
        this.data = data;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.itensVenda = itensVenda;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public List<ItemVendaDTO> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVendaDTO> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public Venda toEntity() {
        Venda venda = new Venda();
        venda.setId(this.id);
        venda.setObservacao(this.observacao);
        venda.setData(Timestamp.valueOf(this.data));
        venda.setValorTotal(this.valorTotal);
        venda.setCliente(this.cliente.toEntity());
        venda.setItensVenda(ItemVendaDTO.toEntityList(this.itensVenda));
        return venda;
    }
}
