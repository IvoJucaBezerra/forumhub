package br.com.alura.forumhub.domain.forum.resposta.dto;

import br.com.alura.forumhub.domain.forum.resposta.Resposta;
import br.com.alura.forumhub.domain.forum.topico.dto.DadosTopico;
import br.com.alura.forumhub.domain.user.dto.DadosListagemUsuario;

import java.time.LocalDateTime;

public record DadosResposta(String mensagem, LocalDateTime dataCriacao, Boolean solucao,
                            DadosListagemUsuario autor, DadosTopico topico) {
    public DadosResposta(Resposta resposta) {
        this(
                resposta.getMensagem(),
                resposta.getDataCriacao(),
                resposta.getSolucao(),
                new DadosListagemUsuario(resposta.getAutor()),
                new DadosTopico(resposta.getTopico()));
    }
}
