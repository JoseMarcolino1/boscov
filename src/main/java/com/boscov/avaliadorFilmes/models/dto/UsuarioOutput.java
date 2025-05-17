package com.boscov.avaliadorFilmes.models.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioOutput {
    public Long id;
    public String nome;
    public String email;
    public String apelido;
    public String status;
    public LocalDateTime dataCriacao;
    public LocalDateTime dataAtualizacao;
}