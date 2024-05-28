package org.example.pdvapi.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String observacao;
    private String data;
    private double valorTotal;
    @ManyToOne
    private Cliente cliente;

}
