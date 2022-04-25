package io.github.azgraal.excecoes;

/**
 * Exceção geral para os problemas na criação de objetos Tempo.
 */
public class TempoInvalidoExcecao extends Exception{

    /**
     * Construtor vazio da exceção.
     */
    public TempoInvalidoExcecao(){
        super();
    }

    /**
     * Construtor da exceção que passa a mensagem recebida.
     * @param mensagem a mensagem gerada pelo erro.
     */
    public TempoInvalidoExcecao(String mensagem){
        super(mensagem);
    }
}
