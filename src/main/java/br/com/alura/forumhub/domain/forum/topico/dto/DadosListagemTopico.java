package br.com.alura.forumhub.domain.forum.topico.dto;

import br.com.alura.forumhub.domain.course.dto.DadosListagemCurso;
import br.com.alura.forumhub.domain.forum.topico.StatusTopico;
import br.com.alura.forumhub.domain.forum.topico.Topico;
import br.com.alura.forumhub.domain.user.dto.DadosListagemUsuario;

import java.time.LocalDateTime;

public record DadosListagemTopico(String titulo, String mensagem, LocalDateTime dataCriacao,
                                  StatusTopico status, DadosListagemUsuario autor, DadosListagemCurso curso) {
    public DadosListagemTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                new DadosListagemUsuario(topico.getAutor()),
                new DadosListagemCurso(topico.getCurso())
        );
    }
}
