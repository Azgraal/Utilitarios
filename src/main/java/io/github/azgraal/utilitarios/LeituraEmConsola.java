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

import static io.github.azgraal.utilitarios.EscritaEmConsola.mostraListaNumerada;
import static io.github.azgraal.utilitarios.Verificacao.*;

/**
 * Classe com métodos estáticos pensados para fazer leituras de escrita em consola,
 * com as devidas verificações e cíclos, garantindo que têm sempre um resultado válido.
 */
public class LeituraEmConsola {

    public static final Locale PORTUGUES = new Locale("pt", "PT");

    public static int lerAceitaApenasInteiros(String instrucao){
        Scanner leitura = new Scanner(System.in);
        if (isStringValida(instrucao)){
            System.out.println(instrucao);
        }
        int numeroLido;
        String escrita = leitura.nextLine();
        while (escrita.isBlank() || escrita.isEmpty() || !isStringInteiro(escrita)) {
            System.out.println("Número inválido\n" + instrucao);
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
            throw new NumberFormatException("Número inválido");
        }
        numeroLido = Integer.parseInt(escrita);
        leitura.close();
        return numeroLido;
    }

    public static int lerAceitaApenasInteirosComLimites(int min, int max, String instrucao) {
        if (min >= max){
            throw new IllegalArgumentException("O valor mínimo não pode ser maior ou igual ao máximo");
        }
        Scanner leitura = new Scanner(System.in);
        if (isStringValida(instrucao)){
            System.out.println(instrucao);
        }
        int numeroLido;
        do {
            String escrita = leitura.nextLine();
            while (escrita.isBlank() || escrita.isEmpty() || !isStringInteiro(escrita)) {
                System.out.println("Número inválido\n" + instrucao);
                escrita = leitura.nextLine();
            }
            numeroLido = Integer.parseInt(escrita);
            if (numeroLido > max || numeroLido < min) {
                System.out.println("Número inválido\n" + instrucao);
            }
        } while (numeroLido > max || numeroLido < min);
        leitura.close();
        return numeroLido;
    }

    public static int lerAceitaApenasInteirosComLimites(int min, int max){
        if (min >= max){
            throw new IllegalArgumentException("O valor mínimo não pode ser maior ou igual ao máximo");
        }
        Scanner leitura = new Scanner(System.in);
        int numeroLido;
        String escrita = leitura.nextLine();
        if (escrita.isBlank() || escrita.isEmpty() || !isStringInteiro(escrita)) {
            throw new NumberFormatException("Número inválido");
        }
        numeroLido = Integer.parseInt(escrita);
        if (numeroLido > max || numeroLido < min) {
            throw new NumberFormatException("Número fora dos limites escolhidos");
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
                System.out.println("Número inválido\n" + instrucao);
                escrita = leitura.nextLine();
            }
            if (escrita.contains(",")){
                escrita = escrita.replaceAll(",", ".");
            }
            numeroLido = Float.parseFloat(escrita);
            if (apenasPositivo){
                if (numeroLido <= 0){
                    System.out.println("Número inválido\n" + instrucao);
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
                System.out.println("Número inválido\n" + instrucao);
                escrita = leitura.nextLine();
            }
            if (escrita.contains(",")){
                escrita = escrita.replaceAll(",", ".");
            }
            numeroLido = Double.parseDouble(escrita);
            if (apenasPositivo){
                if (numeroLido <= 0){
                    System.out.println("Número inválido\n" + instrucao);
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
            System.out.println("Valor nulo/vazio/em branco não é permitido\n" + instrucao);
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
            throw new IllegalArgumentException("Texto inválido!");
        }
        leitura.close();
        return textoLido;
    }

    public static String lerString() throws IllegalArgumentException {
        Scanner leitura = new Scanner(System.in);
        String textoLido = leitura.nextLine();
        if (!isStringValida(textoLido)){
            throw new IllegalArgumentException("Texto inválido!");
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
            System.out.println("Opção inválida\n" + instrucao);
        }
        leitura.close();
        return linhaLida.equalsIgnoreCase(confirmar);
    }

    public static int lerEscolherOpcaoLista(@NotNull List<?> lista, String instrucao){
        if (lista.isEmpty()){
            throw new IllegalArgumentException("A lista não pode ser nula");
        } else {
            mostraListaNumerada(lista);
            return  lerAceitaApenasInteirosComLimites(1, lista.size(), instrucao);
        }
    }

    public static Tempo lerECriarTempo(String instrucaoExtra) throws TempoInvalidoExcecao {
        int horaTemp = 0;
        int minutoTemp = 0;
        int segundoTemp = 0;
        if (!instrucaoExtra.isBlank() && !instrucaoExtra.isEmpty()){
            System.out.println(instrucaoExtra);
        }
        try {
            System.out.print("\nHoras: ");
            horaTemp = lerAceitaApenasInteiros();
        } catch (NumberFormatException e){
            throw new HoraInvalidaExcecao("Hora inválida");
        }
        try {
            System.out.print("\nMinutos: ");
            minutoTemp = lerAceitaApenasInteiros();
        } catch (NumberFormatException e){
            throw new MinutoInvalidoExcecao("Minuto inválido");
        }
        try {
            System.out.println("\nSegundos: ");
            segundoTemp = lerAceitaApenasInteiros();
        } catch (NumberFormatException e){
            throw new SegundoInvalidoExcecao("Segundo inválido");
        }
        //TODO criar verificação de Tempo válido nos construtores da classe Tempo para depois continuar aqui isto.
    }
}
