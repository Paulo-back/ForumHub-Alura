package br.com.paulo.ForumHub.Infra.Exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){

        return ResponseEntity.notFound().build();

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException e){
        var erros = e.getFieldErrors();


        return ResponseEntity.badRequest().body(erros.stream().map(dadosErroValidacao::new).toList());
    }

    @ExceptionHandler(validacaoException.class)
    public ResponseEntity tratarErroRegraDeNegocio(validacaoException e){

        return ResponseEntity.badRequest().body(e.getMessage());
    }

    private record dadosErroValidacao(String campo,String mensagem){
        public dadosErroValidacao(FieldError erro){
            this(erro.getField(),erro.getDefaultMessage());
        }
    }
}
