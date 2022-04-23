package io.github.azgraal.excecoes.tempo;

import io.github.azgraal.excecoes.TempoInvalidoExcecao;

public class HoraInvalidaExcecao extends TempoInvalidoExcecao {

    public HoraInvalidaExcecao(){
        super();
    }

    public HoraInvalidaExcecao(String mensagem){
        super(mensagem);
    }
}
