package br.com.alura.forumhub.domain.course.dto;

import br.com.alura.forumhub.domain.course.Curso;

public record DadosListagemCurso(String nome, String categoria) {
    public DadosListagemCurso(Curso curso) {
        this(curso.getNome(), curso.getCategoria());
    }
}
