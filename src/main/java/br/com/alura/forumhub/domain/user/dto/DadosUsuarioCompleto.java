package br.com.alura.forumhub.domain.user.dto;

import br.com.alura.forumhub.domain.user.Usuario;

public record DadosUsuarioCompleto(Long id, String nome, String email) {
    public DadosUsuarioCompleto(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail());
    }
}
