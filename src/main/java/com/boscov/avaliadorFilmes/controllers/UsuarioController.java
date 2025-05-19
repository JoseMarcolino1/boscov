package com.boscov.avaliadorFilmes.controllers;

import com.boscov.avaliadorFilmes.models.dto.UsuarioInput;
import com.boscov.avaliadorFilmes.models.dto.UsuarioOutput;
import com.boscov.avaliadorFilmes.services.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/save")
    public UsuarioOutput criarUsuario(@RequestBody UsuarioInput input) {
        return usuarioService.criar(input);
    }

    @DeleteMapping("/delete/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletar(id);
    }

}
