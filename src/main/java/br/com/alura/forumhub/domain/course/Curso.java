package br.com.alura.forumhub.domain.course;

import br.com.alura.forumhub.domain.course.dto.DadosCadastroCurso;
import br.com.alura.forumhub.domain.course.dto.DadosCursoAtualizar;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "curso")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    public Curso(DadosCadastroCurso dadosCurso) {
        this.nome = dadosCurso.nome();
        this.categoria = dadosCurso.categoria();
    }

    public void atualizar(DadosCursoAtualizar dadosCurso) {
        if (dadosCurso.nome() != null) {
            this.nome = dadosCurso.nome();
        }
        if (dadosCurso.categoria() != null) {
            this.categoria = dadosCurso.categoria();
        }
    }
}
