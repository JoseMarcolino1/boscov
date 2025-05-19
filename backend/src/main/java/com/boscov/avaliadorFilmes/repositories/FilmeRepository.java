package com.boscov.avaliadorFilmes.repositories;
import com.boscov.avaliadorFilmes.models.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
