package io.github.azgraal.utilitarios;

import io.github.azgraal.excecoes.ExtensaoInvalidaExcecao;
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

    public static void gravarTextoEmFicheiroTxt(String texto, File ficheiro) throws FileNotFoundException, ExtensaoInvalidaExcecao {
        if (!ficheiro.exists()){
            throw new FileNotFoundException("O ficheiro indicado não existe");
        }
        String nomeFicheiro = ficheiro.getName();
        nomeFicheiro = nomeFicheiro.substring(nomeFicheiro.length() - 4);
        if (nomeFicheiro.equalsIgnoreCase(".txt")) {
            Formatter escrita = new Formatter(ficheiro);

            //TODO
        } else {
            throw new ExtensaoInvalidaExcecao("O ficheiro indicado não tem uma extensão válida. Deveria ser .txt");
        }
    }
}

