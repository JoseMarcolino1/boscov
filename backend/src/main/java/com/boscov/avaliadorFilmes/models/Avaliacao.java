package com.boscov.avaliadorFilmes.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@IdClass(AvaliacaoId.class)
@Data
public class Avaliacao {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_filme")
    private Filme filme;

    private Double nota;
    private String comentario;

}