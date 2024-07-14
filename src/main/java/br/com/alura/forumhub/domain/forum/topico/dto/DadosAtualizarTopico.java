package br.com.alura.forumhub.domain.forum.topico.dto;

import br.com.alura.forumhub.domain.forum.topico.StatusTopico;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTopico(
        @NotNull(message = "{id.obrigatorio}")
        Long id,
        String titulo,
        String mensagem,
        StatusTopico status) {
}
