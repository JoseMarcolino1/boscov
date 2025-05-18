package com.boscov.avaliadorFilmes.models.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UsuarioInput {
    public String nome;
    public String senha;
    public String email;
    public String apelido;
    public LocalDate dataNascimento;
    public String tipoUsuario;

}
