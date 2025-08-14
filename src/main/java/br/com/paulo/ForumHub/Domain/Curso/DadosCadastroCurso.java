package br.com.paulo.ForumHub.Domain.Curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroCurso(
        @NotBlank
        String nome,
        @NotBlank
        String descricao,
        @NotNull
        Integer carga_horaria,
        @NotBlank
        String nivel) {

}
