package br.com.alura.forumhub.domain.forum.topico.dto;

import br.com.alura.forumhub.domain.course.Curso;
import br.com.alura.forumhub.domain.user.Usuario;

public record DadosCompletoCadastroTopico(String titulo, String mensagem, Usuario autor, Curso curso) {
}
