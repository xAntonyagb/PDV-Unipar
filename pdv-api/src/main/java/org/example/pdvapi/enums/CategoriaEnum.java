package org.example.pdvapi.enums;

public enum CategoriaEnum {
    ALIMENTOS(1),
    BEBIDAS(2),
    LIMPEZA(3),
    HIGIENE(4),
    OUTROS(5);

    private final int categoria;
    CategoriaEnum(int categoria) {
        this.categoria = categoria;
    }
}
