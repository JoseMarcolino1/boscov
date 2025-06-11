package com.boscov.avaliadorFilmes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class AvaliacaoId implements Serializable {

    @Column(name = "id_usuario")
    private Long usuario;

    @Column(name = "id_filme")
    private Long filme;

    public AvaliacaoId() {}

    public AvaliacaoId(Long usuario, Long filme) {
        this.usuario = usuario;
        this.filme = filme;
    }

    // equals() e hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AvaliacaoId)) return false;
        AvaliacaoId that = (AvaliacaoId) o;
        return Objects.equals(usuario, that.usuario) &&
                Objects.equals(filme, that.filme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, filme);
    }
}