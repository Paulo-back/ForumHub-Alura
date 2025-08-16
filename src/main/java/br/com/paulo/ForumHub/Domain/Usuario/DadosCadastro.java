package br.com.paulo.ForumHub.Domain.Usuario;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record DadosCadastro(
        @NotBlank
         String nome,

         @NotBlank
         String email,

         @NotBlank
         String senha,

        @NotNull
        TipoPerfil perfil

) {
}

