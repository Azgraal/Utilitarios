package io.github.azgraal.excecoes;

public class MesInvalidoExcecao extends Exception{

    public MesInvalidoExcecao(){
        super();
    }

    public MesInvalidoExcecao(String mensagem){
        super(mensagem);
    }
}
