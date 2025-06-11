package com.boscov.avaliadorFilmes.controllers;

import com.boscov.avaliadorFilmes.models.dto.GeneroInput;
import com.boscov.avaliadorFilmes.models.dto.GeneroOutput;
import com.boscov.avaliadorFilmes.services.GeneroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    private final GeneroService generoService;

    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<GeneroOutput> criar(@RequestBody GeneroInput input) {
        return ResponseEntity.ok(generoService.salvar(input));
    }

    @GetMapping("/all")
    public ResponseEntity<List<GeneroOutput>> listar() {
        return ResponseEntity.ok(generoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneroOutput> buscarPorId(@PathVariable Long id) {
        GeneroOutput output = generoService.buscarPorId(id);
        return output != null ? ResponseEntity.ok(output) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        generoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
