package org.upskill.utils;

import java.util.Scanner;

public class Inputs {
    private Scanner leitura;

    public boolean introduzirInteiro(int variavelDestino){
        leitura = new Scanner(System.in);
        if (leitura.hasNextInt()){
            variavelDestino = leitura.nextInt();
            return true;
        } else return false;
    }

    public boolean introduzirFloat(float variavelDestino){
        leitura = new Scanner(System.in);
        if (leitura.hasNextInt() || leitura.hasNextFloat()){
            variavelDestino = leitura.nextFloat();
            return true;
        } else return false;
    }

    public boolean primeiraLetraMaiuscula(String variavelDestino){
        leitura = new Scanner(System.in);
        String temp = leitura.nextLine();
        if (Character.isUpperCase(temp.charAt(0))){
            variavelDestino = temp;
            return true;
        } else return false;
    }

}
