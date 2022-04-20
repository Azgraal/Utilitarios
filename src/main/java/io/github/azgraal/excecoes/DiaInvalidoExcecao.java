package io.github.azgraal.excecoes;

public class DiaInvalidoExcecao extends Exception{

    public DiaInvalidoExcecao(){
        super();
    }

    public DiaInvalidoExcecao(String mensagem){
        super(mensagem);
    }
}
