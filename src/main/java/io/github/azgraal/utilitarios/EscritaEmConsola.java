package io.github.azgraal.utilitarios;

import java.util.List;

public class EscritaEmConsola {

    public static void mostraLista(List<?> lista){
        if (!lista.isEmpty()) {
            for (Object objeto : lista) {
                System.out.println(objeto.toString());
            }
        } else System.out.println("Lista vazia");
    }

    public static void mostraListaNumerada(List<?> lista){
        if (!lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + " - " + lista.get(i).toString());
            }
        } else System.out.println("Lista vazia");
    }
}
