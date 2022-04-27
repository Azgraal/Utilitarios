![image](https://i.imgur.com/tIUI10b.png)

Ferramentas e utilitários pensados para facilitar operações comuns

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.azgraal/utilitarios/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.azgraal/utilitarios)
[![image](https://img.shields.io/github/license/azgraal/utilitarios)](LICENSE)
[![javadoc](https://javadoc.io/badge2/io.github.azgraal/utilitarios/javadoc.svg)](https://javadoc.io/doc/io.github.azgraal/utilitarios)

## Conteúdos:

- Leitura e Escrita de dados em Consola, adequadas a várias situações.
- Classe instanciável Data, permite criar, manipular e comparar datas.
- Classe instanciável Tempo, permite criar, manipular e comparar tempos, seja em contagens ou horas locais.
- Validação de dados, usado para verificar os dados relativos às classes Leitura e Escrita da biblioteca, instâncias de Data e Tempo, ou para uso individual com código do utilizador.
- Processamento de dados, como alterações ou gravação de Strings em ficheiros .txt.

## Desenvolvimento:
Esta biblioteca foi pensada para ser uma compilação de métodos muitas vezes repetidos em muitos projetos, com a ideia de poupar tempo e redundâncias. A ideia fundamental é que seja aumentada e melhorada sempre que surja a necessidade, ou que apareçam outros fragmentos de código repetidos que seja pertinente serem adicionados.

## Como usar:
Basta adicionar o código do Maven Central ao ficheiro pom.xml de qualquer projeto que use Java.

Nota: Já que grande parte dos métodos têm validação de dados de uma forma ou de outra, é recomendado o uso de declarações try-catch (ou indicar o "throws" na assinatura do método, se for mais apropriado) na maior parte das situações para um melhor desempenho.
