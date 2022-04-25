package io.github.azgraal.excecoes.data;

import io.github.azgraal.excecoes.DataInvalidaExcecao;

/**
 * Exceção para os problemas no valor do mês durante a criação de objetos Data.
 * @author Jorge "Azgraal" Simões
 */
public class MesInvalidoExcecao extends DataInvalidaExcecao {

    /**
     * Construtor vazio da exceção.
     */
    public MesInvalidoExcecao(){
        super();
    }

    /**
     * Construtor da exceção que passa a mensagem recebida.
     * @param mensagem a mensagem gerada pelo erro.
     */
    public MesInvalidoExcecao(String mensagem){
        super(mensagem);
    }
}
