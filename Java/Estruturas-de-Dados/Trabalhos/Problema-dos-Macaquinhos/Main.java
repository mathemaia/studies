package Trabalho;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("src/Trabalho/infos/casos/caso1000.txt"));
        ArrayList<Macaquinho> listaDeMacaquinhos = new ArrayList<>();
        int idx = 0;
        int rodadas = 0;
        int maiorQtd = -1;
        int maiorNum;

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
                int qtdTotal = Integer.parseInt(linha[1].strip());
                // Calcula as quantidades PARES e IMPARES de coquinhos
                int[] aux = Arrays.stream(linha[2].split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] vetorPar = Arrays.stream(aux).filter(n -> n % 2 == 0).toArray();
                int qtdPar = vetorPar.length;
                int qtdImpar = qtdTotal - qtdPar;

                // Define o macaquinho que tem a maior quantidade de pedrinhas entre todos
                if (maiorQtd < qtdTotal) {
                    maiorQtd = qtdTotal;
                }

                // Instancia o objeto Macaquinho e insere na lista duplamente encadeada
                listaDeMacaquinhos.add(new Macaquinho(numero, enviarPar, enviarImpar, qtdTotal, qtdPar, qtdImpar));
            } else {
                // Grava o número de rodadas
                rodadas = Integer.parseInt(in.nextLine().split(" ")[1]);
            }
            idx++;
        }

        // Computa toda a lógica do jogo, enviando os coquinhos de um macaquinho para outros
        for (int i = 0; i < rodadas; i++) {
            for (int j = 0; j < listaDeMacaquinhos.size(); j++) {
                // Macaquinho atual
                Macaquinho atual = listaDeMacaquinhos.get(j);

                // Macaquinho que vai receber os coquinhos com pedrinhas PARES
                listaDeMacaquinhos.get(atual.getEnviarPar()).setQtdPar(atual.getQtdPar());

                // Macaquinho que vai receber os coquinhos com pedrinhas IMPARES
                listaDeMacaquinhos.get(atual.getEnviarImpar()).setQtdImpar(atual.getQtdImpar());
            }
        }

        // Faz o calculo do vencedor comparando as quantidades totais e finais de coquinhos
        maiorNum = listaDeMacaquinhos.get(0).getNumero();
        maiorQtd = listaDeMacaquinhos.get(0).getQtdTotal();
        for (int i = 1; i < listaDeMacaquinhos.size(); i++) {
            int atual = listaDeMacaquinhos.get(i).getQtdTotal();
            if (atual > maiorQtd) {
                maiorQtd = atual;
                maiorNum = listaDeMacaquinhos.get(i).getNumero();
            }
        }

        // Imprime o vencedor
        System.out.println("RODADAS = " + rodadas);
        System.out.println("\nVencedor: " + maiorNum + "\nqtdTotal: " + maiorQtd);
    }
}
