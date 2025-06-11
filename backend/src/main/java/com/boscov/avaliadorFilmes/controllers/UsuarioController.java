package com.boscov.avaliadorFilmes.controllers;

import com.boscov.avaliadorFilmes.models.Usuario;
import com.boscov.avaliadorFilmes.models.dto.UsuarioInput;
import com.boscov.avaliadorFilmes.models.dto.UsuarioOutput;
import com.boscov.avaliadorFilmes.repositories.UsuarioRepository;
import com.boscov.avaliadorFilmes.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/create")
    public UsuarioOutput criarUsuario(@RequestBody UsuarioInput input) {
        return usuarioService.criar(input);
    }

    @DeleteMapping("/delete/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        usuarioService.deletar(id);
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioOutput> getUsuarioLogado(Authentication authentication) {
        String email = authentication.getName();
        UsuarioOutput output = usuarioService.buscarPorEmail(email);
        return ResponseEntity.ok(output);
    }

    @PutMapping("/me")
    public ResponseEntity<UsuarioOutput> atualizarUsuarioLogado(
            @RequestBody UsuarioInput input,
            Authentication authentication) {

        String email = authentication.getName();
        UsuarioOutput output = usuarioService.atualizarUsuarioLogado(email, input);
        return ResponseEntity.ok(output);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<UsuarioOutput>> listarTodos() {
        List<UsuarioOutput> outputs = usuarioService.listUsers();
        return ResponseEntity.ok(outputs);
    }


}
