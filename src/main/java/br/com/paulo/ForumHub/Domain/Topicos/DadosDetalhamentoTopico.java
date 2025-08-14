package br.com.paulo.ForumHub.Domain.Topicos;

import br.com.paulo.ForumHub.Domain.Curso.Curso;
import br.com.paulo.ForumHub.Domain.Usuario.Usuario;

import java.util.Optional;

public record DadosDetalhamentoTopico (
        Long id,String titulo,
        String mensagem, String autor,
        String curso, Boolean status){

    public DadosDetalhamentoTopico(Topicos topicos){
        this(topicos.getId(),
                topicos.getTitulo(),
                topicos.getMensagem(),
                topicos.getAutor().getNome(),
                topicos.getCurso().getNome(),
                topicos.getStatus());

    }

}

