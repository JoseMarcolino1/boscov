package com.boscov.avaliadorFilmes.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String senha;
    private String email;
    private String status;
    private String apelido;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @Column(name = "tipo_usuario")
    private String tipoUsuario;

}