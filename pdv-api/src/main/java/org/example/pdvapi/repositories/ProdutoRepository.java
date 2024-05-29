package org.example.pdvapi.repositories;

import org.example.pdvapi.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query
    public List<Produto> findByNomeIsContainingIgnoreCase(String nome);
}
