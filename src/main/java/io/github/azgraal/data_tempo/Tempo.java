package io.github.azgraal.data_tempo;

import io.github.azgraal.StringsGlobais;
import io.github.azgraal.excecoes.TempoInvalidoExcecao;
import io.github.azgraal.excecoes.tempo.*;

import java.util.Calendar;

/**
 * Classe que permite criar objetos Tempo que indicam um momento com horas, minutos e segundos
 */
public class Tempo implements Comparable<Tempo>, StringsGlobais {

    private int horas;


    private int minutos;

    private int segundos;


    private static final int HORAS_POR_OMISSAO = 0;


    private static final int MINUTOS_POR_OMISSAO = 0;


    private static final int SEGUNDOS_POR_OMISSAO = 0;


    /**
     * Construtor que recebe os valores para horas, minutos e segundos, e cria um objeto Tempo.
     * @param horas as horas que o objeto deve ter.
     * @param minutos os minutos que o objeto deve ter.
     * @param segundos os segundos que o objeto deve ter.
     * @throws TempoInvalidoExcecao exceção criada caso haja algum parâmetro inválido durante a validação
     * das horas, minutos e segundos.
     */
    public Tempo(int horas, int minutos, int segundos) throws TempoInvalidoExcecao {
        try {
            validarHora(horas);
            validarMinuto(minutos);
            validarSegundo(segundos);
            this.horas = horas;
            this.minutos = minutos;
            this.segundos = segundos;
        } catch (TempoInvalidoExcecao e){
            throw new TempoInvalidoExcecao(e.getMessage());
        }
    }


    /**
     * Construtor que recebe os valores para horas e minutos, e cria um objeto Tempo.
     * @param horas as horas que o objeto deve ter.
     * @param minutos os minutos que o objeto deve ter.
     * @throws TempoInvalidoExcecao exceção criada caso haja algum parâmetro inválido durante a validação
     * das horas e minutos.
     */
    public Tempo(int horas, int minutos) throws TempoInvalidoExcecao {
        try {
            validarHora(horas);
            validarMinuto(minutos);
            this.horas = horas;
            this.minutos = minutos;
            segundos = SEGUNDOS_POR_OMISSAO;
        } catch (TempoInvalidoExcecao e){
            throw new TempoInvalidoExcecao(e.getMessage());
        }
    }

    /**
     * Construtor que recebe os valores para horas e cria um objeto Tempo.
     * @param horas as horas que o objeto deve ter.
     * @throws TempoInvalidoExcecao exceção criada caso haja algum parâmetro inválido durante a validação
     * das horas.
     */
    public Tempo(int horas) throws TempoInvalidoExcecao {
        try {
            validarHora(horas);
            this.horas = horas;
            minutos = MINUTOS_POR_OMISSAO;
            segundos = SEGUNDOS_POR_OMISSAO;
        } catch (TempoInvalidoExcecao e){
            throw new TempoInvalidoExcecao(e.getMessage());
        }
    }

    /**
     * Construtor vazio que cria um objeto Tempo.
     * @throws TempoInvalidoExcecao exceção criada caso haja algum parâmetro inválido durante a validação
     * do tempo.
     */
    public Tempo() {
        horas = HORAS_POR_OMISSAO;
        minutos = MINUTOS_POR_OMISSAO;
        segundos = SEGUNDOS_POR_OMISSAO;
    }

    /**
     * Construtor que recebe um objeto Tempo para criar um novo com as mesmas horas, minutos e segundos.
     * @param outroTempo Tempo com os parâmetros a copiar.
     */
    public Tempo(Tempo outroTempo) {
        horas = outroTempo.horas;
        minutos = outroTempo.minutos;
        segundos = outroTempo.segundos;
    }

    /**
     * Devolve o valor das horas de um Tempo.
     * @return o valor das horas.
     */
    public int getHoras() {
        return horas;
    }

    /**
     * Devolve o valor dos minutos de um Tempo.
     * @return o valor dos minutos.
     */
    public int getMinutos() {
        return minutos;
    }

    /**
     * Devolve o valor dos segundos de um Tempo.
     * @return o valor dos segundos.
     */
    public int getSegundos() {
        return segundos;
    }

    /**
     * Altera os valores completos do Tempo para os novos valores indicados.
     * @param horas o novo valor das horas.
     * @param minutos o novo valor dos minutos.
     * @param segundos o novo valor dos segundos.
     * @throws TempoInvalidoExcecao exceção criada caso algum dos novos valores seja inválido.
     */
    public void setTempo(int horas, int minutos, int segundos) throws TempoInvalidoExcecao {
        try {
            setHoras(horas);
            setMinutos(minutos);
            setSegundos(segundos);                                              //TODO testar antes de publicar!!!!!
        } catch (TempoInvalidoExcecao e){
            throw new TempoInvalidoExcecao(e.getMessage());
        }
    }

    /**
     * Altera o valor das horas de um Tempo para o valor indicado.
     * @param horas o novo valor das horas.
     * @throws TempoInvalidoExcecao exceção criada caso o novo valor seja inválido.
     */
    public void setHoras(int horas) throws TempoInvalidoExcecao {
       try {
           validarHora(horas);
           this.horas = horas;
       } catch (TempoInvalidoExcecao e){
           throw new TempoInvalidoExcecao(e.getMessage());
       }
    }

    /**
     * Altera o valor dos minutos de um Tempo para o valor indicado.
     * @param minutos o novo valor dos minutos.
     * @throws TempoInvalidoExcecao exceção criada caso o novo valor seja inválido.
     */
    public void setMinutos(int minutos) throws TempoInvalidoExcecao {
        try {
            validarMinuto(minutos);
            this.minutos = minutos;
        } catch (TempoInvalidoExcecao e){
            throw new TempoInvalidoExcecao(e.getMessage());
        }
    }

    /**
     * Altera o valor dos segundos de um Tempo para o valor indicado.
     * @param segundos o novo valor dos segundos.
     * @throws TempoInvalidoExcecao exceção criada caso o novo valor seja inválido.
     */
    public void setSegundos(int segundos) throws TempoInvalidoExcecao {
        try {
            validarSegundo(segundos);
            this.segundos = segundos;
        } catch (TempoInvalidoExcecao e){
            throw new TempoInvalidoExcecao(e.getMessage());
        }
    }

    /**
     * Verifica se o valor indicado para as horas é válido.
     * @param hora valor das horas.
     * @throws HoraInvalidaExcecao exceção criada caso o valor das horas seja inválido.
     */
    private void validarHora(int hora) throws HoraInvalidaExcecao {
        if (hora > 23){
            throw new HoraInvalidaExcecao(EXCECAO_HORAS);
        }
    }

    /**
     * Verifica se o valor indicado para os minutos é válido.
     * @param minuto valor dos minutos.
     * @throws MinutoInvalidoExcecao exceção criada caso o valor dos minutos seja inválido.
     */
    private void validarMinuto(int minuto) throws MinutoInvalidoExcecao {
        if (minuto > 59){
            throw new MinutoInvalidoExcecao(EXCECAO_MINUTOS);
        }
    }

    /**
     * Verifica se o valor indicado para os segundos é válido.
     * @param segundo valor dos segundos.
     * @throws SegundoInvalidoExcecao exceção criada caso o valor dos segundos seja inválido.
     */
    private void validarSegundo(int segundo) throws SegundoInvalidoExcecao {
        if (segundo > 59){
            throw new SegundoInvalidoExcecao(EXCECAO_SEGUNDOS);
        }
    }

    /**
     * Mostra o Tempo por extenso na consola de maneira formatada, segundo o padrão de 12 horas.
     * @return a string com o Tempo por extenso.
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d %s",
                (horas == 12 || horas == 0) ? 12 : horas % 12,
                minutos, segundos, horas < 12 ? AM : PM);
    }

    /**
     * Mostra o Tempo por extenso na consola de maneira formatada, segundo o padrão de 24 horas.
     * @return a string com o Tempo por extenso.
     */
    public String toStringHHMMSS() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    /**
     * Verifica se um objeto Tempo é igual a outro.
     * @param outroObjeto o outro Tempo.
     * @return devolve verdadeiro ou falso conforme os dois objetos sejam iguais ou não.
     */
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Tempo outroTempo = (Tempo) outroObjeto;
        return horas == outroTempo.horas && minutos == outroTempo.minutos
                && segundos == outroTempo.segundos;
    }


    @Override
    public int compareTo(Tempo outroTempo) {
        return (outroTempo.isMaior(this)) ? -1 : (isMaior(outroTempo)) ? 1 : 0;
    }


    public void tick() {
        segundos = ++segundos % 60;
        if (segundos == 0) {
            minutos = ++minutos % 60;
            if (minutos == 0) {
                horas = ++horas % 24;
            }
        }
    }

    public boolean isMaior(Tempo outroTempo) {
        return toSegundos() > outroTempo.toSegundos();
    }


    public boolean isMaior(int horas, int minutos, int segundos) throws TempoInvalidoExcecao {
        try {
            Tempo outroTempo = new Tempo(horas, minutos, segundos);
            return this.toSegundos() > outroTempo.toSegundos();
        } catch (TempoInvalidoExcecao e){
            throw new TempoInvalidoExcecao(e.getMessage());
        }
    }

    public int diferencaEmSegundos(Tempo outroTempo) {
        return Math.abs(toSegundos() - outroTempo.toSegundos());
    }


    public Tempo diferencaEmTempo(Tempo outroTempo) throws TempoInvalidoExcecao {
        Tempo tempoCriado;
        int dif = diferencaEmSegundos(outroTempo);
        int s = dif % 60;
        dif = dif / 60;
        int m = dif % 60;
        int h = dif / 60;
        try {
            tempoCriado = new Tempo(h, m, s);
        } catch (TempoInvalidoExcecao e){
            throw new TempoInvalidoExcecao(e.getMessage());
        }
        return tempoCriado;
    }


    public static Tempo tempoAtual() throws TempoInvalidoExcecao {
        Tempo tempoCriado;
        Calendar agora = Calendar.getInstance();
        int hora = agora.get(Calendar.HOUR_OF_DAY);
        int minuto = agora.get(Calendar.MINUTE);
        int segundo = agora.get(Calendar.SECOND);
        try {
            tempoCriado = new Tempo(hora,minuto,segundo);
        } catch (TempoInvalidoExcecao e){
            throw new TempoInvalidoExcecao(e.getMessage());
        }
        return tempoCriado;
    }


    private int toSegundos() {
        return horas * 3600 + minutos * 60 + segundos;
    }

}

