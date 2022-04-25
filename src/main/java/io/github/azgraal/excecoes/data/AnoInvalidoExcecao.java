package io.github.azgraal.excecoes.data;

import io.github.azgraal.excecoes.DataInvalidaExcecao;

/**
 * Exceção para os problemas no valor do ano durante a criação de objetos Data.
 */
public class AnoInvalidoExcecao extends DataInvalidaExcecao {

    /**
     * Construtor vazio da exceção.
     */
    public AnoInvalidoExcecao(){
        super();
    }

    /**
     * Construtor da exceção que passa a mensagem recebida.
     * @param mensagem a mensagem gerada pelo erro.
     */
    public AnoInvalidoExcecao(String mensagem){
        super(mensagem);
    }
}
