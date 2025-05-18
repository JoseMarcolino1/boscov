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

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    public AvaliacaoOutput avaliar(AvaliacaoInput input) {
        Usuario usuario = usuarioRepository.findById(input.getIdUsuario()).orElseThrow();
        Filme filme = filmeRepository.findById(input.getIdFilme()).orElseThrow();

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setUsuario(usuario);
        avaliacao.setFilme(filme);
        avaliacao.setNota(input.getNota());
        avaliacao.setComentario(input.getComentario());

        Avaliacao salva = avaliacaoRepository.save(avaliacao);

        AvaliacaoOutput output = new AvaliacaoOutput();
        output.setIdUsuario(salva.getUsuario().getId());
        output.setIdFilme(salva.getFilme().getId());
        output.setNota(salva.getNota());
        output.setComentario(salva.getComentario());

        return output;
    }
}
