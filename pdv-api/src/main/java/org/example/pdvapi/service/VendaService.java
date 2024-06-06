package org.example.pdvapi.service;

import org.example.pdvapi.dtos.ItemVendaDTO;
import org.example.pdvapi.dtos.VendaDTO;
import org.example.pdvapi.entities.Cliente;
import org.example.pdvapi.entities.ItemVenda;
import org.example.pdvapi.entities.Produto;
import org.example.pdvapi.entities.Venda;
import org.example.pdvapi.exceptions.NotFoundException;
import org.example.pdvapi.repositories.ClienteRepository;
import org.example.pdvapi.repositories.ProdutoRepository;
import org.example.pdvapi.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;


    public VendaDTO doCalc(VendaDTO vendaDTO) throws Exception{
        validate(vendaDTO);
        // Calcula o valor total da venda
        //primeiro calcula o valor total dos itemvenda
        for (ItemVendaDTO itemVenda : vendaDTO.getItensVenda()) {
            //busca o produto no banco de dados
            Produto produto = produtoRepository.findById(itemVenda.getProduto().getId()).orElse(null);
            //seta o valor unitario do itemvenda
            itemVenda.setValorUnitario(produto.getValor());
            //seta o valor total do itemvenda
            itemVenda.setValorTotal(itemVenda.getQuantidade() * itemVenda.getValorUnitario());
        }
        //depois calcula o valor total da venda
        double valorTotal = 0;
        for (ItemVendaDTO itemVenda : vendaDTO.getItensVenda()) {
            valorTotal += itemVenda.getValorTotal();
        }
        vendaDTO.setValorTotal(valorTotal);
        return vendaDTO;
    }

    public VendaDTO insert(VendaDTO vendaDTO)  throws Exception{
        validate(vendaDTO);
        // Insere a venda no banco de dados
        Venda venda = vendaDTO.toEntity();
        for (ItemVenda itemVenda : venda.getItensVenda()) {
            itemVenda.setVenda(venda);
        }
        vendaRepository.save(venda);
        vendaDTO = venda.toDTO();
        return vendaDTO;
    }

    public List<VendaDTO> findAll() {
        List<Venda> vendas = vendaRepository.findAll();
        List<VendaDTO> vendaDTOList = new ArrayList<>();
        for (Venda venda : vendas) {
            vendaDTOList.add(venda.toDTO());
        }
        return vendaDTOList;
    }

    public VendaDTO findById(int id) {
        Venda venda = vendaRepository.findById(id).orElse(null);
        if (venda == null) {
            return null;
        }
        return venda.toDTO();
    }

    public void validate(VendaDTO vendaDTO) throws Exception {
        // Verifica se o cliente é válido
        if (vendaDTO.getCliente() == null) {
            throw new Exception("Cliente inválido");
        }
        if (vendaDTO.getCliente().getId() <= 0) {
            throw new Exception("Cliente inválido");
        }
        Cliente cliente = clienteRepository.findById(vendaDTO.getCliente().getId()).orElse(null);
        if (cliente == null) {
            throw new NotFoundException("Cliente não encontrado");
        }

        // Verifica se a lista de itens da venda não está vazia
        if (vendaDTO.getItensVenda() == null || vendaDTO.getItensVenda().isEmpty()) {
            throw new Exception("A venda deve ter pelo menos um item");
        }
        //Verifica se existem produtos repetidos
        for (int i = 0; i < vendaDTO.getItensVenda().size(); i++) {
            // Verifica se o produto do item é válido
            if (vendaDTO.getItensVenda().get(i).getProduto() == null) {
                throw new Exception("Produto inválido no item da venda");
            }
            if (vendaDTO.getItensVenda().get(i).getProduto().getId() <= 0) {
                throw new Exception("Produto inválido no item da venda");
            }
            Produto produto = produtoRepository.findById(vendaDTO.getItensVenda().get(i).getProduto().getId()).orElse(null);
            if (produto == null) {
                throw new NotFoundException("Produto não encontrado no item da venda");
            }


            for (int j = i + 1; j < vendaDTO.getItensVenda().size(); j++) {
                if (vendaDTO.getItensVenda().get(i).getProduto().getId() == vendaDTO.getItensVenda().get(j).getProduto().getId()) {
                    throw new Exception("Produtos repetidos na venda");
                }
            }
        }

        // Verifica cada item da venda
        for (ItemVendaDTO item : vendaDTO.getItensVenda()) {
            // Verifica se o produto do item é válido
            if (item.getProduto() == null) {
                throw new Exception("Produto inválido no item da venda");
            }
            if (item.getProduto().getId() <= 0) {
                throw new Exception("Produto inválido no item da venda");
            }

            // Verifica se a quantidade do item é maior que zero
            if (item.getQuantidade() <= 0) {
                throw new Exception("A quantidade do item da venda deve ser maior que zero");
            }
        }
        // Verifica se a data da venda é válida
        if (vendaDTO.getData() == null || vendaDTO.getData().isEmpty()) {
            throw new Exception("Data da venda inválida");
        }
    }
}
