package br.com.oracle.exceptions;

public class ParticipanteNaoEncontrado extends RuntimeException {
    public ParticipanteNaoEncontrado(String mensagem) {
        super(mensagem);
    }
}
