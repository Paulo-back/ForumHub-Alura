package br.com.paulo.ForumHub.Domain.Respostas;

import br.com.paulo.ForumHub.Domain.Topicos.Topicos;
import br.com.paulo.ForumHub.Domain.Usuario.Usuario;
import jakarta.persistence.*;

import lombok.*;

import java.time.LocalDateTime;


@Table(name = "respostas")
@Entity(name = "Respostas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respostas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topicos topico;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dtCriacao = LocalDateTime.now();;
    private Boolean solucao = false;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;


    public Respostas(DadosCadastroResposta dados, Usuario autor, Topicos topico) {
        this.mensagem = dados.mensagem();
        this.autor = autor;
        this.topico = topico;
        this.solucao = false;
    }
}
