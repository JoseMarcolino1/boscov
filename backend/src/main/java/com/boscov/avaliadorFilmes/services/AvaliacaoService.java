package com.boscov.avaliadorFilmes.services;

import com.boscov.avaliadorFilmes.models.Avaliacao;
import com.boscov.avaliadorFilmes.models.Filme;
import com.boscov.avaliadorFilmes.models.Usuario;
import com.boscov.avaliadorFilmes.models.dto.AvaliacaoInput;
import com.boscov.avaliadorFilmes.models.dto.AvaliacaoOutput;
import com.boscov.avaliadorFilmes.repositories.AvaliacaoRepository;
import com.boscov.avaliadorFilmes.repositories.FilmeRepository;
import com.boscov.avaliadorFilmes.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    public AvaliacaoOutput avaliar(AvaliacaoInput input) {
        Usuario usuario = usuarioRepository.findById(input.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Filme filme = filmeRepository.findById(input.getIdFilme())
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setUsuario(usuario);
        avaliacao.setFilme(filme);
        avaliacao.setNota(input.getNota());
        avaliacao.setComentario(input.getComentario());

        Avaliacao salva = avaliacaoRepository.save(avaliacao);

        AvaliacaoOutput output = new AvaliacaoOutput();
        output.setIdUsuario(usuario.getId());
        output.setNomeUsuario(usuario.getNome());
        output.setIdFilme(filme.getId());
        output.setNomeFilme(filme.getNome());
        output.setNota(salva.getNota());
        output.setComentario(salva.getComentario());

        return output;
    }

    public List<AvaliacaoOutput> listarTodos() {
        return avaliacaoRepository.findAll().stream()
                .map(this::criarOutput)
                .collect(Collectors.toList());
    }

    private AvaliacaoOutput criarOutput(Avaliacao avaliacao) {
        AvaliacaoOutput output = new AvaliacaoOutput();
        output.setIdUsuario(avaliacao.getUsuario().getId());
        output.setNomeUsuario(avaliacao.getUsuario().getNome());
        output.setIdFilme(avaliacao.getFilme().getId());
        output.setNomeFilme(avaliacao.getFilme().getNome());
        output.setNota(avaliacao.getNota());
        output.setComentario(avaliacao.getComentario());
        return output;
    }
}
