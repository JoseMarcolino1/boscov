package com.boscov.avaliadorFilmes.services;

import com.boscov.avaliadorFilmes.models.Genero;
import com.boscov.avaliadorFilmes.models.dto.GeneroInput;
import com.boscov.avaliadorFilmes.models.dto.GeneroOutput;
import com.boscov.avaliadorFilmes.repositories.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneroService {

    private final GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public GeneroOutput salvar(GeneroInput input) {
        Genero genero = new Genero();
        genero.setDescricao(input.getDescricao());
        genero = generoRepository.save(genero);

        GeneroOutput output = new GeneroOutput();
        output.setId(genero.getId());
        output.setDescricao(genero.getDescricao());
        return output;
    }

    public List<GeneroOutput> listarTodos() {
        return generoRepository.findAll().stream().map(genero -> {
            GeneroOutput output = new GeneroOutput();
            output.setId(genero.getId());
            output.setDescricao(genero.getDescricao());
            return output;
        }).collect(Collectors.toList());
    }

    public GeneroOutput buscarPorId(Long id) {
        return generoRepository.findById(id)
                .map(genero -> {
                    GeneroOutput output = new GeneroOutput();
                    output.setId(genero.getId());
                    output.setDescricao(genero.getDescricao());
                    return output;
                })
                .orElse(null);
    }

    public void deletar(Long id) {
        generoRepository.deleteById(id);
    }
}
