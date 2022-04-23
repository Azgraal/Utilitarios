package io.github.azgraal.excecoes;

import java.io.IOException;

public class ExtensaoInvalidaExcecao extends IOException {

    public ExtensaoInvalidaExcecao(){
        super();
    }

    public ExtensaoInvalidaExcecao(String mensagem){
        super(mensagem);
    }
}
