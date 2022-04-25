package io.github.azgraal.excecoes;

/**
 * Exceção geral para os problemas na criação de objetos Data.
 */
public class DataInvalidaExcecao extends Exception{

    /**
     * Construtor vazio da exceção.
     */
    public DataInvalidaExcecao(){
        super();
    }

    /**
     * Construtor da exceção que passa a mensagem recebida.
     * @param mensagem a mensagem gerada pelo erro.
     */
    public DataInvalidaExcecao(String mensagem){
        super(mensagem);
    }
}
