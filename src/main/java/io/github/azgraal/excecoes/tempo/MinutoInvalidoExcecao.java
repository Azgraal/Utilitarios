package io.github.azgraal.excecoes.tempo;

import io.github.azgraal.excecoes.TempoInvalidoExcecao;

/**
 * Exceção para os problemas no valor dos minutos durante a criação de objetos Tempo.
 */
public class MinutoInvalidoExcecao extends TempoInvalidoExcecao {

    /**
     * Construtor vazio da exceção.
     */
    public MinutoInvalidoExcecao(){
        super();
    }

    /**
     * Construtor da exceção que passa a mensagem recebida.
     * @param mensagem a mensagem gerada pelo erro.
     */
    public MinutoInvalidoExcecao(String mensagem){
        super(mensagem);
    }
}
