package br.com.paulo.ForumHub.Domain.Usuario;

import br.com.paulo.ForumHub.Domain.Respostas.Respostas;
import br.com.paulo.ForumHub.Domain.Topicos.Topicos;
import jakarta.persistence.*;
//import jakarta.validation.Valid;
import lombok.*;

import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private TipoPerfil tipo_perfil;

    @OneToMany(mappedBy = "autor")
    private List<Topicos> topicos;
    @OneToMany(mappedBy = "autor")
    private List<Respostas> respostas;

    public Usuario(DadosCadastro dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
        this.tipo_perfil = dados.perfil();

    }

}
