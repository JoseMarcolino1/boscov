package com.boscov.avaliadorFilmes.models.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsuarioOutput {
    private Long id;
    private String nome;
    private String email;
    private String apelido;
    private Boolean status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;
}
