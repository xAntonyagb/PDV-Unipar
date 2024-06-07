package org.example.pdvapi.service;

import org.example.pdvapi.dtos.ItemVendaDTO;
import org.example.pdvapi.dtos.VendaDTO;
import org.example.pdvapi.entities.Cliente;
import org.example.pdvapi.entities.ItemVenda;
import org.example.pdvapi.entities.Produto;
import org.example.pdvapi.entities.Venda;
import org.example.pdvapi.exceptions.NotFoundException;
import org.example.pdvapi.exceptions.StockException;
import org.example.pdvapi.exceptions.ValidationException;
import org.example.pdvapi.repositories.ClienteRepository;
import org.example.pdvapi.repositories.ProdutoRepository;
import org.example.pdvapi.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;


    public VendaDTO doCalc(VendaDTO vendaDTO) throws ValidationException, NotFoundException, StockException {
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

    public VendaDTO insert(VendaDTO vendaDTO) throws ValidationException, NotFoundException, StockException {
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

    public void validate(VendaDTO vendaDTO) throws ValidationException, NotFoundException, StockException {
        // ------------------------------ CLIENTE ------------------------------
        // Verifica se o cliente é válido
        if (vendaDTO.getCliente() == null) {
            throw new ValidationException("Nenhum cliente foi informado na venda!");
        }
        if (vendaDTO.getCliente().getId() <= 0) {
            throw new ValidationException("O cliente informado é inválido!");
        }

        Cliente cliente = clienteRepository.findById(
                vendaDTO.getCliente().getId())
                .orElse(null);

        if (cliente == null) {
            throw new NotFoundException("O cliente informado não pode ser encontrado ou não existe");
        }


        // ------------------------------ VENDA ------------------------------
        // Verifica se a lista de itens da venda não está vazia
        if (vendaDTO.getItensVenda() == null || vendaDTO.getItensVenda().isEmpty()) {
            throw new ValidationException("A venda deve ter pelo menos um item");
        }

        Set<Long> produtosIds = new HashSet<>(); // Armazenar os produtos já verificados

        for (int i = 0; i < vendaDTO.getItensVenda().size(); i++) {
            // Verificar repetido
            long produtoId = vendaDTO.getItensVenda().get(i).getProduto().getId();

            // Se não consegue adicionar o ID, ele já foi adicionado
            if (!produtosIds.add(produtoId)) {
                throw new ValidationException("O produto informado já foi adicionado: " + i);
            }

            // Verifica se o produto do item é válido
            if (vendaDTO.getItensVenda().get(i).getProduto() == null) {
                throw new ValidationException("O seguinte produto informado é inválido: "+ i);
            }
            if (vendaDTO.getItensVenda().get(i).getProduto().getId() <= 0) {
                throw new ValidationException("O seguinte produto informado é inválido: "+ i);
            }

            Produto produto = produtoRepository.findById(
                    vendaDTO.getItensVenda().get(i).getProduto().getId())
                    .orElse(null);

            if (produto == null) {
                throw new NotFoundException("O produto informado não pode ser encontrado ou não existe: " + i);
            }


            //Verifica se o produto tem estoque
            if (vendaDTO.getItensVenda().get(i).getQuantidade() <= 0) {
                throw new StockException("Não há mais estoque para o produto escolhido: "
                        + vendaDTO.getItensVenda().get(i).getProduto().getDescricao());
            }
        }
    }

}
