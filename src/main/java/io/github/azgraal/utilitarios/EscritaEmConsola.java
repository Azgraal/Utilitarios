package io.github.azgraal.utilitarios;

import java.util.List;

/**
 * Classe com métodos estáticos usados para apresentar informação na consola.
 */
public class EscritaEmConsola {

    /**
     * Recebe uma lista como parâmetro e mostra o seu conteúdo de maneira simples.
     * @param lista a lista a ser mostrada.
     */
    public static void mostraLista(List<?> lista){
        if (!lista.isEmpty()) {
            for (Object objeto : lista) {
                System.out.println(objeto.toString());
            }
        } else System.out.println("Lista vazia");
    }

    /**
     * Recebe uma lista como parâmetro e mostra o seu conteúdo com numeração ordenada.
     * @param lista a lista a ser mostrada.
     */
    public static void mostraListaNumerada(List<?> lista){
        if (!lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println((i + 1) + " - " + lista.get(i).toString());
            }
        } else System.out.println("Lista vazia");
    }
}
