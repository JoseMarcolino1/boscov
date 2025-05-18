package com.boscov.avaliadorFilmes.controllers;

import com.boscov.avaliadorFilmes.models.Filme;
import com.boscov.avaliadorFilmes.models.dto.FilmeInput;
import com.boscov.avaliadorFilmes.models.dto.FilmeOutput;
import com.boscov.avaliadorFilmes.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @PostMapping("/save")
    public FilmeOutput criar(@RequestBody FilmeInput input) {
        return filmeService.salvar(input);
    }

    @GetMapping
    public List<Filme> listar() {
        return filmeService.listarTodos();
    }

    @GetMapping("/{id}")
    public Filme buscarPorId(@PathVariable Long id) {
        return filmeService.buscarPorId(id);
    }
}
