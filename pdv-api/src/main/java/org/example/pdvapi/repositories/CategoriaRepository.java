package org.example.pdvapi.repositories;

import org.example.pdvapi.entities.Categoria;
import org.example.pdvapi.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query
    public List<Categoria> findByDescricaoIsContainingIgnoreCase(String nome);

    @Query
    public boolean existsByDescricaoIgnoreCase(String descricao);
}
