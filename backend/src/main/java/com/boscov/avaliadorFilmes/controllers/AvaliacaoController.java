package com.boscov.avaliadorFilmes.controllers;

import com.boscov.avaliadorFilmes.models.dto.AvaliacaoInput;
import com.boscov.avaliadorFilmes.models.dto.AvaliacaoOutput;
import com.boscov.avaliadorFilmes.services.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping("/create")
    public AvaliacaoOutput avaliar(@RequestBody AvaliacaoInput input) {
        return avaliacaoService.avaliar(input);
    }

    @GetMapping("/all")
    public List<AvaliacaoOutput> listarTodas() {
        return avaliacaoService.listarTodos();
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/minhas")
    public List<AvaliacaoOutput> listarMinhasAvaliacoes(Authentication authentication) {
        String email = authentication.getName();
        return avaliacaoService.listarAvaliacoesDoUsuario(email);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/minha/{idFilme}")
    public AvaliacaoOutput getMinhaAvaliacaoPorFilme(@PathVariable Long idFilme, Authentication authentication) {
        String email = authentication.getName();
        return avaliacaoService.getAvaliacaoDoUsuarioPorFilme(email, idFilme);
    }


    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PutMapping("/edit/{idFilme}")
    public AvaliacaoOutput editarAvaliacao(
            @PathVariable Long idFilme,
            @RequestBody AvaliacaoInput input,
            Authentication authentication) {

        String emailUsuario = authentication.getName();
        return avaliacaoService.editarAvaliacaoDoUsuario(emailUsuario, idFilme, input);
    }


}