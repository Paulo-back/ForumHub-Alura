package br.com.paulo.ForumHub.Domain.Respostas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroResposta(

        @NotBlank
        String mensagem,
        @NotNull
        Long topicoId,
        @NotNull
        Long usuarioId
) {}
