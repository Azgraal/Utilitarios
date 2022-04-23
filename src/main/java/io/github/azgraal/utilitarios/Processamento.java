package io.github.azgraal.utilitarios;

import io.github.azgraal.excecoes.ExtensaoInvalidaExcecao;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

public class Processamento {

    public static String converterVirgulaEmPontoDecimal(String string){
        if (string.contains(",")){
            string = string.replaceAll(",", ".");
        }
        return string;
    }

    public static void gravarTextoEmFicheiroTxt(@NotNull String texto, @NotNull File ficheiro) throws ExtensaoInvalidaExcecao, FileNotFoundException {
        String nomeFicheiro = ficheiro.getName();
        nomeFicheiro = nomeFicheiro.substring(nomeFicheiro.length() - 4);
        if (nomeFicheiro.equalsIgnoreCase(".txt")) {
            Formatter escrita = new Formatter(ficheiro);
            escrita.format(texto);
            escrita.close();
        } else {
            throw new ExtensaoInvalidaExcecao("O ficheiro indicado não tem uma extensão válida. Deveria ser .txt");
        }
    }
}

