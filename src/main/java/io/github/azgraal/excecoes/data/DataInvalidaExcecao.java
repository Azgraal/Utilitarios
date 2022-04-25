package io.github.azgraal.excecoes.data;

/**
 * Exceção geral para os problemas na criação de objetos Data.
 * @author Jorge "Azgraal" Simões
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
