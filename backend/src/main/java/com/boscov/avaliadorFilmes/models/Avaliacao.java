package com.boscov.avaliadorFilmes.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "avaliacao")
public class Avaliacao {
    @EmbeddedId
    private AvaliacaoId id;

    @ManyToOne
    @MapsId("usuario")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @MapsId("filme")
    @JoinColumn(name = "id_filme")
    private Filme filme;

    private Double nota;
    private String comentario;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

}