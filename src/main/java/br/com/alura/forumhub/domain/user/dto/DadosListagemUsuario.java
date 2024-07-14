package br.com.alura.forumhub.domain.user.dto;

import br.com.alura.forumhub.domain.user.Usuario;

public record DadosListagemUsuario(String nome, String email) {
    public DadosListagemUsuario(Usuario usuario) {
        this(
                usuario.getNome(),
                usuario.getEmail());
    }
}
