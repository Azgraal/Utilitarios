package io.github.azgraal.utilitarios;

import io.github.azgraal.data_tempo.Data;
import io.github.azgraal.data_tempo.Tempo;
import io.github.azgraal.excecoes.data.DataInvalidaExcecao;
import io.github.azgraal.excecoes.tempo.TempoInvalidoExcecao;
import io.github.azgraal.excecoes.data.AnoInvalidoExcecao;
import io.github.azgraal.excecoes.data.DiaInvalidoExcecao;
import io.github.azgraal.excecoes.data.MesInvalidoExcecao;
import io.github.azgraal.excecoes.tempo.HoraInvalidaExcecao;
import io.github.azgraal.excecoes.tempo.MinutoInvalidoExcecao;
import io.github.azgraal.excecoes.tempo.SegundoInvalidoExcecao;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import io.github.azgraal.StringsGlobais;

import static io.github.azgraal.utilitarios.EscritaEmConsola.mostraListaNumerada;
import static io.github.azgraal.utilitarios.Verificacao.*;

/**
 * Classe com métodos estáticos pensados para fazer leituras de escrita em consola,
 * com as devidas verificações e cíclos, garantindo que têm sempre um resultado válido.
 * @author Jorge "Azgraal" Simões
 */
public class LeituraEmConsola implements StringsGlobais{

    /**
     * Locale disponibilizado para permitir o uso da formatação em PT-PT.
     */
    public static final Locale PORTUGUES = new Locale("pt", "PT");

    /**
     * Lê uma string escrita na consola e verifica se é um número inteiro válido, mostrando antes
     * uma mensagem de informação passada em string.
     * @param instrucao mensagem a apresentar antes de fazer a leitura.
     * @return devolve um número inteiro caso o valor inserido tenha sido válido.
     */
    public static int lerAceitaApenasInteiros(String instrucao){
        Scanner leitura = new Scanner(System.in);
        if (isStringValida(instrucao)){
            System.out.println(instrucao);
        }
        int numeroLido;
        String escrita = leitura.nextLine();
        while (escrita.isBlank() || escrita.isEmpty() || !isStringInteiro(escrita)) {
            System.out.println(NUMERO_INVALIDO + "\n" + instrucao);
            escrita = leitura.nextLine();
        }
        numeroLido = Integer.parseInt(escrita);
        leitura.close();
        return numeroLido;
    }

    /**
     * Lê uma string escrita na consola e verifica se é um número inteiro válido.
     * @return devolve um número inteiro caso o valor inserido tenha sido válido.
     */
    public static int lerAceitaApenasInteiros(){
        Scanner leitura = new Scanner(System.in);
        int numeroLido;
        String escrita = leitura.nextLine();
        if (escrita.isBlank() || escrita.isEmpty() || !isStringInteiro(escrita)) {
            throw new NumberFormatException(NUMERO_INVALIDO);
        }
        numeroLido = Integer.parseInt(escrita);
        //leitura.close();
        return numeroLido;
    }

    /**
     * Lê uma string escrita na consola e verifica se é um número inteiro válido,
     * se está dentro dos limites definidos, mostrando antes uma mensagem de informação
     * passada em string.
     * @param min limite mínimo possível para um número válido.
     * @param max limite máximo possível para um número válido.
     * @param instrucao mensagem a apresentar antes de fazer a leitura.
     * @return devolve um número inteiro caso o valor inserido tenha sido válido e dentro dos limites escolhidos.
     */
    public static int lerAceitaApenasInteirosComLimites(int min, int max, String instrucao) {
        if (min >= max){
            throw new IllegalArgumentException(ERRO_MIN_MAX);
        }
        Scanner leitura = new Scanner(System.in);
        if (isStringValida(instrucao)){
            System.out.println(instrucao);
        }
        int numeroLido;
        do {
            String escrita = leitura.nextLine();
            while (escrita.isBlank() || escrita.isEmpty() || !isStringInteiro(escrita)) {
                System.out.println(NUMERO_INVALIDO + "\n" + instrucao);
                escrita = leitura.nextLine();
            }
            numeroLido = Integer.parseInt(escrita);
            if (numeroLido > max || numeroLido < min) {
                System.out.println(NUMERO_INVALIDO + "\n" + instrucao);
            }
        } while (numeroLido > max || numeroLido < min);
        leitura.close();
        return numeroLido;
    }

    /**
     * Lê uma string escrita na consola e verifica se é um número inteiro válido,
     * se está dentro dos limites definidos.
     * @param min limite mínimo possível para um número válido.
     * @param max limite máximo possível para um número válido.
     * @return devolve um número inteiro caso o valor inserido tenha sido válido e dentro dos limites escolhidos.
     */
    public static int lerAceitaApenasInteirosComLimites(int min, int max){
        if (min >= max){
            throw new IllegalArgumentException(ERRO_MIN_MAX);
        }
        Scanner leitura = new Scanner(System.in);
        int numeroLido;
        String escrita = leitura.nextLine();
        if (escrita.isBlank() || escrita.isEmpty() || !isStringInteiro(escrita)) {
            throw new NumberFormatException(NUMERO_INVALIDO);
        }
        numeroLido = Integer.parseInt(escrita);
        if (numeroLido > max || numeroLido < min) {
            throw new NumberFormatException(ERRO_LIMITES);
        }
        leitura.close();
        return numeroLido;
    }

    /**
     * Lê uma string escrita na consola e verifica se é um float válido, mostrando antes uma mensagem
     * de informação passada em string.
     * @param instrucao mensagem a apresentar antes de fazer a leitura.
     * @return devolve um float caso o valor inserido tenha sido válido
     */
    public static float lerAceitaFloat(String instrucao){
        Scanner leitura = new Scanner(System.in);
        if (isStringValida(instrucao)){
            System.out.println(instrucao);
        }
        float numeroLido;
        String escrita = leitura.nextLine();
        while (escrita.isBlank() || escrita.isEmpty() || !isStringFloat(escrita)){
            System.out.println(NUMERO_INVALIDO + "\n" + instrucao);
            escrita = leitura.nextLine();
        }
        if (escrita.contains(",")){
            escrita = escrita.replaceAll(",", ".");
        }
        numeroLido = Float.parseFloat(escrita);
        leitura.close();
        return numeroLido;
    }

    /**
     * Lê uma string escrita na consola e verifica se é um double válido, mostrando antes uma mensagem
     * de informação passada em string.
     * @param instrucao mensagem a apresentar antes de fazer a leitura.
     * @return devolve um double caso o valor inserido tenha sido válido
     */
    public static double lerAceitaDouble(String instrucao){
        Scanner leitura = new Scanner(System.in);
        if (isStringValida(instrucao)){
            System.out.println(instrucao);
        }
        double numeroLido;
        String escrita = leitura.nextLine();
        while (escrita.isBlank() || escrita.isEmpty() || !isStringDouble(escrita)){
            System.out.println(NUMERO_INVALIDO + "\n" + instrucao);
            escrita = leitura.nextLine();
        }
        if (escrita.contains(",")){
            escrita = escrita.replaceAll(",", ".");
        }
        numeroLido = Double.parseDouble(escrita);
        leitura.close();
        return numeroLido;
    }

    /**
     * Lê uma string escrita na consola e verifica se não está vazia, em branco, ou se não foi nula,
     * mostrando antes uma mensagem de informação passada por string, correndo o cíclo até que seja
     * inserido um valor válido.
     * @param instrucao mensagem a apresentar antes de fazer a leitura.
     * @return devolve uma string quando tiver recebido do teclado uma string válida.
     */
    public static String lerValidaString(String instrucao){
        Scanner leitura = new Scanner(System.in);
        if (isStringValida(instrucao)){
            System.out.println(instrucao);
        }
        String textoLido = leitura.nextLine();
        while (isStringValida(textoLido)){
            System.out.println(VALOR_INVALIDO + "\n" + instrucao);
            textoLido = leitura.nextLine();
        }
        leitura.close();
        return textoLido;
    }


    /**
     * Lê uma string escrita na consola e verifica se não está vazia, em branco, ou se não foi nula,
     * mostrando antes uma mensagem de informação passada por string.
     * @param instrucao mensagem a apresentar antes de fazer a leitura.
     * @return devolve uma string se tiver recebido do teclado uma string válida.
     * @throws IllegalArgumentException exceção criada por não ter recebido uma string válida.
     */
    public static String lerString(String instrucao) throws IllegalArgumentException {
        Scanner leitura = new Scanner(System.in);
        if (isStringValida(instrucao)){
            System.out.println(instrucao);
        }
        String textoLido = leitura.nextLine();
        if (!isStringValida(textoLido)){
            throw new IllegalArgumentException(TEXTO_INVALIDO);
        }
        leitura.close();
        return textoLido;
    }

    /**
     * Lê uma string escrita na consola e verifica se não está vazia, em branco, ou se não foi nula.
     * @return devolve uma string se tiver recebido do teclado uma string válida.
     * @throws IllegalArgumentException exceção criada por não ter recebido uma string válida.
     */
    public static String lerString() throws IllegalArgumentException {
        Scanner leitura = new Scanner(System.in);
        String textoLido = leitura.nextLine();
        if (!isStringValida(textoLido)){
            throw new IllegalArgumentException(TEXTO_INVALIDO);
        }
        leitura.close();
        return textoLido;
    }

    /**
     * Lê uma resposta tipicamente positiva ou negativa a uma pergunta passada por string, e corre um ciclo
     * enquanto não receber nenhum dos dois resultados possíveis.
     * @param instrucao pergunta a ser mostrada antes de ler o que vai ser inserido no teclado.
     * @param confirmar texto esperado na condição positiva (tipicamente 'S')
     * @param rejeitar texto esperado na condição negativa (tipicamente 'N')
     * @return devolve a resposta escolhida.
     */
    public static boolean lerConfirmarSimOuNao(String instrucao, String confirmar, String rejeitar){
        Scanner leitura = new Scanner(System.in);
        if (isStringValida(instrucao)){
            System.out.println(instrucao);
        }
        String linhaLida;
        while ((linhaLida = leitura.nextLine()).isEmpty() ||
                (!(linhaLida = linhaLida.toLowerCase()).equals((confirmar).toLowerCase()) && !linhaLida.equals(rejeitar.toLowerCase()))){
            System.out.println(OPCAO_INVALIDA + "\n" + instrucao);
        }
        leitura.close();
        return linhaLida.equalsIgnoreCase(confirmar);
    }

    /**
     * Mostra uma lista passada por parâmetro, mostra as instruções passadas em string, lê a escolha inserida
     * no teclado e valida-a antes de a devolver.
     * @param lista a lista a ser mostrada, não pode ser nula.
     * @param instrucao mensagem mostrada depois da lista e antes da leitura da escolha.
     * @return devolve a escolha feita, caso tenha sido um valor válido, tanto numericamente como lógicamente
     * face à lista alvo.
     */
    public static int lerEscolherOpcaoLista(@NotNull List<?> lista, String instrucao){
        if (lista.isEmpty()){
            throw new IllegalArgumentException(LISTA_NULA_ERRO);
        } else {
            mostraListaNumerada(lista);
            return  lerAceitaApenasInteirosComLimites(1, lista.size(), instrucao);
        }
    }

    /**
     * Lê valores para horas, minutos e segundos, valida-os, e com eles cria um objeto Tempo.
     * @return devolve o objeto Tempo válido criado.
     * @throws TempoInvalidoExcecao exceção criada caso algum dos valores seja inválido.
     */
    public static Tempo lerECriarTempo() throws TempoInvalidoExcecao {
        Tempo tempoCriado;
        int horaTemp;
        int minutoTemp;
        int segundoTemp;
        try {
            System.out.print("\n" + HORAS_PERGUNTA);
            horaTemp = lerAceitaApenasInteiros();
        } catch (NumberFormatException e){
            throw new HoraInvalidaExcecao(HORA_INVALIDA);
        }
        try {
            System.out.print("\n" + MINUTOS_PERGUNTA);
            minutoTemp = lerAceitaApenasInteiros();
        } catch (NumberFormatException e){
            throw new MinutoInvalidoExcecao(MINUTO_INVALIDO);
        }
        try {
            System.out.println("\n" + SEGUNDOS_PERGUNTA);
            segundoTemp = lerAceitaApenasInteiros();
        } catch (NumberFormatException e){
            throw new SegundoInvalidoExcecao(SEGUNDO_INVALIDO);
        }
        try {
            tempoCriado = new Tempo(horaTemp, minutoTemp, segundoTemp);
            return tempoCriado;
        } catch (TempoInvalidoExcecao e){
            throw new TempoInvalidoExcecao(e.getMessage());
        }
    }

    /**
     * Mostra instruções, lê valores para horas, minutos e segundos, valida-os, e com eles cria um objeto Tempo.
     * @param instrucaoExtra mensagem a ser mostrada antes de fazer a leitura de valores.
     * @return devolve o objeto Tempo válido criado.
     * @throws TempoInvalidoExcecao exceção criada caso algum dos valores seja inválido.
     */
    public static Tempo lerECriarTempo(String instrucaoExtra) throws TempoInvalidoExcecao {
        Tempo tempoCriado;
        int horaTemp;
        int minutoTemp;
        int segundoTemp;
        if (!instrucaoExtra.isBlank() && !instrucaoExtra.isEmpty()){
            System.out.println(instrucaoExtra);
        }
        try {
            System.out.print("\n" + HORAS_PERGUNTA);
            horaTemp = lerAceitaApenasInteiros();
        } catch (NumberFormatException e){
            throw new HoraInvalidaExcecao(HORA_INVALIDA);
        }
        try {
            System.out.print("\n" + MINUTOS_PERGUNTA);
            minutoTemp = lerAceitaApenasInteiros();
        } catch (NumberFormatException e){
            throw new MinutoInvalidoExcecao(MINUTO_INVALIDO);
        }
        try {
            System.out.println("\n" + SEGUNDOS_PERGUNTA);
            segundoTemp = lerAceitaApenasInteiros();
        } catch (NumberFormatException e){
            throw new SegundoInvalidoExcecao(SEGUNDO_INVALIDO);
        }
        try {
            tempoCriado = new Tempo(horaTemp, minutoTemp, segundoTemp);
            return tempoCriado;
        } catch (TempoInvalidoExcecao e){
            throw new TempoInvalidoExcecao(e.getMessage());
        }
    }

    /**
     * Lê valores para ano, mês e dia, valida-os, e com eles cria um objeto Data.
     * @return devolve o objeto Data válido criado.
     * @throws DataInvalidaExcecao exceção criada caso algum dos valores seja inválido.
     */
    public static Data lerECriarData() throws DataInvalidaExcecao {
        Data dataCriada;
        int anoTemp;
        int mesTemp;
        int diaTemp;
        try {
            System.out.println("\n" + ANO_PERGUNTA);
            anoTemp = lerAceitaApenasInteiros();
        } catch (NumberFormatException e){
            throw new AnoInvalidoExcecao(ANO_INVALIDO);
        }
        try {
            System.out.println("\n" + MES_PERGUNTA);
            mesTemp = lerAceitaApenasInteiros();
        } catch (NumberFormatException e){
            throw new MesInvalidoExcecao(MES_INVALIDO);
        }
        try {
            System.out.println("\n" + DIA_PERGUNTA);
            diaTemp = lerAceitaApenasInteiros();
        } catch (NumberFormatException e){
            throw new DiaInvalidoExcecao(DIA_INVALIDO);
        }
        try {
            dataCriada =  new Data(anoTemp, mesTemp, diaTemp);
            return dataCriada;
        } catch (DataInvalidaExcecao e){
            throw new DataInvalidaExcecao(e.getMessage());
        }
    }

    /**
     * Mostra instruções, lê valores para ano, mês e dia, valida-os, e com eles cria um objeto Data.
     * @param instrucaoExtra mensagem a ser mostrada antes de fazer a leitura de valores.
     * @return devolve o objeto Data válido criado.
     * @throws DataInvalidaExcecao exceção criada caso algum dos valores seja inválido.
     */
    public static Data lerECriarData(String instrucaoExtra) throws DataInvalidaExcecao {
        Data dataCriada;
        int anoTemp;
        int mesTemp;
        int diaTemp;
        if (!instrucaoExtra.isBlank() && !instrucaoExtra.isEmpty()){
            System.out.println(instrucaoExtra);
        }
        try {
            System.out.println("\n" + ANO_PERGUNTA);
            anoTemp = lerAceitaApenasInteiros();
        } catch (NumberFormatException e){
            throw new AnoInvalidoExcecao(ANO_INVALIDO);
        }
        try {
            System.out.println("\n" + MES_PERGUNTA);
            mesTemp = lerAceitaApenasInteiros();
        } catch (NumberFormatException e){
            throw new MesInvalidoExcecao(MES_INVALIDO);
        }
        try {
            System.out.println("\n" + DIA_PERGUNTA);
            diaTemp = lerAceitaApenasInteiros();
        } catch (NumberFormatException e){
            throw new DiaInvalidoExcecao(DIA_INVALIDO);
        }
        try {
            dataCriada =  new Data(anoTemp, mesTemp, diaTemp);
            return dataCriada;
        } catch (DataInvalidaExcecao e){
            throw new DataInvalidaExcecao(e.getMessage());
        }
    }
}
