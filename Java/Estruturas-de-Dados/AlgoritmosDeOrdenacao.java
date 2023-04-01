import java.util.Arrays;

/**
 * Esta classe contém os métodos de ordenação Bubble-Sort, Insertion-Sort, Merge-Sort e Quick-Sort.
 * @author matheus maia
 * @version 22-11-2022
 */

public class AlgoritmosDeOrdenacao {
    /**
     * Bubble-Sort: faz a ordenação de par em par, com dois laços encadeados.
     * Complexidade: O(n²)
     * @param vetor vetor a ser organizado.
     * @return vetor organizado.
     */
    public static int[] bubbleSort(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j + 1 <= vetor.length - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int aux = vetor[j + 1];
                    vetor[j + 1] = vetor[j];
                    vetor[j] = aux;
                }
            }
        }
        return vetor;
    }

    /**
     * Insertion-Sort: faz a ordenação um elemento com todos os anteriores.
     * Complexidade O(n log2(n))
     * @param vetor vetor a ser organizado.
     * @return vetor organizado.
     */
    public static int[] insertionSort(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            for (int j = i + 1; j - 1 >= 0; j--) {
                if (vetor[j] < vetor[j - 1]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j - 1];
                    vetor[j - 1] = aux;
                }
            }
        }
        return vetor;
    }

    /**
     * Merge-Sort: faz a ordenação de forma recursiva, dividindo o vetor em metades cada vez menores.
     * Complexidade: O(n) ou O(n log2(n))
     * @param vetor  vetor a ser organizado.
     */
    public static void mergeSort(int[] vetor) {
        int n = vetor.length;

        // Se o vetor já estiver ordenado ou possuir apenas um elemento.
        if (n < 2) {
            return;
        }

        // Divide o vetor em dois: S1 (primeira metade) e S2 (segunda metade).
        int mid = n / 2;
        int[] S1 = Arrays.copyOfRange(vetor, 0, mid);
        int[] S2 = Arrays.copyOfRange(vetor, mid, n);

        // Ordena as cópias
        mergeSort(S1);
        mergeSort(S2);

        // Faz o merge dos dois vetores passados como parâmetro, que juntos formam o vetor passado como parâmetro
        int i = 0;
        int j = 0;
        while ((i + j) < vetor.length) {
            // Se o S1[i] é o MENOR, então:
            if (j == S2.length || (i < S1.length && S1[i] < S2[j])) {
                vetor[i + j] = S1[i];
                i++;
            // Se o S2[j] é o MENOR, então:
            } else {
                vetor[i + j] = S2[j];
                j++;
            }
        }
    }

    /**
     * Quick-Sort: Faz a ordenação a partir de um pivô, dividindo em subarrays menores e maiores que o pivô.
     * @param vetor vetor a ser organizado.
     */
    public static void quickSort(int[] vetor, int low, int high) {
        int pivo = vetor[vetor.length / 2];
        int i = 0;
        int j = vetor.length - 1;

        while (i != j) {
            // Percorre o vetor, começando do inicio, até que o ponteiro aponte para um valor MAIOR que o pivo
            while (low < pivo) {
                i++;
                low = vetor[i];
            }

            // Percorre o vetor, começando do fim, até que o ponteiro aponte para um valor MENOR que o pivo.
            while (high > pivo) {
                j--;
                high = vetor[j];
            }

            // Faz a troca dos valores no vetor
            int aux = vetor[j];
            vetor[j] = vetor[i];
            vetor[i] = aux;

            // Atualiza os ponteiros
            high = vetor[j];
            low = vetor[i];
        }

        // Divide em um subvetor só com os valores MENORES que o pivo
        if (vetor[0] != vetor[i]) {
            quickSort(vetor, vetor[0], vetor[i]);
        }

        // Divide em um sub-vetor só com os valroes maiores que o pivo
        if (vetor[i + 1] != vetor[vetor.length - 1]) {
            quickSort(vetor, vetor[i + 1], vetor[vetor.length - 1]);
        }
    }

    public static void main(String[] args) {
        int[] i = {3, 8, 5, 7, 0, 2, 9, 1, 4, 6};
        quickSort(i, i[0], i[i.length - 1]);
        System.out.println(Arrays.toString(i));

    }
}
