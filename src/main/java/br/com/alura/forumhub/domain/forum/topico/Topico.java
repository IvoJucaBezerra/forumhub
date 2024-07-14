package br.com.alura.forumhub.domain.forum.topico;

import br.com.alura.forumhub.domain.course.Curso;
import br.com.alura.forumhub.domain.course.dto.DadosCursoCompleto;
import br.com.alura.forumhub.domain.forum.resposta.Resposta;
import br.com.alura.forumhub.domain.forum.topico.dto.DadosAtualizarTopico;
import br.com.alura.forumhub.domain.forum.topico.dto.DadosCompletoCadastroTopico;
import br.com.alura.forumhub.domain.user.Usuario;
import br.com.alura.forumhub.domain.user.dto.DadosUsuarioCompleto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "topico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String titulo;

    @Column(nullable = false, unique = true)
    private String mensagem;

    @Column(nullable = false)
    private final LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NAO_RESPONDIDO;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor", nullable = false)
    private Usuario autor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso", nullable = false)
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Resposta> respostas = new ArrayList<>();

    public Topico(DadosCompletoCadastroTopico dadosTopico) {
        this.titulo = dadosTopico.titulo();
        this.mensagem = dadosTopico.mensagem();
        this.autor = dadosTopico.autor();
        this.curso = dadosTopico.curso();
    }

    public DadosUsuarioCompleto getDadosAutor() {
        return new DadosUsuarioCompleto(this.autor);
    }

    public DadosCursoCompleto getDadosCurso() {
        return new DadosCursoCompleto(this.curso);
    }

    public void atualizar(DadosAtualizarTopico dadosTopico) {
        if (dadosTopico.titulo() != null) {
            this.titulo = dadosTopico.titulo();
        }

        if (dadosTopico.mensagem() != null) {
            this.mensagem = dadosTopico.mensagem();
        }

        if (dadosTopico.status() != null) {
            this.status = dadosTopico.status();
        }
    }
}
