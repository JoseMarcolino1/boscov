package com.boscov.avaliadorFilmes.repositories;

import com.boscov.avaliadorFilmes.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
