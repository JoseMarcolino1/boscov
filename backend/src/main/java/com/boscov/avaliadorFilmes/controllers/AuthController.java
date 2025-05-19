package com.boscov.avaliadorFilmes.controllers;

import com.boscov.avaliadorFilmes.models.Usuario;
import com.boscov.avaliadorFilmes.models.dto.LoginInput;
import com.boscov.avaliadorFilmes.repositories.UsuarioRepository;
import com.boscov.avaliadorFilmes.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginInput input) {
        Usuario usuario = usuarioRepository.findByEmail(input.getEmail());

        if (usuario == null || !encoder.matches(input.getSenha(), usuario.getSenha())) {
            return ResponseEntity.status(401).body("Email ou senha inválidos");
        }

        String token = jwtUtil.gerarToken(usuario.getEmail(), usuario.getTipoUsuario());

        return ResponseEntity.ok().body(token);
    }
}
