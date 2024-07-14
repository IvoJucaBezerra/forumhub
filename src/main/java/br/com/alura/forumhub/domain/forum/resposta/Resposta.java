package br.com.alura.forumhub.domain.forum.resposta;

import br.com.alura.forumhub.domain.forum.resposta.dto.DadosAtualizarResposta;
import br.com.alura.forumhub.domain.forum.resposta.dto.DadosCompletoCadastroResposta;
import br.com.alura.forumhub.domain.forum.topico.Topico;
import br.com.alura.forumhub.domain.user.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "respostas")
@Entity(name = "resposta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico")
    private Topico topico;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor")
    private Usuario autor;

    private Boolean solucao = false;

    public Resposta(DadosCompletoCadastroResposta dados) {
        this.mensagem = dados.mensagem();
        this.autor = dados.autor();
        this.topico = dados.topico();
    }

    public void atualizar(DadosAtualizarResposta respostaAtualizada){
        if (respostaAtualizada.mensagem() != null) {
            this.mensagem = respostaAtualizada.mensagem();
        }

        if (respostaAtualizada.solucao() != null) {
            this.solucao = respostaAtualizada.solucao();
        }
    }
}
