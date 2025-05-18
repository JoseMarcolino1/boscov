package com.boscov.avaliadorFilmes.repositories;

import com.boscov.avaliadorFilmes.models.Avaliacao;
import com.boscov.avaliadorFilmes.models.AvaliacaoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, AvaliacaoId> {
}