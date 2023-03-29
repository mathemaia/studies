package Trabalho;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
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
                int coquinhos = Integer.parseInt(linha[1].strip());
                // Separa o vetor de coquinhos em um vetor de coquinhos com numero par e impar de pedrinhas
                int[] aux = Arrays.stream(linha[2].split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] coquinhosPares = Arrays.stream(aux).filter(n -> n % 2 == 0).toArray();
                int[] coquinhosImpares = Arrays.stream(aux).filter(n -> n % 2 != 0).toArray();

                // Instancia o objeto Macaquinho e insere na lista duplamente encadeada
                listaDeMacaquinhos.append(new Macaquinho(numero, par, impar, coquinhos, coquinhosPares, coquinhosImpares));
            } else {
                in.nextLine();
            }

            idx++;
        }


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < listaDeMacaquinhos.size(); j++) {
                // Macaquinho atual
                Macaquinho atual = listaDeMacaquinhos.getNode(j).getMacaquinho();

                // Macaquinho que vai receber os coquinhos pares
                // Encontra o nodo do macaquinho -> obtem o objeto macaquinho -> redefine seu array de coquinhos pares
                System.out.println(j);
                listaDeMacaquinhos.getNode(atual.getPar()).getMacaquinho().setCoquinhosPares(atual.getCoquinhosPares());

                // Macaquinho que vai receber os coquinhos pares
                listaDeMacaquinhos.getNode(atual.getImpar()).getMacaquinho().setCoquinhosImpares(atual.getCoquinhosImpares());
                System.out.println();
            }
            System.out.println();
        }


    }
}
