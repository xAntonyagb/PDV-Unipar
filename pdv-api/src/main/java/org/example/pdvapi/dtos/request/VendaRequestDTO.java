package org.example.pdvapi.dtos.request;

import org.example.pdvapi.dtos.response.VendaResponseDTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antony
 */
public class VendaRequestDTO {

    private String observacao;
    private List<ItemVendaRequestDTO> itensVenda;
    private ClienteRequestDTO cliente;
    private String data;

    public VendaRequestDTO() {
        this.itensVenda = new ArrayList<>();
    }

    public VendaRequestDTO(String observacao, List<ItemVendaRequestDTO> itensVenda, ClienteRequestDTO cliente, String data) {
        this.observacao = observacao;
        this.itensVenda = itensVenda;
        this.cliente = cliente;
        this.data = data;
    }

    public List<ItemVendaRequestDTO> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVendaRequestDTO> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public ClienteRequestDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteRequestDTO cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    @Override
    public String toString() {
        return "VendaRequest{" + "itensVenda=" + itensVenda + ", cliente=" + cliente + ", data=" + data + '}';
    }
    
}
