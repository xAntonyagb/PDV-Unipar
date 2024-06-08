package com.mycompany.app.pdv.dtos.request;

import com.mycompany.app.pdv.dtos.response.VendaResponseDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antony
 */
public class VendaRequestDTO {
    
    private List<ItemVendaRequestDTO> itensVenda;
    private ClienteRequestDTO cliente;
    private String data;

    public VendaRequestDTO() {
        this.itensVenda = new ArrayList<>();
        this.cliente = new ClienteRequestDTO();
    }

    public VendaRequestDTO(List<ItemVendaRequestDTO> itensVenda, ClienteRequestDTO cliente, String data) {
        this.itensVenda = itensVenda;
        this.cliente = cliente;
        this.data = data;
    }

    public static VendaRequestDTO toVendaRequestDTO(VendaResponseDTO vendaResponseDTO) {
        String data = vendaResponseDTO.getData() == null ? null : vendaResponseDTO.getData().toString();
        
        return new VendaRequestDTO(
                ItemVendaRequestDTO.toRequestDTOList(vendaResponseDTO.getItensVenda()),
                ClienteRequestDTO.toRequestDTO(vendaResponseDTO.getCliente()),
                data);
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

    @Override
    public String toString() {
        return "VendaRequest{" + "itensVenda=" + itensVenda + ", cliente=" + cliente + ", data=" + data + '}';
    }
    
}
