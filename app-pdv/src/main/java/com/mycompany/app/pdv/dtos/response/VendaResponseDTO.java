package com.mycompany.app.pdv.dtos.response;


import com.mycompany.app.pdv.dtos.request.VendaRequestDTO;
import com.mycompany.app.pdvutils.TimeUtils;
import java.sql.Timestamp;
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

    public static VendaResponseDTO toResponseDTO (VendaRequestDTO vendaRequestDTO) {
        VendaResponseDTO vendaResponseDTO = new VendaResponseDTO();
        vendaResponseDTO.setData(vendaRequestDTO.getData());
        vendaResponseDTO.setCliente(
                ClienteResponseDTO.toResponseDTO(vendaRequestDTO.getCliente()));
        vendaResponseDTO.setItensVenda(
                ItemVendaResponseDTO.toResponseDTOList(vendaRequestDTO.getItensVenda()));

        return vendaResponseDTO;
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
        this.data = TimeUtils.stringToTimestamp(data);
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
   
}
