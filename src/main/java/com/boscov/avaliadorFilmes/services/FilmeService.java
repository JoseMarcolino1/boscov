package com.boscov.avaliadorFilmes.services;

import com.boscov.avaliadorFilmes.models.Filme;
import com.boscov.avaliadorFilmes.models.Genero;
import com.boscov.avaliadorFilmes.models.dto.FilmeInput;
import com.boscov.avaliadorFilmes.models.dto.FilmeOutput;
import com.boscov.avaliadorFilmes.models.dto.GeneroOutput;
import com.boscov.avaliadorFilmes.repositories.FilmeRepository;
import com.boscov.avaliadorFilmes.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private GeneroRepository generoRepository;

    public FilmeOutput salvar(FilmeInput input) {
        // Buscar os gêneros pelos IDs fornecidos
        Set<Genero> generos = new HashSet<>();
        for (Long generoId : input.getGeneros()) {
            Genero genero = generoRepository.findById(generoId)
                    .orElseThrow(() -> new RuntimeException("Gênero não encontrado: " + generoId));
            generos.add(genero);
        }

        // Criar o filme
        Filme filme = new Filme();
        filme.setNome(input.getNome());
        filme.setDiretor(input.getDiretor());
        filme.setAnoLancamento(input.getAnoLancamento());
        filme.setDuracao(input.getDuracao());
        filme.setProdutora(input.getProdutora());
        filme.setClassificacao(input.getClassificacao());
        filme.setPoster(input.getPoster());
        filme.setGeneros(generos);

        Filme salvo = filmeRepository.save(filme);

        // Criar o output
        FilmeOutput output = new FilmeOutput();
        output.setId(salvo.getId());
        output.setNome(salvo.getNome());
        output.setDiretor(salvo.getDiretor());
        output.setAnoLancamento(salvo.getAnoLancamento());
        output.setDuracao(salvo.getDuracao());
        output.setProdutora(salvo.getProdutora());
        output.setClassificacao(salvo.getClassificacao());
        output.setPoster(salvo.getPoster());

        // Preencher os gêneros no output
        Set<GeneroOutput> generosOutput = salvo.getGeneros().stream().map(genero -> {
            GeneroOutput go = new GeneroOutput();
            go.setId(genero.getId());
            go.setDescricao(genero.getDescricao());
            return go;
        }).collect(Collectors.toSet());

        output.setGeneros(generosOutput);

        return output;
    }

    public List<FilmeOutput> listarTodos() {
        return filmeRepository.findAll().stream().map(filme -> {
            FilmeOutput output = new FilmeOutput();
            output.setId(filme.getId());
            output.setNome(filme.getNome());
            output.setDiretor(filme.getDiretor());
            output.setAnoLancamento(filme.getAnoLancamento());
            output.setDuracao(filme.getDuracao());
            output.setProdutora(filme.getProdutora());
            output.setClassificacao(filme.getClassificacao());
            output.setPoster(filme.getPoster());

            Set<GeneroOutput> generosOutput = filme.getGeneros().stream().map(genero -> {
                GeneroOutput g = new GeneroOutput();
                g.setId(genero.getId());
                g.setDescricao(genero.getDescricao());
                return g;
            }).collect(Collectors.toSet());

            output.setGeneros(generosOutput);

            return output;
        }).collect(Collectors.toList());
    }


    public FilmeOutput buscarPorId(Long id) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        FilmeOutput output = new FilmeOutput();
        output.setId(filme.getId());
        output.setNome(filme.getNome());
        output.setDiretor(filme.getDiretor());
        output.setAnoLancamento(filme.getAnoLancamento());
        output.setDuracao(filme.getDuracao());
        output.setProdutora(filme.getProdutora());
        output.setClassificacao(filme.getClassificacao());
        output.setPoster(filme.getPoster());

        Set<GeneroOutput> generosOutput = filme.getGeneros().stream().map(genero -> {
            GeneroOutput g = new GeneroOutput();
            g.setId(genero.getId());
            g.setDescricao(genero.getDescricao());
            return g;
        }).collect(Collectors.toSet());

        output.setGeneros(generosOutput);

        return output;
    }

}
