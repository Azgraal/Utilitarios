package io.github.azgraal.utilitarios;

import static io.github.azgraal.utilitarios.Processamento.converterVirgulaEmPontoDecimal;

/**
 * Classe com métodos estáticos destinados a fazer verificações de várias condições.
 * @author Jorge "Azgraal" Simões
 */
public class Verificacao {

    /**
     * Verifica se a string passada como parâmetro é um número inteiro válido.
     * @param string a string a ser verificada.
     * @return diz se é a condição é verdadeira ou falsa.
     */
    public static boolean isStringInteiro(String string){
        try {
            int num = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * Verifica se a string passada como parâmetro é um float válido.
     * @param string a string a ser verificada.
     * @return diz se é a condição é verdadeira ou falsa.
     */
    public static boolean isStringFloat(String string){
        try {
            converterVirgulaEmPontoDecimal(string);
            float num = Float.parseFloat(string);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * Verifica se a string passada como parâmetro é um double válido.
     * @param string a string a ser verificada.
     * @return diz se é a condição é verdadeira ou falsa.
     */
    public static boolean isStringDouble(String string){
        try {
            converterVirgulaEmPontoDecimal(string);
            double num = Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * Verifica se a string passada como parâmetro não é nula, não está vazia nem está em branco.
     * @param string a string a ser verificada.
     * @return diz se é a condição é verdadeira ou falsa.
     */
    public static boolean isStringValida(String string){
        if (string != null && !string.isEmpty() && !string.isBlank()){
            return true;
        } else return false;
    }
}
