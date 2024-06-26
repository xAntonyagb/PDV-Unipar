package org.example.pdvapi.service;

import org.example.pdvapi.dtos.request.ClienteRequestDTO;
import org.example.pdvapi.dtos.request.VendaRequestDTO;
import org.example.pdvapi.dtos.response.ClienteResponseDTO;
import org.example.pdvapi.dtos.response.ItemVendaResponseDTO;
import org.example.pdvapi.dtos.response.ProdutoResponseDTO;
import org.example.pdvapi.dtos.response.VendaResponseDTO;
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


    public VendaResponseDTO doCalc(VendaRequestDTO vendaRequestDTO) throws ValidationException, NotFoundException {
        VendaResponseDTO vendaResponseDTO = validateRequest(vendaRequestDTO);

        // Calcula o valor total da venda
        List<ItemVendaResponseDTO> itensVendaCalculados = new ArrayList<>();
        double valorSubtotal = 0;
        double descontoTotal = 0;
        double valorTotal = 0;

        for (ItemVendaResponseDTO itemVenda : vendaResponseDTO.getItensVenda()) {

            //busca o produto no banco de dados
            Produto produto = produtoRepository.findById(itemVenda.getProduto().getId()).orElse(null);
            itemVenda.setProduto(produto.toDTO());

            //seta o valor unitario do itemvenda
            itemVenda.setValorUnitario(produto.getValor());

            //seta o valor total do itemvenda e faz o calculo do subtotal da venda
            double calculoSubtotal = itemVenda.getQuantidade() * itemVenda.getValorUnitario();
            itemVenda.setValorSubtotal(calculoSubtotal);
            valorSubtotal += calculoSubtotal;

            descontoTotal += itemVenda.getDesconto();

            // Calcula o valor total do item e faz o calculo do valor total da venda
            double calculoTotal = calculoSubtotal - itemVenda.getDesconto();
            itemVenda.setValorTotal(calculoTotal);
            valorTotal += calculoTotal;

            itensVendaCalculados.add(itemVenda);
        }

        // Retorno
        vendaResponseDTO.setValorSubtotal(valorSubtotal);
        vendaResponseDTO.setDescontoTotal(descontoTotal);
        vendaResponseDTO.setValorTotal(valorTotal);
        vendaResponseDTO.setItensVenda(itensVendaCalculados);

        if (vendaResponseDTO.getValorTotal() <= 0)
            throw new ValidationException("O valor total da venda deve ser maior que 0");

        return vendaResponseDTO;
    }

    public VendaResponseDTO insert(VendaRequestDTO vendaRequestDTO) throws ValidationException, NotFoundException {
        // Calcula a venda
        VendaResponseDTO vendaResponseDTO = doCalc(vendaRequestDTO);

        // Insere a venda no banco de dados
        Venda venda = new VendaResponseDTO().toEntity(vendaResponseDTO);
        for (ItemVenda itemVenda : venda.getItensVenda()) {
            itemVenda.setVenda(venda);
        }

        vendaRepository.save(venda);
        // Retorna a venda inserida
        vendaResponseDTO.setId(venda.getId());
        for (ItemVenda itemVenda : venda.getItensVenda()) {
            for (ItemVendaResponseDTO itemVendaResponseDTO : vendaResponseDTO.getItensVenda()) {
                if (itemVendaResponseDTO.getProduto().getId() == itemVenda.getProduto().getId()) {
                    itemVendaResponseDTO.setId(itemVenda.getId());
                }
            }
        }
        return vendaResponseDTO;
    }

    public List<VendaResponseDTO> findAll() {
        List<Venda> vendas = vendaRepository.findAll();
        List<VendaResponseDTO> vendaResponseDTOList = new ArrayList<>();
        for (Venda venda : vendas) {
            vendaResponseDTOList.add(new VendaResponseDTO().fromEntity(venda));
        }
        return vendaResponseDTOList;
    }

    public VendaResponseDTO findById(int id)  throws NotFoundException{
        Venda venda = vendaRepository.findById(id).orElse(null);
        if (venda == null) {
            throw new NotFoundException("Venda não encontrada");
        }
        return new VendaResponseDTO().fromEntity(venda);
    }


    public VendaResponseDTO validateRequest(VendaRequestDTO vendaRequestDTO) throws ValidationException, NotFoundException {
        VendaResponseDTO vendaResponseDTO = new VendaResponseDTO().fromRequest(vendaRequestDTO);

        // ------------------------------ CLIENTE ------------------------------
        // Verifica se o cliente é válido
        if (vendaRequestDTO.getCliente() == null) {
            throw new ValidationException("Nenhum cliente foi informado na venda!");
        }
        if (vendaRequestDTO.getCliente().getId() <= 0) {
            throw new ValidationException("O cliente informado é inválido!");
        }

        Cliente cliente = clienteRepository.findById(
                        vendaRequestDTO.getCliente().getId())
                .orElse(null);

        if (cliente == null) {
            throw new NotFoundException("O cliente informado não pode ser encontrado ou não existe");
        }


        // ------------------------------ VENDA ------------------------------
        // Verifica se a lista de itens da venda não está vazia
        if (vendaRequestDTO.getItensVenda() == null || vendaRequestDTO.getItensVenda().isEmpty()) {
            throw new ValidationException("A venda deve ter pelo menos um item");
        }

        Set<Long> produtosIds = new HashSet<>(); // Armazenar os produtos já verificados

        List<ItemVendaResponseDTO> itensVendaRetorno = new ItemVendaResponseDTO().fromRequestList(vendaRequestDTO.getItensVenda());
        for (int i = 0; i < vendaRequestDTO.getItensVenda().size(); i++) {
            // Verificar repetido
            long produtoId = vendaRequestDTO.getItensVenda().get(i).getProduto().getId();

            // Se não consegue adicionar o ID, ele já foi adicionado
            if (!produtosIds.add(produtoId)) {
                throw new ValidationException("O produto informado já foi adicionado!");
            }

            // Verifica se o produto do item é válido
            if (vendaRequestDTO.getItensVenda().get(i).getProduto() == null) {
                throw new ValidationException("O produto informado não é um produto válido.");
            }
            if (vendaRequestDTO.getItensVenda().get(i).getProduto().getId() <= 0) {
                throw new ValidationException("O produto informado não é um produto válido.");
            }

            Produto produto = produtoRepository.findById(
                            vendaRequestDTO.getItensVenda().get(i).getProduto().getId())
                    .orElse(null);

            if (produto == null) {
                throw new NotFoundException("O produto informado não pode ser encontrado ou não existe!");
            }

            itensVendaRetorno.get(i).setProduto(produto.toDTO());

            //Verifica o desconto
            if (vendaRequestDTO.getItensVenda().get(i).getDesconto() < 0) {
                throw new ValidationException("Desconto é menor que 0 para o produto: "
                        + produto.getDescricao());
            }

            if (vendaRequestDTO.getItensVenda().get(i).getDesconto() > (produto.getValor() * vendaRequestDTO.getItensVenda().get(i).getQuantidade())) {
                throw new ValidationException("Desconto é maior que o valor do produto: "
                        + produto.getDescricao());
            }

            //Verifica se o produto tem estoque
            if (vendaRequestDTO.getItensVenda().get(i).getQuantidade() <= 0) {
                throw new ValidationException("Quantidade de produtos é menor ou inferior a 0 para o produto: "
                        + vendaRequestDTO.getItensVenda().get(i).getProduto().getId());
            }
        }


        // ------------------------------ RETORNO ------------------------------
        ClienteResponseDTO clienteRetorno = new ClienteResponseDTO().fromEntity(cliente);
        vendaResponseDTO.setCliente(clienteRetorno);
        vendaResponseDTO.setItensVenda(itensVendaRetorno);

        return vendaResponseDTO;
    }

}
