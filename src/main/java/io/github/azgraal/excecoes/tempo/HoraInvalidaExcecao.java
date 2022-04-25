package io.github.azgraal.excecoes.tempo;

import io.github.azgraal.excecoes.TempoInvalidoExcecao;

/**
 * Exceção para os problemas no valor das horas durante a criação de objetos Tempo.
 * @author Jorge "Azgraal" Simões
 */
public class HoraInvalidaExcecao extends TempoInvalidoExcecao {

    /**
     * Construtor vazio da exceção.
     */
    public HoraInvalidaExcecao(){
        super();
    }

    /**
     * Construtor da exceção que passa a mensagem recebida.
     * @param mensagem a mensagem gerada pelo erro.
     */
    public HoraInvalidaExcecao(String mensagem){
        super(mensagem);
    }
}
