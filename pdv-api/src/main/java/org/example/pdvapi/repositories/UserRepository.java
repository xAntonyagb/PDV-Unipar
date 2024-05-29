package org.example.pdvapi.repositories;

import org.example.pdvapi.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByUsernameIgnoreCase(String username);
}
