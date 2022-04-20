package io.github.azgraal.utilitarios;

import java.util.Locale;
import java.util.Scanner;

public class Utilitarios {

    public static final Locale PORTUGUES = new Locale("pt", "PT");

    public static int lerAceitaApenasInteirosComLimites(int min, int max, String instrucao, String mensagemErro){
        Scanner leitura = new Scanner(System.in);
        if (instrucao != null && !instrucao.isEmpty() && !instrucao.isBlank()) System.out.println(instrucao);
        int numeroLido;
        do {
            while (!leitura.hasNextInt()) {
                System.out.println(mensagemErro + "\n" + instrucao);
                leitura.next();
            }
            numeroLido = leitura.nextInt();
            if (numeroLido > max || numeroLido < min) {
                System.out.println(mensagemErro + "\n" + instrucao);
            }
        } while (numeroLido > max || numeroLido < min);
        //leitura.next();                    //TODO testar se precisa de isto antes de um nextLine()
        return numeroLido;
    }

    public static float lerAceitaFloat(Boolean apenasPositivo, String instrucao, String mensagemErro){
        Scanner leitura = new Scanner(System.in);
        if (instrucao != null && !instrucao.isEmpty() && !instrucao.isBlank()) System.out.println(instrucao);
        float numeroLido;
        do {
            while (!leitura.hasNextFloat()){
                System.out.println(mensagemErro + "\n" + instrucao);
                leitura.next();
            }
            numeroLido = leitura.nextFloat();
            if (apenasPositivo){
                if (numeroLido <= 0){
                    System.out.println(mensagemErro + "\n" + instrucao);
                }
            }
        } while (apenasPositivo && numeroLido <= 0);
        return numeroLido;
    }

    public static String lerAceitaString(String instrucao, String mensagemErro){
        Scanner leitura = new Scanner(System.in);
        if (instrucao != null && !instrucao.isEmpty() && !instrucao.isBlank()) System.out.println(instrucao);
        String textoLido;
        while ((textoLido = leitura.nextLine().trim()).length() == 0){
            System.out.println(mensagemErro + "\n" + instrucao);
        }
        return textoLido;
    }

    public static boolean lerConfirmar(String instrucao, String confirmar, String rejeitar, String mensagemErro){
        Scanner leitura = new Scanner(System.in);
        if (instrucao != null && !instrucao.isEmpty() && !instrucao.isBlank()) System.out.println(instrucao);
        String linhaLida;
        while ((linhaLida = leitura.nextLine()).isEmpty() ||
                (!(linhaLida = linhaLida.toLowerCase()).equals((confirmar).toLowerCase()) && !linhaLida.equals(rejeitar.toLowerCase()))){
            System.out.println(mensagemErro + "\n" + instrucao);
        }
        return linhaLida.equalsIgnoreCase(confirmar);
    }
}
