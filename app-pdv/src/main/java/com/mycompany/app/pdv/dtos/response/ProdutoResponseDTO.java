package com.mycompany.app.pdv.dtos.response;

import com.mycompany.app.pdv.dtos.request.ProdutoRequestDTO;

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

    public static ProdutoResponseDTO toResponseDTO(ProdutoRequestDTO produtoRequestDTO) {
        ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO();
        produtoResponseDTO.setId(produtoRequestDTO.getId());

        return produtoResponseDTO;
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

}
