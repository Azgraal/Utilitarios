package io.github.azgraal.excecoes;

/**
 * Exceção geral para os problemas na leitura de ficheiros com extensão errada.
 */
import java.io.IOException;

public class ExtensaoInvalidaExcecao extends IOException {

    /**
     * Construtor vazio da exceção.
     */
    public ExtensaoInvalidaExcecao(){
        super();
    }

    /**
     * Construtor da exceção que passa a mensagem recebida.
     * @param mensagem a mensagem gerada pelo erro.
     */
    public ExtensaoInvalidaExcecao(String mensagem){
        super(mensagem);
    }
}
