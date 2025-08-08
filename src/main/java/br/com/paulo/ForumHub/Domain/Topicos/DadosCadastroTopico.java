package br.com.paulo.ForumHub.Domain.Topicos;

import br.com.paulo.ForumHub.Domain.Curso.Curso;

import java.time.LocalDateTime;

public record DadosCadastroTopico(

          String titulo,
         String mensagem,
          Long autor_id,
          Long curso_id

) {
}
