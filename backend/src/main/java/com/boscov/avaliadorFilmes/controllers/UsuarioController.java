package com.boscov.avaliadorFilmes.controllers;

import com.boscov.avaliadorFilmes.models.Usuario;
import com.boscov.avaliadorFilmes.models.dto.UsuarioInput;
import com.boscov.avaliadorFilmes.models.dto.UsuarioOutput;
import com.boscov.avaliadorFilmes.repositories.UsuarioRepository;
import com.boscov.avaliadorFilmes.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;
    @Autowired
    private UsuarioRepository usuarioRepository;


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
        System.out.println("OIA AQ: " + email);
        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        UsuarioOutput output = new UsuarioOutput();
        output.setId(usuario.getId());
        output.setNome(usuario.getNome());
        output.setEmail(usuario.getEmail());
        output.setApelido(usuario.getApelido());
        output.setStatus(usuario.getStatus());
        output.setDataCriacao(usuario.getDataCriacao());
        output.setDataAtualizacao(usuario.getDataAtualizacao());

        return ResponseEntity.ok(output);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<UsuarioOutput>> listarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        List<UsuarioOutput> outputs = usuarios.stream().map(usuario -> {
            UsuarioOutput output = new UsuarioOutput();
            output.setId(usuario.getId());
            output.setNome(usuario.getNome());
            output.setEmail(usuario.getEmail());
            output.setApelido(usuario.getApelido());
            output.setStatus(usuario.getStatus());
            output.setDataCriacao(usuario.getDataCriacao());
            output.setDataAtualizacao(usuario.getDataAtualizacao());
            return output;
        }).toList();

        return ResponseEntity.ok(outputs);
    }


}
