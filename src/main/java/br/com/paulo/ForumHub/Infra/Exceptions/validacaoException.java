package br.com.paulo.ForumHub.Infra.Exceptions;

public class validacaoException extends RuntimeException {
    public validacaoException(String mensagem) {
        super(mensagem);
    }
}
