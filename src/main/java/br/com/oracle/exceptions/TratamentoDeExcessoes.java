package br.com.oracle.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TratamentoDeExcessoes {

    @ExceptionHandler(ParticipanteNaoEncontrado.class)
    public ResponseEntity<MensagemDeErro>participanteNaoEncontrado(){
        var mensagem = new MensagemDeErro(HttpStatus.NOT_FOUND,"participante não encontrado");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
    }

    public ResponseEntity<?>validarParticipante(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros.stream().map(ValidarCampos::new).toList());
    }
}
