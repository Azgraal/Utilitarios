package io.github.azgraal.excecoes.tempo;

/**
 * Exceção geral para os problemas na criação de objetos Tempo.
 * @author Jorge "Azgraal" Simões
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
