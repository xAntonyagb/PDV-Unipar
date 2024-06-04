package org.example.pdvapi.repositories;

import org.example.pdvapi.entities.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Integer> {
}
