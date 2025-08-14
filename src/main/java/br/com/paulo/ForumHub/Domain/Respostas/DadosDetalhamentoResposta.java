package br.com.paulo.ForumHub.Domain.Respostas;

import br.com.paulo.ForumHub.Domain.Topicos.DadosDetalhamentoTopico;
import br.com.paulo.ForumHub.Domain.Topicos.Topicos;

import java.time.LocalDateTime;

public record DadosDetalhamentoResposta(
        String topicoIdTitulo,
        String mensagem,
        String autor,
        LocalDateTime local
) {
    public DadosDetalhamentoResposta(Respostas respostas){
        this(respostas.getTopico().getTitulo(),
                respostas.getMensagem(),
                respostas.getAutor().getNome(),
                respostas.getDtCriacao());
    }

}

