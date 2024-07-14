package br.com.alura.forumhub.domain.forum.topico.dto;

import br.com.alura.forumhub.domain.course.dto.DadosCursoCompleto;
import br.com.alura.forumhub.domain.forum.topico.StatusTopico;
import br.com.alura.forumhub.domain.forum.topico.Topico;
import br.com.alura.forumhub.domain.user.dto.DadosUsuarioCompleto;

import java.time.LocalDateTime;

public record DadosTopicoCompleto(Long id, String titulo, String mensagem,
                                  LocalDateTime dataCriacao, StatusTopico status,
                                  DadosUsuarioCompleto autor, DadosCursoCompleto curso) {
    public DadosTopicoCompleto(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getDadosAutor(),
                topico.getDadosCurso()
        );
    }
}
