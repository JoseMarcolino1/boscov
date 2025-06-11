package com.boscov.avaliadorFilmes.services;

import com.boscov.avaliadorFilmes.models.Avaliacao;
import com.boscov.avaliadorFilmes.models.AvaliacaoId;
import com.boscov.avaliadorFilmes.models.Filme;
import com.boscov.avaliadorFilmes.models.Usuario;
import com.boscov.avaliadorFilmes.models.dto.AvaliacaoInput;
import com.boscov.avaliadorFilmes.models.dto.AvaliacaoOutput;
import com.boscov.avaliadorFilmes.repositories.AvaliacaoRepository;
import com.boscov.avaliadorFilmes.repositories.FilmeRepository;
import com.boscov.avaliadorFilmes.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

        avaliacao.setDataCriacao(LocalDateTime.now());
        avaliacao.setDataAtualizacao(LocalDateTime.now());
        AvaliacaoId id = new AvaliacaoId();
        id.setUsuario(usuario.getId());
        id.setFilme(filme.getId());
        avaliacao.setId(id);
        Avaliacao salva = avaliacaoRepository.save(avaliacao);

        AvaliacaoOutput output = new AvaliacaoOutput();
        output.setIdUsuario(usuario.getId());
        output.setNomeUsuario(usuario.getNome());
        output.setIdFilme(filme.getId());
        output.setNomeFilme(filme.getNome());
        output.setNota(salva.getNota());
        output.setComentario(salva.getComentario());
        output.setDataCriacao(salva.getDataCriacao());
        output.setDataAtualizacao(salva.getDataAtualizacao());

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
        output.setDataCriacao(avaliacao.getDataCriacao());
        output.setDataAtualizacao(avaliacao.getDataAtualizacao());
        return output;
    }

    public List<AvaliacaoOutput> listarAvaliacoesDoUsuario(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario == null) {
            throw new RuntimeException("Usuário não encontrado");
        }

        return avaliacaoRepository.findByUsuario(usuario).stream()
                .map(this::criarOutput)
                .collect(Collectors.toList());
    }

    public AvaliacaoOutput editarAvaliacaoDoUsuario(String emailUsuario, Long idFilme, AvaliacaoInput input) {
        Usuario usuario = usuarioRepository.findByEmail(emailUsuario);
        if (usuario == null) {
            throw new RuntimeException("Usuário não encontrado.");
        }

        Avaliacao avaliacaoExistente = avaliacaoRepository.findByUsuarioIdAndFilmeId(usuario.getId(), idFilme)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada para este usuário e filme."));

        avaliacaoExistente.setNota(input.getNota());
        avaliacaoExistente.setComentario(input.getComentario());

        // ✅ Atualiza a data de atualização
        avaliacaoExistente.setDataAtualizacao(LocalDateTime.now());

        Avaliacao atualizada = avaliacaoRepository.save(avaliacaoExistente);

        AvaliacaoOutput output = new AvaliacaoOutput();
        output.setIdUsuario(usuario.getId());
        output.setNomeUsuario(usuario.getNome());
        output.setIdFilme(avaliacaoExistente.getFilme().getId());
        output.setNomeFilme(avaliacaoExistente.getFilme().getNome());
        output.setNota(atualizada.getNota());
        output.setComentario(atualizada.getComentario());
        output.setDataCriacao(atualizada.getDataCriacao());
        output.setDataAtualizacao(atualizada.getDataAtualizacao());

        return output;
    }


    public AvaliacaoOutput getAvaliacaoDoUsuarioPorFilme(String email, Long idFilme) {
        Usuario usuario = usuarioRepository.findByEmail(email);

        Avaliacao avaliacao = avaliacaoRepository.findByUsuarioIdAndFilmeId(usuario.getId(), idFilme)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada!"));

        return criarOutput(avaliacao);
    }


}
