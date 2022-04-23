package io.github.azgraal.excecoes;

public class DataInvalidaExcecao extends Exception{

    public DataInvalidaExcecao(){
        super();
    }

    public DataInvalidaExcecao(String mensagem){
        super(mensagem);
    }
}
