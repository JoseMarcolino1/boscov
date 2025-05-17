package com.boscov.avaliadorFilmes.services;

import com.boscov.avaliadorFilmes.models.Usuario;
import com.boscov.avaliadorFilmes.models.dto.UsuarioInput;
import com.boscov.avaliadorFilmes.models.dto.UsuarioOutput;
import com.boscov.avaliadorFilmes.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

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
        usuario.setStatus(input.status);
        usuario.setApelido(input.apelido);
        usuario.setDataNascimento(input.dataNascimento);
        usuario.setTipoUsuario(input.tipoUsuario);
        usuario.setDataCriacao(LocalDate.now());
        usuario.setDataAtualizacao(LocalDate.now());

        usuario = usuarioRepository.save(usuario);

        UsuarioOutput output = new UsuarioOutput();
        output.id = usuario.getId();
        output.nome = usuario.getNome();
        output.email = usuario.getEmail();
        output.apelido = usuario.getApelido();
        output.status = usuario.getStatus();
        output.dataCriacao = usuario.getDataCriacao();
        output.dataAtualizacao = usuario.getDataAtualizacao();

        return output;
    }
}
