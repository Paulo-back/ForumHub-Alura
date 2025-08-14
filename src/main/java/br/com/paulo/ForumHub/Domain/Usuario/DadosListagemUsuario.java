package br.com.paulo.ForumHub.Domain.Usuario;

public record DadosListagemUsuario (
        Long id,
        String nome,
        String email,
        String senha,
        TipoPerfil tipo_perfil
){
    public DadosListagemUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(),usuario.getEmail(), usuario.getSenha(), usuario.getTipo_perfil());
    }
}
