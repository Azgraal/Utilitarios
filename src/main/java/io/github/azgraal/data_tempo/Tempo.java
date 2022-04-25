package io.github.azgraal.data_tempo;

import io.github.azgraal.StringsGlobais;
import io.github.azgraal.excecoes.TempoInvalidoExcecao;
import io.github.azgraal.excecoes.tempo.*;

import java.util.Calendar;

/**
 * Classe que permite criar objetos Tempo que indicam um momento com horas, minutos e segundos
 * @author Jorge "Azgraal" Simões
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
     * @throws TempoInvalidoExcecao exceção criada caso haja algum parâmetro inválido durante a validação das horas, minutos e segundos.
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
     * @throws TempoInvalidoExcecao exceção criada caso haja algum parâmetro inválido durante a validação das horas e minutos.
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
     * @throws TempoInvalidoExcecao exceção criada caso haja algum parâmetro inválido durante a validação das horas.
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
            setSegundos(segundos);
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

    /**
     * Compara um objeto Tempo a outro e devolve um resultado que indica qual dois dois é o "maior"
     * @param outroTempo o objeto com o qual comparar o primeiro.
     * @return devolve 1 se o primeiro for maior, -1 se o outroTempo for maior, 0 se forem iguais.
     */
    @Override
    public int compareTo(Tempo outroTempo) {
        return (outroTempo.isMaior(this)) ? -1 : (isMaior(outroTempo)) ? 1 : 0;
    }


    /**
     * Acrescenta um segundo a um Tempo, como se fosse um movimento do ponteiro dos segundos.
     */
    public void tick() {
        segundos = ++segundos % 60;
        if (segundos == 0) {
            minutos = ++minutos % 60;
            if (minutos == 0) {
                horas = ++horas % 24;
            }
        }
    }

    /**
     * Verifica se um objeto Tempo é maior do que outro.
     * @param outroTempo o outro objeto Tempo com o qual comparar o primeiro.
     * @return devolve verdadeiro ou falso, conforme o primeiro Tempo seja maior ou menor que o outro.
     */
    public boolean isMaior(Tempo outroTempo) {
        return toSegundos() > outroTempo.toSegundos();
    }

    /**
     * Verifica se um objeto Tempo é maior que outro Tempo formado pela hora, minutos e segundos passados como parâmetro.
     * @param horas horas a verificar
     * @param minutos minutos a verificar
     * @param segundos segundos a verificar
     * @return devolve verdadeiro ou falso, conforme o primeiro Tempo seja maior ou menor que o outro.
     * @throws TempoInvalidoExcecao exceção criada caso os parâmetros passados não formem um objeto Tempo que seja válido.
     */
    public boolean isMaior(int horas, int minutos, int segundos) throws TempoInvalidoExcecao {
        try {
            Tempo outroTempo = new Tempo(horas, minutos, segundos);
            return this.toSegundos() > outroTempo.toSegundos();
        } catch (TempoInvalidoExcecao e){
            throw new TempoInvalidoExcecao(e.getMessage());
        }
    }

    /**
     * Calcula a diferença absoluta em segundos de um Tempo para outro.
     * @param outroTempo o outro Tempo a ser comparado.
     * @return devolve o valor absoluto em segundos da diferença entre os dois Tempos.
     */
    public int diferencaEmSegundos(Tempo outroTempo) {
        return Math.abs(toSegundos() - outroTempo.toSegundos());
    }

    /**
     * Calcula a diferença de um Tempo para o outro, criando um terceiro objeto Tempo com o resultado.
     * @param outroTempo o outro Tempo a ser comparado.
     * @return devolve um objeto Tempo com a diferença entre os dois Tempos comparados.
     * @throws TempoInvalidoExcecao exceção criada quando o Tempo resultante não é válido.
     */
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

    /**
     * Cria um objeto Tempo com as horas, minutos e segundos atuais do Sistema.
     * @return devolve o Tempo atual do Sistema naquele instante.
     * @throws TempoInvalidoExcecao exceção criada quando o Tempo resultante é inválido.
     */
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

    /**
     * Converte um objeto Tempo no número total de segundos.
     * @return devolve um número inteiro com o total de segundos.
     */
    private int toSegundos() {
        return horas * 3600 + minutos * 60 + segundos;
    }

}

