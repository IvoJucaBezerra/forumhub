package br.com.alura.forumhub.domain.forum.topico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(
        @NotBlank(message = "{titulo.obrigatorio}")
        String titulo,
        @NotBlank(message = "{mensagem.obrigatoria}")
        String mensagem,
        @NotNull(message = "{autor.obrigatorio}")
        Long autor,
        @NotNull(message = "{curso.obrigatorio}")
        Long curso) {
}
