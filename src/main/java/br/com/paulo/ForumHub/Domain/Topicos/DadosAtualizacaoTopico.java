package br.com.paulo.ForumHub.Domain.Topicos;

public record DadosAtualizacaoTopico(
        Long autorId,
        String confirmacao,
        String titulo,
        String mensagem,
        Boolean status
) {
    public void aplicarNo(Topicos topico) {
        boolean apenasStatus =
                confirmacao != null && "ok".equalsIgnoreCase(confirmacao.trim()) &&
                        titulo == null && mensagem == null;

        if (apenasStatus) {
            topico.atualizarStatus();
            return;
        }

        if (titulo != null && !titulo.isBlank()) {
            topico.setTitulo(titulo);
        }
        if (mensagem != null && !mensagem.isBlank()) {
            topico.setMensagem(mensagem);
        }
    }

}
