package br.com.paulo.ForumHub.Domain.Topicos;

import br.com.paulo.ForumHub.Domain.Curso.Curso;
import br.com.paulo.ForumHub.Domain.Respostas.Respostas;
import br.com.paulo.ForumHub.Domain.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Table(name = "topicos")
@Entity(name = "Topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topicos {

    private Long id;
    private String titulo;
    private String Mensagem;
    private LocalDateTime datacriacao = LocalDateTime.now();
    private Boolean resolvido;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico")
    private List<Respostas> resposta;

    public Topicos(DadosCadastroTopico dados, Usuario autor, Curso curso) {
        this.titulo = dados.titulo();
        this.Mensagem = dados.mensagem();
        this.autor = autor;
        this.curso = curso;
        this.resolvido = false;
    }
}
