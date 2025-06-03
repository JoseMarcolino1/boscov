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
        Filme filme = new Filme();
        filme.setNome(input.getNome());
        filme.setDiretor(input.getDiretor());
        filme.setAnoLancamento(input.getAnoLancamento());
        filme.setDuracao(input.getDuracao());
        filme.setProdutora(input.getProdutora());
        filme.setClassificacao(input.getClassificacao());
        filme.setPoster(input.getPoster());
        if (input.getGenerosIds() != null && !input.getGenerosIds().isEmpty()) {
            List<Genero> generos = generoRepository.findAllById(input.getGenerosIds());
            filme.setGeneros(new HashSet<>(generos));
        }

        Filme salvo = filmeRepository.save(filme);

        FilmeOutput output = new FilmeOutput();
        output.setId(salvo.getId());
        output.setNome(salvo.getNome());
        output.setDiretor(salvo.getDiretor());
        output.setAnoLancamento(salvo.getAnoLancamento());
        output.setDuracao(salvo.getDuracao());
        output.setProdutora(salvo.getProdutora());
        output.setClassificacao(salvo.getClassificacao());
        output.setPoster(salvo.getPoster());

        Set<GeneroOutput> generosOutput = salvo.getGeneros().stream()
                .map(this::mapearGenero)
                .collect(Collectors.toSet());
        output.setGeneros(generosOutput);

        return output;
    }

    public void deletar(Long id) {
        if (!filmeRepository.existsById(id)) {
            throw new RuntimeException("Filme não encontrado");
        }
        filmeRepository.deleteById(id);
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

    public FilmeOutput atualizar(Long id, FilmeInput input) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        if (input.getNome() != null) {
            filme.setNome(input.getNome());
        }
        if (input.getDiretor() != null) {
            filme.setDiretor(input.getDiretor());
        }
        if (input.getAnoLancamento() != null) {
            filme.setAnoLancamento(input.getAnoLancamento());
        }
        if (input.getDuracao() != null) {
            filme.setDuracao(input.getDuracao());
        }
        if (input.getProdutora() != null) {
            filme.setProdutora(input.getProdutora());
        }
        if (input.getClassificacao() != null) {
            filme.setClassificacao(input.getClassificacao());
        }
        if (input.getPoster() != null) {
            filme.setPoster(input.getPoster());
        }

        // 🔥 Atualizando generos se tiver IDs no input
        if (input.getGenerosIds() != null && !input.getGenerosIds().isEmpty()) {
            List<Genero> generos = generoRepository.findAllById(input.getGenerosIds());
            filme.setGeneros(new HashSet<>(generos));
        }

        Filme atualizado = filmeRepository.save(filme);

        // 🔧 Mapeando para DTO de saída
        FilmeOutput output = new FilmeOutput();
        output.setId(atualizado.getId());
        output.setNome(atualizado.getNome());
        output.setDiretor(atualizado.getDiretor());
        output.setAnoLancamento(atualizado.getAnoLancamento());
        output.setDuracao(atualizado.getDuracao());
        output.setProdutora(atualizado.getProdutora());
        output.setClassificacao(atualizado.getClassificacao());
        output.setPoster(atualizado.getPoster());

        Set<GeneroOutput> generosOutput = atualizado.getGeneros().stream()
                .map(this::mapearGenero)
                .collect(Collectors.toSet());
        output.setGeneros(generosOutput);

        return output;
    }


    private GeneroOutput mapearGenero(Genero genero) {
        GeneroOutput output = new GeneroOutput();
        output.setId(genero.getId());
        output.setDescricao(genero.getDescricao());
        return output;
    }


}
