package io.github.azgraal.data_tempo;

import io.github.azgraal.StringsGlobais;
import io.github.azgraal.excecoes.TempoInvalidoExcecao;
import io.github.azgraal.excecoes.tempo.*;

import java.util.Calendar;

public class Tempo implements Comparable<Tempo>, StringsGlobais {

    private int horas;


    private int minutos;

    private int segundos;


    private static final int HORAS_POR_OMISSAO = 0;


    private static final int MINUTOS_POR_OMISSAO = 0;


    private static final int SEGUNDOS_POR_OMISSAO = 0;


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


    public Tempo() {
        horas = HORAS_POR_OMISSAO;
        minutos = MINUTOS_POR_OMISSAO;
        segundos = SEGUNDOS_POR_OMISSAO;
    }


    public Tempo(Tempo outroTempo) {
        horas = outroTempo.horas;
        minutos = outroTempo.minutos;
        segundos = outroTempo.segundos;
    }


    public int getHoras() {
        return horas;
    }


    public int getMinutos() {
        return minutos;
    }


    public int getSegundos() {
        return segundos;
    }


    public void setHoras(int horas) throws TempoInvalidoExcecao {
       try {
           validarHora(horas);
           this.horas = horas;
       } catch (TempoInvalidoExcecao e){
           throw new TempoInvalidoExcecao(e.getMessage());
       }
    }


    public void setMinutos(int minutos) throws TempoInvalidoExcecao {
        try {
            validarMinuto(minutos);
            this.minutos = minutos;
        } catch (TempoInvalidoExcecao e){
            throw new TempoInvalidoExcecao(e.getMessage());
        }
    }


    public void setSegundos(int segundos) throws TempoInvalidoExcecao {
        try {
            validarSegundo(segundos);
            this.segundos = segundos;
        } catch (TempoInvalidoExcecao e){
            throw new TempoInvalidoExcecao(e.getMessage());
        }
    }

    private void validarHora(int hora) throws HoraInvalidaExcecao {
        if (hora > 23){
            throw new HoraInvalidaExcecao(EXCECAO_HORAS);
        }
    }

    private void validarMinuto(int minuto) throws MinutoInvalidoExcecao {
        if (minuto > 59){
            throw new MinutoInvalidoExcecao(EXCECAO_MINUTOS);
        }
    }

    private void validarSegundo(int segundo) throws SegundoInvalidoExcecao {
        if (segundo > 59){
            throw new SegundoInvalidoExcecao(EXCECAO_SEGUNDOS);
        }
    }

    public void setTempo(int horas, int minutos, int segundos) throws TempoInvalidoExcecao {
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


    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d %s",
                (horas == 12 || horas == 0) ? 12 : horas % 12,
                minutos, segundos, horas < 12 ? AM : PM);
    }


    public String toStringHHMMSS() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }


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

