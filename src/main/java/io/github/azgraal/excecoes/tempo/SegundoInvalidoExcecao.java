package io.github.azgraal.excecoes.tempo;

/**
 * Exceção para os problemas no valor dos segundos durante a criação de objetos Tempo.
 * @author Jorge "Azgraal" Simões
 */
public class SegundoInvalidoExcecao extends TempoInvalidoExcecao {

    /**
     * Construtor vazio da exceção.
     */
    public SegundoInvalidoExcecao(){
        super();
    }

    /**
     * Construtor da exceção que passa a mensagem recebida.
     * @param mensagem a mensagem gerada pelo erro.
     */
    public SegundoInvalidoExcecao(String mensagem){
        super(mensagem);
    }
}
