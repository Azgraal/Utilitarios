package io.github.azgraal.data;

import io.github.azgraal.excecoes.AnoInvalidoExcecao;
import io.github.azgraal.excecoes.DiaInvalidoExcecao;
import io.github.azgraal.excecoes.MesInvalidoExcecao;

import java.util.Calendar;


public class Data implements Comparable<Data> {

    private int ano;

    private int mes;


    private int dia;


    private static final int ANO_POR_OMISSAO = 1;


    private static final int MES_POR_OMISSAO = 1;


    private static final int DIA_POR_OMISSAO = 1;


    private static String[] nomeDiaDaSemana = {"Domingo", "Segunda-feira",
            "Terça-feira", "Quarta-feira", "Quinta-feira", "Sexta-feira", "Sábado"};


    private static int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30,
            31, 30, 31};


    private static String[] nomeMes = {"Inválido", "Janeiro", "Fevereiro",
            "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro",
            "Outubro", "Novembro", "Dezembro"};


    public Data(int ano, int mes, int dia, boolean verificacao) throws MesInvalidoExcecao, AnoInvalidoExcecao, DiaInvalidoExcecao {
        if (verificacao){
            setData(ano, mes, dia);
        } else {
            this.ano = ano;
            this.mes = mes;
            this.dia = dia;
        }
    }


    public Data() throws MesInvalidoExcecao, AnoInvalidoExcecao, DiaInvalidoExcecao {
        setData(ANO_POR_OMISSAO, MES_POR_OMISSAO, DIA_POR_OMISSAO);
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


    public void setData(int ano, int mes, int dia) throws AnoInvalidoExcecao, MesInvalidoExcecao, DiaInvalidoExcecao {
        setAno(ano);
        setMes(mes);
        setDia(dia);
    }

    public void setAno(int ano) throws AnoInvalidoExcecao, MesInvalidoExcecao, DiaInvalidoExcecao {
        if (ano <= 0 || ano > dataAtual().getAno()){
            throw new AnoInvalidoExcecao("Data com ano inválido");
        } else {
            this.ano = ano;
        }
    }

    public void setMes(int mes) throws MesInvalidoExcecao {
        if (mes <= 0 || mes > 12) {
            throw new MesInvalidoExcecao("Data com mês inválido");
        } else {
            this.mes = mes;
        }
    }

    public void setDia(int dia) throws DiaInvalidoExcecao {
        int diasMax = diasPorMes[mes];
        if (isAnoBissexto(ano)) {
            diasMax++;
        }
        if (dia <= 0 || dia > diasMax){
            throw new DiaInvalidoExcecao("Data com dia inválido");
        } else {
            this.dia = dia;
        }
    }


    @Override
    public String toString() {
        return String.format("%s, %d de %s de %d", diaDaSemana(), dia,
                nomeMes[mes], ano);
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

        return nomeDiaDaSemana[totalDias];
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


    public int diferenca(int ano, int mes, int dia) throws MesInvalidoExcecao, AnoInvalidoExcecao, DiaInvalidoExcecao {
        int totalDias = contaDias();
        Data outraData = new Data(ano, mes, dia, false);
        int totalDias1 = outraData.contaDias();

        return Math.abs(totalDias - totalDias1);
    }


    public static boolean isAnoBissexto(int ano) {
        return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
    }


    public static Data dataAtual() throws MesInvalidoExcecao, AnoInvalidoExcecao, DiaInvalidoExcecao {
        Calendar hoje = Calendar.getInstance();
        int ano = hoje.get(Calendar.YEAR);
        int mes = hoje.get(Calendar.MONTH) + 1;    // janeiro é representado por 0
        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        return new Data(ano, mes, dia, false);
    }

    private int contaDias() {
        int totalDias = 0;

        for (int i = 1; i < ano; i++) {
            totalDias += isAnoBissexto(i) ? 366 : 365;
        }
        for (int i = 1; i < mes; i++) {
            totalDias += diasPorMes[i];
        }
        totalDias += (isAnoBissexto(ano) && mes > 2) ? 1 : 0;
        totalDias += dia;

        return totalDias;
    }
}

