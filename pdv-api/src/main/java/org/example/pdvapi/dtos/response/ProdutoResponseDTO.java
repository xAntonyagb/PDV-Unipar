package org.example.pdvapi.dtos.response;

import org.example.pdvapi.dtos.request.ProdutoRequestDTO;
import org.example.pdvapi.entities.Produto;

import java.util.List;

/**
 *
 * @author gabri
 */
public class ProdutoResponseDTO {
    
    private int id;
    private String descricao;
    private double valor;
    private CategoriaResponseDTO categoria;

    
    public ProdutoResponseDTO(){
    }

    public ProdutoResponseDTO(int id, String descricao, double valor, CategoriaResponseDTO categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public CategoriaResponseDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaResponseDTO categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "ProdutoResponse{" + "id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", categoria=" + categoria + '}';
    }

    public ProdutoResponseDTO fromEntity(Produto produto) {
        ProdutoResponseDTO produtoResponse = new ProdutoResponseDTO();
        produtoResponse.setId(produto.getId());
        produtoResponse.setDescricao(produto.getDescricao());
        produtoResponse.setValor(produto.getValor());
        produtoResponse.setCategoria(new CategoriaResponseDTO().fromEntity(produto.getCategoria()));
        return produtoResponse;
    }

    public List<ProdutoResponseDTO> fromEntityList(List<Produto> produtos) {
        return produtos.stream().map(this::fromEntity).toList();
    }

    public ProdutoResponseDTO fromRequest(ProdutoRequestDTO produto) {
        ProdutoResponseDTO produtoResponse = new ProdutoResponseDTO();
        produtoResponse.setId(produto.getId());
        return produtoResponse;
    }

    public Produto toEntity(ProdutoResponseDTO produto) {
        Produto produtoEntity = new Produto();
        produtoEntity.setId(produto.getId());
        return produtoEntity;
    }
}
