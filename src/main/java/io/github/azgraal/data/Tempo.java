package io.github.azgraal.data;

import java.util.Calendar;

public class Tempo implements Comparable<Tempo> {


    private int horas;


    private int minutos;

    private int segundos;


    private static final int HORAS_POR_OMISSAO = 0;


    private static final int MINUTOS_POR_OMISSAO = 0;


    private static final int SEGUNDOS_POR_OMISSAO = 0;


    public Tempo(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }


    public Tempo(int horas, int minutos) {
        this.horas = horas;
        this.minutos = minutos;
        segundos = SEGUNDOS_POR_OMISSAO;
    }


    public Tempo(int horas) {
        this.horas = horas;
        minutos = MINUTOS_POR_OMISSAO;
        segundos = SEGUNDOS_POR_OMISSAO;
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


    public void setHoras(int horas) {
        this.horas = horas;
    }


    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }


    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }


    public void setTempo(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }


    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d %s",
                (horas == 12 || horas == 0) ? 12 : horas % 12,
                minutos, segundos, horas < 12 ? "AM" : "PM");
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


    public boolean isMaior(int horas, int minutos, int segundos) {
        Tempo outroTempo = new Tempo(horas, minutos, segundos);
        return this.toSegundos() > outroTempo.toSegundos();
    }

    public int diferencaEmSegundos(Tempo outroTempo) {
        return Math.abs(toSegundos() - outroTempo.toSegundos());
    }


    public Tempo diferencaEmTempo(Tempo outroTempo) {
        int dif = diferencaEmSegundos(outroTempo);
        int s = dif % 60;
        dif = dif / 60;
        int m = dif % 60;
        int h = dif / 60;
        return new Tempo(h, m, s);
    }


    public static Tempo tempoAtual() {
        Calendar agora = Calendar.getInstance();
        int hora = agora.get(Calendar.HOUR_OF_DAY);
        int minuto = agora.get(Calendar.MINUTE);
        int segundo = agora.get(Calendar.SECOND);
        return new Tempo(hora,minuto,segundo);
    }


    private int toSegundos() {
        return horas * 3600 + minutos * 60 + segundos;
    }

}

