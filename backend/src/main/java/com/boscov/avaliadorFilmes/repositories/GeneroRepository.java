package com.boscov.avaliadorFilmes.repositories;

import com.boscov.avaliadorFilmes.models.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {}
