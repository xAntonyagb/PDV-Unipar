package org.example.pdvapi.repositories;

import org.example.pdvapi.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {




    Optional <List<Produto>> findByDescricaoContainingIgnoreCase(String descricao);
}
