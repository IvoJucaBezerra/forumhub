package br.com.alura.forumhub.domain.course.dto;

import jakarta.validation.constraints.NotNull;

public record DadosCursoAtualizar(
        @NotNull(message = "{id.obrigatorio}")
        Long id,
        String nome,
        String categoria) {
}
