package com.boscov.avaliadorFilmes.controllers;

import com.boscov.avaliadorFilmes.models.Filme;
import com.boscov.avaliadorFilmes.models.dto.FilmeInput;
import com.boscov.avaliadorFilmes.models.dto.FilmeOutput;
import com.boscov.avaliadorFilmes.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/all")
    public ResponseEntity<List<FilmeOutput>> listar() {
        return ResponseEntity.ok(filmeService.listarTodos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<FilmeOutput> buscarPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(filmeService.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
