package io.github.azgraal.utilitarios;

public class Processamento {

    public static String converterVirgulaEmPontoDecimal(String string){
        if (string.contains(",")){
            string = string.replaceAll(",", ".");
        }
        return string;
    }
}

