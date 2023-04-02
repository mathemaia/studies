package Trabalho;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("src/Trabalho/infos/casos/caso0010.txt"));
        ListaDuplamenteEncadeada listaDeMacaquinhos = new ListaDuplamenteEncadeada();
        int idx = 0;

        // Separa as infos de cada linha e instancia os objetos Macaquinhos
        while (in.hasNextLine()) {
            if (idx > 0) {
                // Transforma a linha em um vetor
                String[] linha = in.nextLine().split(" : ");

                // Numero de identificação do Macaquinho
                int numero = Integer.parseInt(linha[0].split(" ")[1]);
                // Para onde enviar os coquinhos com quantidade par de pedrinhas
                int par = Integer.parseInt(linha[0].split(" ")[4]);
                // Para onde enviar os coquinhos com quantidade impar de pedrinhas
                int impar = Integer.parseInt(linha[0].split(" ")[7]);
                // Quantidade total de coquinhos
                int coquinhosTotal = Integer.parseInt(linha[1].strip());
                // Separa o vetor de coquinhos em um vetor de coquinhos com numero par e impar de pedrinhas
                int[] aux = Arrays.stream(linha[2].split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] coquinhosPares = Arrays.stream(aux).filter(n -> n % 2 == 0).toArray();
                int[] coquinhosImpares = Arrays.stream(aux).filter(n -> n % 2 != 0).toArray();

                // Instancia o objeto Macaquinho e insere na lista duplamente encadeada
                listaDeMacaquinhos.append(new Macaquinho(numero, par, impar, coquinhosTotal, coquinhosPares, coquinhosImpares));
            } else {
                in.nextLine();
            }

            idx++;
        }


        for (int i = 0; i < 1; i++) {
            int[] parETotal = new int[2];
            int[] imparETotal = new int[2];
            int vencedor = -1;
            int qtdTotal = -1;

            for (int j = 0; j < listaDeMacaquinhos.size(); j++) {
                // Macaquinho atual
                Macaquinho atual = listaDeMacaquinhos.getNode(j).getMacaquinho();

                // Macaquinho que vai receber os coquinhos com pedrinhas PARES
                listaDeMacaquinhos.getNode(atual.getPar()).getMacaquinho().setCoquinhosPares(atual.getCoquinhosPares());
                // Registra o total de coquinhos do macaquinho que recebeu a quantidade PAR
                parETotal[0] = atual.getPar();
                parETotal[1] = listaDeMacaquinhos.getNode(atual.getPar()).getMacaquinho().getCoquinhosTotal();

                //System.out.println(atual.getPar() + "\n" + Arrays.toString(auxPar));

                // Macaquinho que vai receber os coquinhos com pedrinhas IMPARES
                listaDeMacaquinhos.getNode(atual.getImpar()).getMacaquinho().setCoquinhosImpares(atual.getCoquinhosImpares());
                // Registra o total de coquinhos do macaquinho que recebeu a quantidade IMPAR
                imparETotal[0] = atual.getImpar();
                imparETotal[1] = listaDeMacaquinhos.getNode(atual.getImpar()).getMacaquinho().getCoquinhosTotal();

                // Calculando qual macaquinho tem mais coquinhos
                if (parETotal[1] > imparETotal[1]) {
                    vencedor = parETotal[0];
                    qtdTotal = parETotal[1];
                } else {
                    vencedor = imparETotal[0];
                    qtdTotal = imparETotal[1];
                }

                System.out.println();
            }

            System.out.println();
            System.out.println("Vencedor: " + vencedor + "\nqtdTotal: " + qtdTotal);
            System.out.println(Arrays.toString(listaDeMacaquinhos.getNode(vencedor).getMacaquinho().getCoquinhosPares()));
            System.out.println(Arrays.toString(listaDeMacaquinhos.getNode(vencedor).getMacaquinho().getCoquinhosImpares()));
            System.out.println();
        }


    }
}
