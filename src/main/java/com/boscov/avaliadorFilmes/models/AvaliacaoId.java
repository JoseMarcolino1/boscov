package com.boscov.avaliadorFilmes.models;

import java.io.Serializable;
import java.util.Objects;

public class AvaliacaoId implements Serializable {

    private Long usuario;
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