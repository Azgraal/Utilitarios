package org.azgraal.excecoes;

public class AnoInvalidoExcecao extends Exception{

    public AnoInvalidoExcecao(){
        super();
    }

    public AnoInvalidoExcecao(String mensagem){
        super(mensagem);
    }
}
