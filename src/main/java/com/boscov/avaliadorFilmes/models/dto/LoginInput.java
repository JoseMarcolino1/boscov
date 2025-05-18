package com.boscov.avaliadorFilmes.models.dto;

import lombok.Data;

@Data
public class LoginInput {
    private String email;
    private String senha;
}
