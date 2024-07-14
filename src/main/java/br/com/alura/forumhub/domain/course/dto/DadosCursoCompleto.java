package br.com.alura.forumhub.domain.course.dto;

import br.com.alura.forumhub.domain.course.Curso;

public record DadosCursoCompleto(Long id, String nome, String categoria) {
    public DadosCursoCompleto(Curso curso) {
        this(curso.getId(), curso.getNome(), curso.getCategoria());
    }
}
