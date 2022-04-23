package io.github.azgraal.utilitarios;

import static io.github.azgraal.utilitarios.Processamento.converterVirgulaEmPontoDecimal;

public class Verificacao {

    public static boolean isStringInteiro(String string){
        try {
            int num = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isStringFloat(String string){
        try {
            converterVirgulaEmPontoDecimal(string);
            float num = Float.parseFloat(string);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isStringDouble(String string){
        try {
            converterVirgulaEmPontoDecimal(string);
            double num = Double.parseDouble(string);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isStringValida(String string){
        if (string != null && !string.isEmpty() && !string.isBlank()){
            return true;
        } else return false;
    }
}
