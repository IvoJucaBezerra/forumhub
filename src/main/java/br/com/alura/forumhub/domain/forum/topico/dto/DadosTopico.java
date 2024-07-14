package br.com.alura.forumhub.domain.forum.topico.dto;

import br.com.alura.forumhub.domain.forum.topico.StatusTopico;
import br.com.alura.forumhub.domain.forum.topico.Topico;

public record DadosTopico(String titulo, String mensagem, StatusTopico status) {
    public DadosTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getStatus());
    }
}
