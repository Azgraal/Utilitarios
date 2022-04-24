package io.github.azgraal.utilitarios;

import io.github.azgraal.data_tempo.Tempo;
import io.github.azgraal.excecoes.TempoInvalidoExcecao;
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
 */
public class LeituraEmConsola implements StringsGlobais{

    public static final Locale PORTUGUES = new Locale("pt", "PT");

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

    public static int lerAceitaApenasInteiros(){
        Scanner leitura = new Scanner(System.in);
        int numeroLido;
        String escrita = leitura.nextLine();
        if (escrita.isBlank() || escrita.isEmpty() || !isStringInteiro(escrita)) {
            throw new NumberFormatException(NUMERO_INVALIDO);
        }
        numeroLido = Integer.parseInt(escrita);
        leitura.close();
        return numeroLido;
    }

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

    public static float lerAceitaFloat(Boolean apenasPositivo, String instrucao){
        Scanner leitura = new Scanner(System.in);
        if (isStringValida(instrucao)){
            System.out.println(instrucao);
        }
        float numeroLido;
        do {
            String escrita = leitura.nextLine();
            while (escrita.isBlank() || escrita.isEmpty() || !isStringFloat(escrita)){
                System.out.println(NUMERO_INVALIDO + "\n" + instrucao);
                escrita = leitura.nextLine();
            }
            if (escrita.contains(",")){
                escrita = escrita.replaceAll(",", ".");
            }
            numeroLido = Float.parseFloat(escrita);
            if (apenasPositivo){
                if (numeroLido <= 0){
                    System.out.println(NUMERO_INVALIDO + "\n" + instrucao);
                }
            }
        } while (apenasPositivo && numeroLido <= 0);
        leitura.close();
        return numeroLido;
    }

    public static double lerAceitaDouble(Boolean apenasPositivo, String instrucao){
        Scanner leitura = new Scanner(System.in);
        if (isStringValida(instrucao)){
            System.out.println(instrucao);
        }
        double numeroLido;
        do {
            String escrita = leitura.nextLine();
            while (escrita.isBlank() || escrita.isEmpty() || !isStringDouble(escrita)){
                System.out.println(NUMERO_INVALIDO + "\n" + instrucao);
                escrita = leitura.nextLine();
            }
            if (escrita.contains(",")){
                escrita = escrita.replaceAll(",", ".");
            }
            numeroLido = Double.parseDouble(escrita);
            if (apenasPositivo){
                if (numeroLido <= 0){
                    System.out.println(NUMERO_INVALIDO + "\n" + instrucao);
                }
            }
        } while (apenasPositivo && numeroLido <= 0);
        leitura.close();
        return numeroLido;
    }

    public static String lerValidaString(String instrucao){
        Scanner leitura = new Scanner(System.in);
        if (isStringValida(instrucao)){
            System.out.println(instrucao);
        }
        String textoLido = leitura.nextLine();
        while (textoLido == null || textoLido.isEmpty() || textoLido.isBlank()){
            System.out.println(VALOR_INVALIDO + "\n" + instrucao);
            textoLido = leitura.nextLine();
        }
        leitura.close();
        return textoLido;
    }

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

    public static String lerString() throws IllegalArgumentException {
        Scanner leitura = new Scanner(System.in);
        String textoLido = leitura.nextLine();
        if (!isStringValida(textoLido)){
            throw new IllegalArgumentException(TEXTO_INVALIDO);
        }
        leitura.close();
        return textoLido;
    }

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

    public static int lerEscolherOpcaoLista(@NotNull List<?> lista, String instrucao){
        if (lista.isEmpty()){
            throw new IllegalArgumentException(LISTA_NULA_ERRO);
        } else {
            mostraListaNumerada(lista);
            return  lerAceitaApenasInteirosComLimites(1, lista.size(), instrucao);
        }
    }

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
}
