package org.example.pdvapi.service;

import org.example.pdvapi.dtos.ItemVendaDTO;
import org.example.pdvapi.dtos.VendaDTO;
import org.example.pdvapi.entities.Cliente;
import org.example.pdvapi.entities.ItemVenda;
import org.example.pdvapi.entities.Produto;
import org.example.pdvapi.entities.Venda;
import org.example.pdvapi.exceptions.NotFoundException;
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


    public VendaDTO doCalc(VendaDTO vendaDTO) throws ValidationException, NotFoundException {
            validate(vendaDTO);

            // Calcula o valor total da venda
            List<ItemVendaDTO> itensVendaCalculados = new ArrayList<>();
            double valorTotal = 0;

            for (ItemVendaDTO itemVenda : vendaDTO.getItensVenda()) {

                //busca o produto no banco de dados
                Produto produto = produtoRepository.findById(itemVenda.getProduto().getId()).orElse(null);
                itemVenda.setProduto(produto.toDTO());

                //seta o valor unitario do itemvenda
                itemVenda.setValorUnitario(produto.getValor());

                //seta o valor total do itemvenda e faz o calculo do valor total da venda
                double calculo = itemVenda.getQuantidade() * itemVenda.getValorUnitario();
                itemVenda.setValorTotal(calculo);
                valorTotal += calculo;

                itensVendaCalculados.add(itemVenda);
            }

            // Retorno
            vendaDTO.setValorTotal(valorTotal);
            vendaDTO.setItensVenda(itensVendaCalculados);
        return vendaDTO;
    }

    public VendaDTO insert(VendaDTO vendaDTO) throws ValidationException, NotFoundException {
        vendaDTO = doCalc(vendaDTO); //Validações e cálculos

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

    public void validate(VendaDTO vendaDTO) throws ValidationException, NotFoundException {
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
                throw new ValidationException("Quantidade de produtos é menor ou inferior a 0 para o produto: "
                        + vendaDTO.getItensVenda().get(i).getProduto().getDescricao());
            }
        }
    }

}
