package io.github.azgraal.excecoes.data;

import io.github.azgraal.excecoes.DataInvalidaExcecao;

public class MesInvalidoExcecao extends DataInvalidaExcecao {

    public MesInvalidoExcecao(){
        super();
    }

    public MesInvalidoExcecao(String mensagem){
        super(mensagem);
    }
}
