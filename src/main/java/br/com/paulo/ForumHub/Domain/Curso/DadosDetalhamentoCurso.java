package br.com.paulo.ForumHub.Domain.Curso;


public record DadosDetalhamentoCurso(
        String nome,
        String decricao,
        Integer carga_horaria,
        String nivel
) {
    public DadosDetalhamentoCurso(Curso curso){
        this(curso.getNome(), curso.getDescricao(), curso.getCarga_horaria(), curso.getNivel());
    }

}
