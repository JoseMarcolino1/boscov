package com.boscov.avaliadorFilmes.controllers;

import com.boscov.avaliadorFilmes.models.dto.AvaliacaoInput;
import com.boscov.avaliadorFilmes.models.dto.AvaliacaoOutput;
import com.boscov.avaliadorFilmes.services.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @PostMapping("/save")
    public AvaliacaoOutput avaliar(@RequestBody AvaliacaoInput input) {
        return avaliacaoService.avaliar(input);
    }

    @GetMapping("/all")
    public List<AvaliacaoOutput> listarTodas() {
        return avaliacaoService.listarTodos();
    }
}