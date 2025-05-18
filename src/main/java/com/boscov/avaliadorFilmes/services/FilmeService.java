package com.boscov.avaliadorFilmes.services;

import com.boscov.avaliadorFilmes.models.Filme;
import com.boscov.avaliadorFilmes.models.dto.FilmeInput;
import com.boscov.avaliadorFilmes.models.dto.FilmeOutput;
import com.boscov.avaliadorFilmes.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public FilmeOutput salvar(FilmeInput input) {
        Filme filme = new Filme();
        filme.setNome(input.getNome());
        filme.setDiretor(input.getDiretor());
        filme.setAnoLancamento(input.getAnoLancamento());
        filme.setGeneroId(input.getGeneroId());
        filme.setDuracao(input.getDuracao());
        filme.setProdutora(input.getProdutora());
        filme.setClassificacao(input.getClassificacao());
        filme.setPoster(input.getPoster());

        Filme salvo = filmeRepository.save(filme);

        FilmeOutput output = new FilmeOutput();
        output.setId(salvo.getId());
        output.setNome(salvo.getNome());
        output.setDiretor(salvo.getDiretor());
        output.setAnoLancamento(salvo.getAnoLancamento());
        output.setGeneroId(salvo.getGeneroId());
        output.setDuracao(salvo.getDuracao());
        output.setProdutora(salvo.getProdutora());
        output.setClassificacao(salvo.getClassificacao());
        output.setPoster(salvo.getPoster());

        return output;
    }

    public List<Filme> listarTodos() {
        return filmeRepository.findAll();
    }

    public Filme buscarPorId(Long id) {
        return filmeRepository.findById(id).orElse(null);
    }
}
