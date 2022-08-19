import java.util.Scanner;

/**
 * Leia 3 valores inteiros e ordene-os em ordem crescente. No final, mostre os valores em ordem crescente, uma linha em
 * branco e em seguida, os valores na sequência como foram lidos.
 * @author Matheus Maia
 * @version 24/06/2022
 */

public class BeeCrowd1042 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] vetor = new int[3];
        int[] vetor2 = new int[3];
        int pivo;

        // Entrada
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = in.nextInt();
        }

        // Criação de um vetor clone
        for (int i = 0; i < vetor.length; i++) {
            vetor2[i] = vetor[i];
        }

        // Sort
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length; j++) {
                if (j + 1 < vetor.length) {
                    if (vetor[j] > vetor[j + 1]) {
                        pivo = vetor[j];
                        vetor[j] = vetor[j + 1];
                        vetor[j + 1] = pivo;
                    }
                }
            }
        }

        // Saídas
        for (int j = 0; j < vetor.length; j++) {
            System.out.println(vetor[j]);
        }
        System.out.println();
        for (int i = 0; i < vetor2.length; i++) {
            System.out.println(vetor2[i]);
        }
    }
}
