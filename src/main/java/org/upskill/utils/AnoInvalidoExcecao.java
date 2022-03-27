package org.upskill.utils;

public class AnoInvalidoExcecao extends Exception{

    public AnoInvalidoExcecao(){
        super();
    }

    public AnoInvalidoExcecao(String mensagem){
        super(mensagem);
    }
}
