package io.github.azgraal.data_tempo;

import io.github.azgraal.excecoes.DataInvalidaExcecao;
import io.github.azgraal.excecoes.data.AnoInvalidoExcecao;
import io.github.azgraal.excecoes.data.DiaInvalidoExcecao;
import io.github.azgraal.excecoes.data.MesInvalidoExcecao;
import io.github.azgraal.StringsGlobais;

import java.util.Calendar;

public class Data implements Comparable<Data>, StringsGlobais {

    private int ano;
    private int mes;
    private int dia;

    private enum NomeDiaDaSemana {
        DOMINGO(S_DOMINGO),
        SEGUNDA(S_SEGUNDA),
        TERCA(S_TERCA),
        QUARTA(S_QUARTA),
        QUINTA(S_QUINTA),
        SEXTA(S_SEXTA),
        SABADO(S_SABADO);
        private String nomeDia;
        NomeDiaDaSemana(String nomeDia){this.nomeDia = nomeDia;}
        public String getNomeDia() {
            return nomeDia;
        }
    }

    private enum Meses{
        INVALIDO("", 0),
        JANEIRO(S_JANEIRO, 31),
        FEVEREIRO(S_FEVEREIRO, 28),
        MARCO(S_MARCO, 31),
        ABRIL(S_ABRIL, 30),
        MAIO(S_MAIO, 31),
        JUNHO(S_JUNHO, 30),
        JULHO(S_JULHO, 31),
        AGOSTO(S_AGOSTO, 31),
        SETEMBRO(S_SETEMBRO, 30),
        OUTUBRO(S_OUTUBRO, 31),
        NOVEMBRO(S_NOVEMBRO, 30),
        DEZEMBRO(S_DEZEMBRO, 31);
        private String nomeMes;
        private int diasPorMes;
        Meses(String nomeMes, int diasPorMes){
            this.nomeMes = nomeMes;
            this.diasPorMes = diasPorMes;
        }
        public String getNomeMes() {
            return nomeMes;
        }
        public int getDiasPorMes() {
            return diasPorMes;
        }
    }

    public Data(int ano, int mes, int dia) throws DataInvalidaExcecao {
        setData(ano, mes, dia);
    }

    private Data(){
        Calendar hoje = Calendar.getInstance();
        ano = hoje.get(Calendar.YEAR);
        mes = hoje.get(Calendar.MONTH) + 1;    // janeiro é representado por 0
        dia = hoje.get(Calendar.DAY_OF_MONTH);
    }

    public Data(Data outraData) {
        ano = outraData.ano;
        mes = outraData.mes;
        dia = outraData.dia;
    }


    public int getAno() {
        return ano;
    }


    public int getMes() {
        return mes;
    }


    public int getDia() {
        return dia;
    }

    public void setData(int ano, int mes, int dia) throws DataInvalidaExcecao {
        setAno(ano);
        setMes(mes);
        setDia(dia);
    }

    public void setAno(int ano) throws AnoInvalidoExcecao {
        if (ano < 1752){              //Nota: 1752 foi o ano em que o calendário Gregoriano foi adotado
            throw new AnoInvalidoExcecao(ANO_INVALIDO);
        } else {
            this.ano = ano;
        }
    }

    public void setMes(int mes) throws MesInvalidoExcecao {
        if (mes > 12){
            throw new MesInvalidoExcecao(MES_INVALIDO);
        } else {
            this.mes = mes;
        }
    }

    public void setDia(int dia) throws DiaInvalidoExcecao {
        int diasNoMes = Meses.values()[mes].diasPorMes;
        if (isAnoBissexto(ano)){
            diasNoMes++;
        }
        if (dia > diasNoMes){
            throw new DiaInvalidoExcecao(DIA_INVALIDO);
        } else {
            this.dia = dia;
        }
    }


    @Override
    public String toString() {
        return String.format("%s, %d de %s de %d", diaDaSemana(), dia,
                Meses.values()[mes].getNomeMes(), ano);
    }


    public String toAnoMesDiaString() {
        return String.format("%04d/%02d/%02d", ano, mes, dia);
    }


    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || getClass() != outroObjeto.getClass()) {
            return false;
        }
        Data outraData = (Data) outroObjeto;
        return ano == outraData.ano && mes == outraData.mes
                && dia == outraData.dia;
    }


    @Override
    public int compareTo(Data outraData) {
        return (outraData.isMaior(this)) ? -1 : (isMaior(outraData)) ? 1 : 0;
    }


    public String diaDaSemana() {
        int totalDias = contaDias();
        totalDias = totalDias % 7;

        return NomeDiaDaSemana.values()[totalDias].getNomeDia();
    }

    public boolean isMaior(Data outraData) {
        int totalDias = contaDias();
        int totalDias1 = outraData.contaDias();

        return totalDias > totalDias1;
    }


    public int diferenca(Data outraData) {
        int totalDias = contaDias();
        int totalDias1 = outraData.contaDias();

        return Math.abs(totalDias - totalDias1);
    }


    public int diferenca(int ano, int mes, int dia) throws DataInvalidaExcecao {
        int totalDias = contaDias();
        Data outraData = new Data(ano, mes, dia);
        int totalDias1 = outraData.contaDias();

        return Math.abs(totalDias - totalDias1);
    }


    public static boolean isAnoBissexto(int ano) {
        return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
    }


    public static Data dataHoje() {
        return new Data();
    }

    private int contaDias() {
        int totalDias = 0;
        for (int i = 1; i < ano; i++) {
            totalDias += isAnoBissexto(i) ? 366 : 365;
        }
        for (int i = 1; i < mes; i++) {
            int diasNoMes = Meses.values()[i].diasPorMes;
            if (isAnoBissexto(ano)){
                diasNoMes++;
            }
            totalDias += diasNoMes;
        }
        totalDias += (isAnoBissexto(ano) && mes > 2) ? 1 : 0;
        totalDias += dia;

        return totalDias;
    }
}

