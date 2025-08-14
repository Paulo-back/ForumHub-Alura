package br.com.paulo.ForumHub.Domain.Usuario;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

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

