package io.github.azgraal.data_tempo;

import io.github.azgraal.excecoes.data.DataInvalidaExcecao;
import io.github.azgraal.excecoes.data.AnoInvalidoExcecao;
import io.github.azgraal.excecoes.data.DiaInvalidoExcecao;
import io.github.azgraal.excecoes.data.MesInvalidoExcecao;
import io.github.azgraal.StringsGlobais;

import java.util.Calendar;

/**
 * Classe que permite criar objetos Data que indicam um momento com ano, mês e dia.
 * @author Jorge "Azgraal" Simões
 */
public class Data implements Comparable<Data>, StringsGlobais {

    private int ano;
    private int mes;
    private int dia;

    /**
     * Enumerador com os dias da semana, cada um contendo o nome em string.
     */
    private enum NomeDiaDaSemana {
        DOMINGO(S_DOMINGO),
        SEGUNDA(S_SEGUNDA),
        TERCA(S_TERCA),
        QUARTA(S_QUARTA),
        QUINTA(S_QUINTA),
        SEXTA(S_SEXTA),
        SABADO(S_SABADO);
        private String nomeDia;

        /**
         * Construtor do enumerador, onde é passado por parâmetro o nome do dia em string.
         * @param nomeDia string com o nome do dia da semana a colocar no enumerador.
         */
        NomeDiaDaSemana(String nomeDia){this.nomeDia = nomeDia;}

        /**
         * Devolve uma string com o nome do dia da semana selecionado.
         * @return string com o nome do dia da semana.
         */
        public String getNomeDia() {
            return nomeDia;
        }
    }

    /**
     * Enumerador com os meses do ano, cada um contendo o seu nome e o número de dias desse mês.
     */
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

        /**
         * Construtor do enumerador, onde é passado por parâmetro o nome do mês em string e o número de dias desse mês num número inteiro.
         * @param nomeMes string com o nome do mês.
         * @param diasPorMes número inteiro com o total de dias nesse mês.
         */
        Meses(String nomeMes, int diasPorMes){
            this.nomeMes = nomeMes;
            this.diasPorMes = diasPorMes;
        }

        /**
         * Devolve uma string com o nome do mês selecionado.
         * @return string com o nome do mês.
         */
        public String getNomeMes() {
            return nomeMes;
        }

        /**
         * Devolve um número inteiro com o total de dias do mês selecionado.
         * @return número inteiro com o total de dias do mês.
         */
        public int getDiasPorMes() {
            return diasPorMes;
        }
    }

    /**
     * Construtor que recebe os valores para ano, mês e dia, e com eles cria um objeto Data.
     * @param ano o ano que o objeto deve ter.
     * @param mes o mês que o objeto deve ter.
     * @param dia o dia que o objeto deve ter.
     * @throws DataInvalidaExcecao exceção criada quando os valores do ano, mês e dia não permitem a criação de uma Data válida.
     */
    public Data(int ano, int mes, int dia) throws DataInvalidaExcecao {
        setData(ano, mes, dia);
    }

    /**
     * Construtor vazio que cria um objeto Data com o ano, mês e dia atuais do Sistema.
     */
    private Data(){
        Calendar hoje = Calendar.getInstance();
        ano = hoje.get(Calendar.YEAR);
        mes = hoje.get(Calendar.MONTH) + 1;    // janeiro é representado por 0
        dia = hoje.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Construtor que copia o ano, mês e dia de outro objeto Data para criar um novo.
     * @param outraData a Data a ser copiada.
     */
    public Data(Data outraData) {
        ano = outraData.ano;
        mes = outraData.mes;
        dia = outraData.dia;
    }

    /**
     * Devolve o ano de um certo objeto Data.
     * @return o ano dessa Data.
     */
    public int getAno() {
        return ano;
    }

    /**
     * Devolve o mês de um certo objeto Data.
     * @return o mês dessa Data.
     */
    public int getMes() {
        return mes;
    }

    /**
     * Devolve o dia de um certo objeto Data.
     * @return o dia dessa Data.
     */
    public int getDia() {
        return dia;
    }

    /**
     * Altera os valores do ano, mês e dia de um objeto Data.
     * @param ano o novo valor do ano.
     * @param mes o novo valor do mês.
     * @param dia o novo valor do dia.
     * @throws DataInvalidaExcecao exceção criada quando os valores do ano, mês ou dia não permitem a criação de um objeto Data válido.
     */
    public void setData(int ano, int mes, int dia) throws DataInvalidaExcecao {
        setAno(ano);
        setMes(mes);
        setDia(dia);
    }

    /**
     * Altera o valor do ano de um objeto Data.
     * @param ano o novo valor do ano.
     * @throws AnoInvalidoExcecao exceção criada quando o valor do ano não permite a criação de um objeto Data válido.
     */
    public void setAno(int ano) throws AnoInvalidoExcecao {
        if (ano < 1752){              //Nota: 1752 foi o ano em que o calendário Gregoriano foi adotado
            throw new AnoInvalidoExcecao(ANO_INVALIDO);
        } else {
            this.ano = ano;
        }
    }

    /**
     * Altera o valor do mês de um objeto Data.
     * @param mes o novo valor do mês.
     * @throws MesInvalidoExcecao exceção criada quando o valor do mês não permite a criação de um objeto Data válido.
     */
    public void setMes(int mes) throws MesInvalidoExcecao {
        if (mes > 12){
            throw new MesInvalidoExcecao(MES_INVALIDO);
        } else {
            this.mes = mes;
        }
    }

    /**
     * Altera o valor do dia de um objeto Data.
     * @param dia o novo valor do dia.
     * @throws DiaInvalidoExcecao exceção criada quando o valor do dia não permite a criação de um objeto Data válido.
     */
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

    /**
     * Mostra uma string formatada com a data por extenso.
     * @return string com a data por extenso.
     */
    @Override
    public String toString() {
        return String.format("%s, %d de %s de %d", diaDaSemana(), dia,
                Meses.values()[mes].getNomeMes(), ano);
    }

    /**
     * Mostra a data no formato Ano/Mês/Dia
     * @return string com o ano, mês e dia separados por '/'.
     */
    public String toAnoMesDiaString() {
        return String.format("%04d/%02d/%02d", ano, mes, dia);
    }

    /**
     * Verifica se dois objetos Data são iguais.
     * @param outroObjeto o outro objeto Data a ser comparado.
     * @return devolve verdadeiro ou falso, conforme o resultado.
     */
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

    /**
     * Compara um objeto Data a outro do mesmo tipo.
     * @param outraData o outro objeto Data a ser comparado.
     * @return devolve -1 se for maior que o outraData, 1 se for menor, e 0 se forem iguais.
     */
    @Override
    public int compareTo(Data outraData) {
        return (outraData.isMaior(this)) ? -1 : (isMaior(outraData)) ? 1 : 0;
    }

    /**
     * Mostra o dia da semana em que o objeto Data calha.
     * @return string com o dia da semana correspondente.
     */
    public String diaDaSemana() {
        int totalDias = contaDias();
        totalDias = totalDias % 7;

        return NomeDiaDaSemana.values()[totalDias].getNomeDia();
    }

    /**
     * Verifica se um objeto Data é maior que outro.
     * @param outraData o outro objeto Data a ser comparado.
     * @return devolve verdadeiro ou falso, conforme o resultado.
     */
    public boolean isMaior(Data outraData) {
        int totalDias = contaDias();
        int totalDias1 = outraData.contaDias();

        return totalDias > totalDias1;
    }

    /**
     * Calcula a diferença absoluta de dias entre duas Datas.
     * @param outraData o outro objeto Data a ser comparado.
     * @return devolve um número inteiro com o total de dias de diferença entre as duas Datas.
     */
    public int diferenca(Data outraData) {
        int totalDias = contaDias();
        int totalDias1 = outraData.contaDias();

        return Math.abs(totalDias - totalDias1);
    }

    /**
     * Calcula a diferença absoluta entre duas datas, recebendo os valores de ano, mês e dia que compõem a outra Data.
     * @param ano ano da outra Data.
     * @param mes mes da outra Data.
     * @param dia dia da outra Data.
     * @return devolve um número inteiro com o total de dias de diferença entre as duas Datas.
     * @throws DataInvalidaExcecao exceção criada quando os valores do ano, mês ou dia da outra Data não são válidos.
     */
    public int diferenca(int ano, int mes, int dia) throws DataInvalidaExcecao {
        int totalDias = contaDias();
        Data outraData = new Data(ano, mes, dia);
        int totalDias1 = outraData.contaDias();

        return Math.abs(totalDias - totalDias1);
    }

    /**
     * Verifica se o ano é bissexto.
     * @param ano ano a ser verificado
     * @return devolve verdadeiro ou falso, conforme o resultado
     */
    public static boolean isAnoBissexto(int ano) {
        return ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0;
    }

    /**
     * Devolve a Data atual do Sistema.
     * @return a Data atual do Sistema.
     */
    public static Data dataHoje() {
        return new Data();
    }

    /**
     * Conta o total de dias de uma Data desde o início desse ano.
     * @return o total de dias desta Data desde o início do ano.
     */
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

