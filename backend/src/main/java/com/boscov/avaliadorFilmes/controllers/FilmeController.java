package com.boscov.avaliadorFilmes.controllers;

import com.boscov.avaliadorFilmes.models.Filme;
import com.boscov.avaliadorFilmes.models.dto.FilmeInput;
import com.boscov.avaliadorFilmes.models.dto.FilmeOutput;
import com.boscov.avaliadorFilmes.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/save")
    public FilmeOutput criar(@RequestBody FilmeInput input) {
        return filmeService.salvar(input);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
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

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            filmeService.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<FilmeOutput> atualizar(@PathVariable Long id, @RequestBody FilmeInput input) {
        try {
            FilmeOutput atualizado = filmeService.atualizar(id, input);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }



}
