package org.example.pdvapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @NotNull
//    @NotBlank
//    @NotEmpty
//    @Length(min = 5, max = 60)
    private String nome;

//    @NotNull
//    @NotBlank
//    @NotEmpty
//    @Email
    private String email;

//    @NotNull
//    @NotBlank
//    @NotEmpty
//    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4}-\\d{4}", message = "O telefone fornecido não é válido")
    private String telefone;

    public Cliente() {
    }
    public Cliente(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public /* @NotNull @NotBlank @NotEmpty @Length(min = 5, max = 60) */String getNome() {
        return nome;
    }

    public void setNome(/*  @NotNull @NotBlank @NotEmpty @Length(min = 5, max = 60) */ String nome) {
        this.nome = nome;
    }

    public/*   @NotNull @NotNull @NotBlank @NotEmpty @Email */ String getEmail() {
        return email;
    }

    public void setEmail(/*  @NotNull @NotNull @NotBlank @NotEmpty @Email*/  String email) {
        this.email = email;
    }

    public /*@NotNull @NotBlank @NotEmpty @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4}-\\d{4}", message = "O telefone fornecido não é válido")*/ String getTelefone() {
        return telefone;
    }

    public void setTelefone(/*@NotNull @NotBlank @NotEmpty @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4}-\\d{4}", message = "O telefone fornecido não é válido")*/ String telefone) {
        this.telefone = telefone;
    }


    public Object toDTO() {
        Cliente cliente = new Cliente();
        cliente.setId(this.id);
        cliente.setNome(this.nome);
        cliente.setEmail(this.email);
        cliente.setTelefone(this.telefone);
        return cliente;
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';

    }
}
