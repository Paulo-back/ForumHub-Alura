package br.com.paulo.ForumHub.Domain.Respostas;

public record DadosCadastroResposta(
        String mensagem,
        Long autorId,
        Long topicoId
) {}
