package com.boscov.avaliadorFilmes.repositories;

import com.boscov.avaliadorFilmes.models.Avaliacao;
import com.boscov.avaliadorFilmes.models.AvaliacaoId;
import com.boscov.avaliadorFilmes.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, AvaliacaoId> {
    List<Avaliacao> findByUsuario(Usuario usuario);
    Optional<Avaliacao> findByUsuarioIdAndFilmeId(Long usuarioId, Long filmeId);

}