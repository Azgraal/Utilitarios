package io.github.azgraal.utilitarios;

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

    public static int lerAceitaApenasInteirosComLimites(int min, int max, String instrucao){
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
        return linhaLida.equalsIgnoreCase(confirmar);
    }

    public static int lerEscolherOpcaoLista(List<?> lista, String instrucao){
        if (lista.isEmpty()){
            throw new IllegalArgumentException("A lista não pode ser nula");
        } else {
            mostraListaNumerada(lista);
            return  lerAceitaApenasInteirosComLimites(1, lista.size(), instrucao);
        }
    }
}
