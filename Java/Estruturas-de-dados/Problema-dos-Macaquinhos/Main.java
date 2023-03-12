package Alest2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/Alest2/infos/casos/caso1000.txt"));

        ListaDuplamenteEncadeada listaDeMacaquinhos = new ListaDuplamenteEncadeada();

        int i = 0;

        // Separa as infos de cada linha e instancia os objetos Macaquinhos
        while (in.hasNextLine()) {
            if (i > 0) {
                // Transforma a linha em um vetor
                String[] linha = in.nextLine().split(" : ");

                // Cria um vetor com as quantidades de pedrinha
                int[] pedrinhas = Arrays.stream(linha[2].split(" ")).mapToInt(Integer::parseInt).toArray();
                // Quantidade de coquinhos
                int coquinhos = Integer.parseInt(linha[1].strip());
                // Numero de identificação do Macaquinho
                int numero = Integer.parseInt(linha[0].split(" ")[1]);
                // Para onde enviar caso par
                int par = Integer.parseInt(linha[0].split(" ")[4]);
                // Para onde enviar caso impar
                int impar = Integer.parseInt(linha[0].split(" ")[7]);

                /*
                Criar uma lista duplamente encadeada e fazer append dos objetos instanciados
                 */

                listaDeMacaquinhos.append(new Macaquinho(numero, par, impar, coquinhos, pedrinhas));
            // Ignora a primeira linha (que com a qtd de iterações)
            } else {
                in.nextLine();
            }

            i++;
        }

        System.out.println("tamanho: " + listaDeMacaquinhos.size());

        for (int j = 0; j < listaDeMacaquinhos.size(); j++) {
            System.out.println(Arrays.toString(listaDeMacaquinhos.getNode(j).getMacaquinho().getPedrinhas()));
        }

    }
}
