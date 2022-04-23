package io.github.azgraal.excecoes;

public class TempoInvalidoExcecao extends Exception{

    public TempoInvalidoExcecao(){
        super();
    }

    public TempoInvalidoExcecao(String mensagem){
        super(mensagem);
    }
}
