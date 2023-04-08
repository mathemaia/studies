/**
 * Classe com o método de busca binária.
 * OBS: Para realizar a busca binária é necessário que o vetor esteja ordenado de forma crescente .
 * @author matheus maia
 * @version 21-11-2022
 */

public class BuscaBinaria {
    /**
     * Método que faz a busca de forma recursiva.
     * @param numero numero a ser procurado.
     * @param vetor vetor de números (deve estar organizado).
     * @param low referência do menor.
     * @param high referência do maior
     * @return índice do número.
     */
    public static int buscaBinaria(int numero, int low, int high, int[] vetor) {
        int mid = (low + high) / 2;

        // Se não encontrar, retorna -1.
        if (low == high && numero != vetor[mid]) {
            return -1;
        }

        // Faz a busca recursiva.
        if (numero > vetor[mid]) {
            return buscaBinaria(numero, mid + 1, high, vetor);
        } else if (numero < vetor[mid]){
            return buscaBinaria(numero, 0, mid - 1, vetor);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] vetor = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        System.out.println(buscaBinaria(14, 0, vetor.length - 1, vetor));
    }
}


