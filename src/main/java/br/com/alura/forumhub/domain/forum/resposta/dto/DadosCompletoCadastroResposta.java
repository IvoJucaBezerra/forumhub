package br.com.alura.forumhub.domain.forum.resposta.dto;

import br.com.alura.forumhub.domain.forum.topico.Topico;
import br.com.alura.forumhub.domain.user.Usuario;

public record DadosCompletoCadastroResposta(String mensagem, Usuario autor, Topico topico) {
}
