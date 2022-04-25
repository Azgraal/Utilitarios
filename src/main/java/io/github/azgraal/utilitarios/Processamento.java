package io.github.azgraal.utilitarios;

import io.github.azgraal.excecoes.ExtensaoInvalidaExcecao;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

/**
 * Classe com métodos estáticos para processamento de dados.
 * @author Jorge "Azgraal" Simões
 */
public class Processamento {

    /**
     * Converte as vírgulas decimais em pontos decimais para garantir a compatibilidade
     * nas operações com números, caso sejam inseridos números com parte decimal usando a vírgula
     * como separador.
     * @param string o número, em string, a ser processado.
     * @return devolve o número com o separador decimal transformado em '.'
     */
    public static String converterVirgulaEmPontoDecimal(String string){
        if (string.contains(",")){
            string = string.replaceAll(",", ".");
        }
        return string;
    }

    /**
     * Grava o conteúdo de uma string num ficheiro de texto, confirmando que o ficheiro existe e que tem
     * a extensão correta.
     * @param texto a string com o texto a ser gravado no ficheiro.
     * @param ficheiro o ficheiro destinatário do texto.
     * @throws ExtensaoInvalidaExcecao exceção criada caso a extensão do ficheiro seja inválida.
     * @throws FileNotFoundException exceção criada caso o ficheiro não exista
     */
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

