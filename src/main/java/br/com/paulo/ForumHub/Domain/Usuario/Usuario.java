package br.com.paulo.ForumHub.Domain.Usuario;

import br.com.paulo.ForumHub.Domain.Respostas.Respostas;
import br.com.paulo.ForumHub.Domain.Topicos.Topicos;
import jakarta.persistence.*;
//import jakarta.validation.Valid;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

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

    public Usuario(DadosCadastro dados, String senhaCrpito) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = senhaCrpito;
        this.tipo_perfil = dados.perfil();

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }//classe que controle perfil, tipo perfies de administrador, etc

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
