package org.example.pdvapi.repositories;

import org.example.pdvapi.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query
    public List<Cliente> findByNomeIsContainingIgnoreCase(String nome);
}
