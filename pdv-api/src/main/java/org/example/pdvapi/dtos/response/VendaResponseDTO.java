package org.example.pdvapi.dtos.response;


import org.example.pdvapi.dtos.request.VendaRequestDTO;
import org.example.pdvapi.entities.Venda;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;



public class VendaResponseDTO {

    private long id;
    private String observacao;
    private Timestamp data;
    private double valorTotal;
    
    private ClienteResponseDTO cliente;
    private List<ItemVendaResponseDTO> itensVenda;

    
    public VendaResponseDTO() {
        this.itensVenda = new ArrayList<>();
    }
    
    public VendaResponseDTO(long id, String observacao, Timestamp data, double valorTotal, ClienteResponseDTO cliente, List<ItemVendaResponseDTO> itensVenda) {
        this.id = id;
        this.observacao = observacao;
        this.data = data;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.itensVenda = itensVenda;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }
    public void setData(String data) {
        Instant converter = Instant.parse(data);
        this.data =  Timestamp.from(converter);
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setCliente(ClienteResponseDTO cliente) {
        this.cliente = cliente;
    }

    public void setItensVenda(List<ItemVendaResponseDTO> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public long getId() {
        return id;
    }

    public String getObservacao() {
        return observacao;
    }

    public Timestamp getData() {
        return data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public ClienteResponseDTO getCliente() {
        return cliente;
    }

    public List<ItemVendaResponseDTO> getItensVenda() {
        return itensVenda;
    }

    @Override
    public String toString() {
        return "VendaResponse{" + "id=" + id + ", observacao=" + observacao + ", data=" + data + ", valorTotal=" + valorTotal + ", cliente=" + cliente + ", itensVenda=" + itensVenda + '}';
    }

    public VendaResponseDTO fromRequest(VendaRequestDTO vendaRequestDTO) {
        VendaResponseDTO vendaResponseDTO = new VendaResponseDTO();
        vendaResponseDTO.setObservacao(vendaRequestDTO.getObservacao());
        vendaResponseDTO.setData(vendaRequestDTO.getData());
        vendaResponseDTO.setCliente(new ClienteResponseDTO().fromRequest(vendaRequestDTO.getCliente()));
        vendaResponseDTO.setItensVenda(new ItemVendaResponseDTO().fromRequestList(vendaRequestDTO.getItensVenda()));
        return vendaResponseDTO;
    }

    public Venda toEntity(VendaResponseDTO vendaResponseDTO) {
        Venda venda = new Venda();
        venda.setObservacao(vendaResponseDTO.getObservacao());
        venda.setData(vendaResponseDTO.getData());
        venda.setValorTotal(vendaResponseDTO.getValorTotal());
        venda.setCliente(new ClienteResponseDTO().toEntity(vendaResponseDTO.getCliente()));
        venda.setItensVenda(new ItemVendaResponseDTO().toEntityList(vendaResponseDTO.getItensVenda()));
        return venda;
    }

    public VendaResponseDTO fromEntity(Venda venda) {
        VendaResponseDTO vendaResponseDTO = new VendaResponseDTO();
        vendaResponseDTO.setId(venda.getId());
        vendaResponseDTO.setObservacao(venda.getObservacao());
        vendaResponseDTO.setData(venda.getData());
        vendaResponseDTO.setValorTotal(venda.getValorTotal());
        vendaResponseDTO.setCliente(new ClienteResponseDTO().fromEntity(venda.getCliente()));
        vendaResponseDTO.setItensVenda(new ItemVendaResponseDTO().fromEntityList(venda.getItensVenda()));
        return vendaResponseDTO;

    }
}
