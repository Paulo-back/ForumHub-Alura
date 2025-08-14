package br.com.paulo.ForumHub.Domain.Curso;

import br.com.paulo.ForumHub.Domain.Topicos.Topicos;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private int carga_horaria;
    private String nivel;


    @OneToMany(mappedBy = "curso")
    private List<Topicos> topicos;

    public Curso(DadosCadastroCurso dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.carga_horaria = dados.carga_horaria();
        this.nivel = dados.nivel();
    }
}
