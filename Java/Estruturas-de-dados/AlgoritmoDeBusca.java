/**
 * Classe com o método de busca binária.
 * OBS: É necessário que o vetor esteja ordenado de forma crescente.
 * @author matheus maia
 * @version 21-11-2022
 */

public class AlgoritmoDeBusca {
    /**
     * Método que faz a busca de forma recursiva.
     * @param numero numero a ser procurado.
     * @param vetor vetor de números (deve estar organizado).
     * @param low referência do menor.
     * @param high referência do maior
     * @return índice do número.
     */
    public static int buscaBinaria(int numero, int[] vetor, int low, int high) {
        int mid = (low + high) / 2;

        // Se encontrar.
        if (numero == vetor[mid]) {
            return mid;
        }

        // Se não encontrar, retorna -1.
        if (low == high) {
            return -1;
        }

        // Faz a busca recursiva.
        if (numero > vetor[mid]) {
            return buscaBinaria(numero, vetor, mid + 1, high);
        } else {
            return buscaBinaria(numero, vetor, low, mid -1);
        }
    }

    public static void main(String[] args) {
        int[] vetor = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        System.out.println(buscaBinaria(2, vetor, 0, vetor.length));
    }
}


