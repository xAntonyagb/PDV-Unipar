package org.example.pdvapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.example.pdvapi.enums.CategoriaEnum;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Length(min = 5, max = 60)
    private String descricao;

    @NotNull
    @NotBlank
    @NotEmpty
    @DecimalMin(value = "0.0")
    @Digits(integer = 0, fraction = 2)
    private double valor;

    @NotNull
    @NotBlank
    @NotEmpty
    private CategoriaEnum categoria;

    public Produto() {
    }

    public Produto(int id, String descricao, double valor, CategoriaEnum categoria) {
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

    public @NotNull @NotBlank @NotEmpty @Length(min = 5, max = 60) String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull @NotBlank @NotEmpty @Length(min = 5, max = 60) String descricao) {
        this.descricao = descricao;
    }

    @NotNull
    @NotBlank
    @NotEmpty
    @DecimalMin(value = "0.0")
    @Digits(integer = 0, fraction = 2)
    public double getValor() {
        return valor;
    }

    public void setValor(@NotNull @NotBlank @NotEmpty @DecimalMin(value = "0.0") @Digits(integer = 0, fraction = 2) double valor) {
        this.valor = valor;
    }

    public @NotNull @NotBlank @NotEmpty CategoriaEnum getCategoria() {
        return categoria;
    }

    public void setCategoria(@NotNull @NotBlank @NotEmpty CategoriaEnum categoria) {
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
