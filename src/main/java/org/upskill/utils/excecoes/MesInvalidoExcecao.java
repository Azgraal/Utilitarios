package org.upskill.utils.excecoes;

public class MesInvalidoExcecao extends Exception{

    public MesInvalidoExcecao(){
        super();
    }

    public MesInvalidoExcecao(String mensagem){
        super(mensagem);
    }
}
