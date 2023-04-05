package Trabalho;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("src/Trabalho/infos/casos/caso0050.txt"));
        ListaDuplamenteEncadeada listaDeMacaquinhos = new ListaDuplamenteEncadeada();
        int idx = 0;
        int rodadas = 0;

        // Separa as infos de cada linha e instancia os objetos Macaquinhos
        while (in.hasNextLine()) {
            if (idx > 0) {
                // Transforma a linha em um vetor
                String[] linha = in.nextLine().split(" : ");

                // Numero de identificação do Macaquinho
                int numero = Integer.parseInt(linha[0].split(" ")[1]);
                // Para onde enviar os coquinhos com quantidade PAR de pedrinhas
                int enviarPar = Integer.parseInt(linha[0].split(" ")[4]);
                // Para onde enviar os coquinhos com quantidade IMPAR de pedrinhas
                int enviarImpar = Integer.parseInt(linha[0].split(" ")[7]);
                // Quantidade total de coquinhos
                int coquinhosTotal = Integer.parseInt(linha[1].strip());
                // Separa o vetor de coquinhos em um vetor de coquinhos com numero par e impar de pedrinhas
                int[] aux = Arrays.stream(linha[2].split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] coquinhosPares = Arrays.stream(aux).filter(n -> n % 2 == 0).toArray();
                int[] coquinhosImpares = Arrays.stream(aux).filter(n -> n % 2 != 0).toArray();

                // Instancia o objeto Macaquinho e insere na lista duplamente encadeada
                listaDeMacaquinhos.append(new Macaquinho(numero, enviarPar, enviarImpar, coquinhosTotal, coquinhosPares, coquinhosImpares));
            } else {
                // Grava o número de rodadas
                rodadas = Integer.parseInt(in.nextLine().split(" ")[1]);
            }
            idx++;
        }

        // Computa toda a lógica do jogo, enviando os coquinhos de um macaquinho para outros
        int[] parETotal = new int[2];
        int[] imparETotal = new int[2];
        int vencedor = -1;
        int qtdTotal = 0;
        for (int i = 0; i < rodadas; i++) {
            for (int j = 0; j < listaDeMacaquinhos.size(); j++) {
                // Macaquinho atual
                Macaquinho atual = listaDeMacaquinhos.getNode(j).getMacaquinho();

                // Macaquinho que vai receber os coquinhos com pedrinhas PARES
                // encontra o nodo do macaquinho -> obtem o objeto macaquinho -> modifica a qtd de coquinhos
                listaDeMacaquinhos.getNode(atual.getEnviarPar()).getMacaquinho().setCoquinhosPares(atual.getCoquinhosPares());
                // Registra o total de coquinhos do macaquinho que recebeu a quantidade PAR
                parETotal[0] = atual.getEnviarPar();
                parETotal[1] = listaDeMacaquinhos.getNode(atual.getEnviarPar()).getMacaquinho().getCoquinhosTotal();

                // Macaquinho que vai receber os coquinhos com pedrinhas IMPARES
                // encontra o nodo do macaquinho -> obtem o objeto macaquinho -> modifica a qtd de coquinhos
                listaDeMacaquinhos.getNode(atual.getEnviarImpar()).getMacaquinho().setCoquinhosImpares(atual.getCoquinhosImpares());
                // Registra o total de coquinhos do macaquinho que recebeu a quantidade IMPAR
                imparETotal[0] = atual.getEnviarImpar();
                imparETotal[1] = listaDeMacaquinhos.getNode(atual.getEnviarImpar()).getMacaquinho().getCoquinhosTotal();

                // Calculando qual macaquinho tem mais coquinhos
                if (parETotal[1] > imparETotal[1]) {
                    vencedor = parETotal[0];
                    qtdTotal = parETotal[1];
                } else if (parETotal[1] < imparETotal[1]){
                    vencedor = imparETotal[0];
                    qtdTotal = imparETotal[1];
                }
                System.out.println("\nparaPar: " + parETotal[0] + "\n     qtdTotal: " + parETotal[1]);
                System.out.println("paraImpar: " + imparETotal[0] + "\n     qtdTotal: " + imparETotal[1]);

            }
            System.out.println();
        }
        System.out.println("\n***************************");
        System.out.println("RODADAS = " + rodadas);
        System.out.println("\nVencedor: " + vencedor + "\nqtdTotal: " + qtdTotal);


    }
}
