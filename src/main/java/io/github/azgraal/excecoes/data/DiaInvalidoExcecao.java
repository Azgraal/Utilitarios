package io.github.azgraal.excecoes.data;

import io.github.azgraal.excecoes.DataInvalidaExcecao;

/**
 * Exceção para os problemas no valor do dia durante a criação de objetos Data.
 * @author Jorge "Azgraal" Simões
 */
public class DiaInvalidoExcecao extends DataInvalidaExcecao {

    /**
     * Construtor vazio da exceção.
     */
    public DiaInvalidoExcecao(){
        super();
    }

    /**
     * Construtor da exceção que passa a mensagem recebida.
     * @param mensagem a mensagem gerada pelo erro.
     */
    public DiaInvalidoExcecao(String mensagem){
        super(mensagem);
    }
}
