package org.example.pdvapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*@NotNull
    @NotBlank
    @NotEmpty
    @Length(min = 5, max = 60)*/
    private String descricao;

    /*@NotNull
    @NotBlank
    @NotEmpty
    @DecimalMin(value = "0.0")
    @NumberFormat(pattern = "#.##")*/
    private double valor;

    /*@NotNull*/
    @ManyToOne
    private Categoria categoria;
    
    public Produto() {
    }

    public Produto(int id, String descricao, double valor, Categoria categoria) {
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

    public /*@NotNull @NotBlank @NotEmpty @Length(min = 5, max = 60) */String getDescricao() {
        return descricao;
    }

    public void setDescricao(/*@NotNull @NotBlank @NotEmpty @Length(min = 5, max = 60)*/ String descricao) {
        this.descricao = descricao;
    }

    /*@NotNull
    @NotBlank
    @NotEmpty
    @DecimalMin(value = "0.0")
    @NumberFormat(pattern = "#.##")*/
    public double getValor() {
        return valor;
    }

    public void setValor(/*@NotNull @NotBlank @NotEmpty @DecimalMin(value = "0.0") @NumberFormat(pattern = "#.##")*/ double valor) {
        this.valor = valor;
    }

    public /*@NotNull*/ Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", categoria=" + categoria +
                '}';
    }
}
