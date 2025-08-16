package br.com.paulo.ForumHub.Domain.Respostas;

public record DadosDetalhamentoRespota(
        String mensagem,
        Long usuarioId,
        Long topicoId
) {

}