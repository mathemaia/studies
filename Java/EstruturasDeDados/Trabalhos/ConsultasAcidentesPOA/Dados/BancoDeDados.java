package Dados;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
import Listas.ListaDeRuas;
import Listas.ListaDeAcidentes;
import Listas.ListaEncadeada;

public class BancoDeDados {
    private ListaDeRuas listaDeRuas;

    /**
     * Construtor.
     * @param endereco endereço do arquivo .csv
     * @throws FileNotFoundException lança exceção caso o arquivo não seja encontrado.
     */
    public BancoDeDados(String endereco) throws FileNotFoundException {
        this.listaDeRuas = new ListaDeRuas();
        lerArquivo(endereco);
        criaListasDeAcidentes(this.listaDeRuas, endereco);
    }

    /**
     * Cria a matriz de dados.
     * @param endereco endereço do csv.
     * @throws FileNotFoundException lança um erro caso não encontre o arquivo.
     */
    private void lerArquivo(String endereco) throws FileNotFoundException {
        Scanner in = new Scanner(new File(endereco));

        // Identifica a coluna da rua.
        String[] colunas = in.nextLine().split(";");
        int idx = 0;
        for (int i = 0; i < colunas.length; i++) {
            if (colunas[i].equals("log1")) {
                idx = i;
            }
        }

        // Cria a lista com todas as ruas.
        while (in.hasNextLine()) {
            if (Objects.equals(in.nextLine(), "")) {

                String[] linha = in.nextLine().split(";");
                if (!this.listaDeRuas.contains(linha[idx])) {
                    this.listaDeRuas.addRua(linha[idx], new ListaDeAcidentes(linha[idx]));
                }
            }
        }
    }

    /**
     * Cria as listas de acidente dentro de cada rua.
     * @param ruas objeto privado ListaDeRua da qual será inserida a lista de acidentes.
     * @param endereco nome da rua que irá receber a lista de acidentes.
     * @throws FileNotFoundException lança uma exceção caso o arquivo não possa ser aberto.
     */
    private void criaListasDeAcidentes(ListaDeRuas ruas, String endereco) throws FileNotFoundException {
        Scanner in = new Scanner(new File(endereco));

        for (int i = 0; in.hasNextLine(); i++) {
            if (Objects.equals(in.nextLine(), "")) {
                String[] linha = in.nextLine().split(";");
                if (ruas.indexOf(linha[5]) != -1) {
                    int idxRua = ruas.indexOf(linha[5]);
                    this.listaDeRuas.listaDeAcidentes(idxRua).addAcidente(linha[0], linha[1], Integer.parseInt(linha[2]), linha[3], linha[4],
                            linha[5], linha[6], Integer.parseInt(linha[7]), Integer.parseInt(linha[8]), Integer.parseInt(linha[9]),
                            Integer.parseInt(linha[10]), Integer.parseInt(linha[11]), Integer.parseInt(linha[12]), Integer.parseInt(linha[13]),
                            Integer.parseInt(linha[14]), Integer.parseInt(linha[15]), Integer.parseInt(linha[16]), Integer.parseInt(linha[17]),
                            linha[18], linha[19], linha[20], linha[21]);
                }
            }
        }
    }

    /**
     * Método que mostra as N ruas com maior quantidade de acidentes.
     * Ex:  maisAcidentes(3) -> retorna as 3 ruas com mais acidentes.
     * @param qtdRuas quantidade de ruas a serem exibidas.
     */
    public ListaEncadeada ruasComMaisAcidentes(int qtdRuas) {
        // Cria uma lista encadeada contendo o total de todos os acidentes por rua.
        ListaEncadeada qtds = new ListaEncadeada();
        for (int i = 0; i < this.listaDeRuas.size(); i++) {
            String nome = String.valueOf(this.listaDeRuas.getRua(i));
            //System.out.println(nome);
            qtds.add(nome, this.listaDeRuas.listaDeAcidentes(i).size());
            //System.out.println(this.listaDeRuas.listaDeAcidentes(i).size());
        }

        // Testa se a quantidade inserida é valida.
        if (qtdRuas > qtds.size() || qtdRuas <= 0) {
            return null;
        }

        // Organiza as quantidades de acidente de cada rua em uma lista.
        qtds.organize();

        return qtds;
    }

    /**
     * Identifica qual o dia que houve mais acidentes em uma determinada rua.
     * @param rua nome da rua.
     * @return dia com mais acidentes.
     */
    public String diasComMaisAcidentes(String rua) {
        ListaEncadeada listaInicial = new ListaEncadeada();
        int idx = this.listaDeRuas.indexOf(rua);
        int tam = this.listaDeRuas.listaDeAcidentes(idx).size();
        // Cria uma lista com elementos únicos (dia) - cada nodo é um dia.
        for (int i = 0; i < tam; i++) {
            String dia = this.listaDeRuas.listaDeAcidentes(idx).getInfo(i, "diaSem");
            if (!listaInicial.contains(dia)) {
                listaInicial.add(dia, null);
            }
        }
        // Adiciona a quantidade de acidentes em cada rua.
        ListaEncadeada listaFinal = new ListaEncadeada();
        for (int i = 0; i < listaInicial.size(); i++) {
            String data = listaInicial.nome(i);
            int qtdAcidentes = this.listaDeRuas.listaDeAcidentes(idx).acidentesPorDia(data);
            listaFinal.add(data, qtdAcidentes);
            this.listaDeRuas.listaDeAcidentes(idx).acidentesPorDia(listaInicial.nome(i));
        }

        // Organiza a lista em ordem decrescente.
        listaFinal.organize();

        return listaFinal.nome(0) + ": " + listaFinal.element(0) + " acidentes.";
    }

    /**
     * Calcula e mostra os acidentes com maior número de veículos
     * @param nome nome da rua.
     * @param quantidade quantidade a ser mostrada.
     */
    public ListaEncadeada acidentesComMaisVeiculos(String nome, int quantidade) {
        ListaEncadeada lista = new ListaEncadeada();
        int idx = this.listaDeRuas.indexOf(nome);
        int tam = this.listaDeRuas.listaDeAcidentes(idx).size();

        // Cria uma lista cujo nodo é um acidente único e seu elemento é a qtd. total de veiculos envolvidos.
        for (int i = 0; i < tam; i++) {
            String[] info = this.listaDeRuas.listaDeAcidentes(idx).getInfo(i, "data").split(" ");
            String data = info[0];
            int qtd = this.listaDeRuas.listaDeAcidentes(idx).qtdVeiculosEnvolvidos(i);
            lista.add(data, qtd);
        }

        // Organiza a lista em ordem decrescente.
        lista.organize();

        // Testa se a quantidade a ser mostrada é válida.
        ListaEncadeada listaFinal = new ListaEncadeada();
        if (quantidade > lista.size() || quantidade <= 0) {
            return null;
        } else {
            // Mostra a quantidade definida.
            for (int i = 0; i < quantidade; i++) {
                listaFinal.add(lista.nome(i), lista.element(i));
            }
        }

        return listaFinal;
    }

    /**
     * Retorna a lista de ruas.
     * @return ListaDeRuas.
     */
    public ListaDeRuas listaDeRuas() {
        return this.listaDeRuas;
    }
}
