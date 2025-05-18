package com.boscov.avaliadorFilmes.services;

import com.boscov.avaliadorFilmes.models.Usuario;
import com.boscov.avaliadorFilmes.models.dto.UsuarioInput;
import com.boscov.avaliadorFilmes.models.dto.UsuarioOutput;
import com.boscov.avaliadorFilmes.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioOutput criar(UsuarioInput input) {
        Usuario usuario = new Usuario();
        usuario.setNome(input.nome);
        usuario.setSenha(input.senha);
        usuario.setEmail(input.email);
        usuario.setStatus(true);
        usuario.setApelido(input.apelido);
        usuario.setDataNascimento(input.dataNascimento);
        usuario.setTipoUsuario(input.tipoUsuario);
        usuario.setDataCriacao(LocalDateTime.now());
        usuario.setDataAtualizacao(LocalDateTime.now());

        usuario = usuarioRepository.save(usuario);

        UsuarioOutput output = new UsuarioOutput();
        output.setId(usuario.getId());
        output.setNome(usuario.getNome());
        output.setEmail(usuario.getEmail());
        output.setApelido(usuario.getApelido());
        output.setStatus(usuario.getStatus());
        output.setDataCriacao(usuario.getDataCriacao());
        output.setDataAtualizacao(usuario.getDataAtualizacao());

        return output;
    }
}
