package org.example.pdvapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotBlank
    @Length(min = 5, max = 60)
    private String nome;
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
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

    public @NotNull @NotBlank @Length(min = 5, max = 60) String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank @Length(min = 5, max = 60) String nome) {
        this.nome = nome;
    }

    public @NotNull @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @NotBlank String email) {
        this.email = email;
    }

    public @NotNull @NotBlank String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotNull @NotBlank String telefone) {
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
}
