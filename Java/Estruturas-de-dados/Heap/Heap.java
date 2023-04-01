import java.util.Objects;

/**
 * Classe que implementa a Estrutura Abstrata de Dados Heap utilizando array.
 * @author matheus maia
 * @version 25-03-2923
 */

public class Heap {
    Integer[] vetor;

    /**
     * Construtor
     * @param array vetor que irá se transformar em heap
     */
    public Heap(Integer[] array) {
        this.vetor = array;
    }

    /**
     * Retorna os filhos do elemento passado como parâmetro
     * @param element elemento pai
     * @return filhos
     */
    public Integer[] childs(Integer element) {
        // Procura pelo elemento no vetor
        int idx = -1;
        for (int i = 0; i < vetor.length; i++) {
            if (Objects.equals(element, vetor[i])){
                idx = i;
                break;
            }
        }

        Integer[] aux = new Integer[2];
        // Se o elemento tiver apenas o filho da esquerda
        if (idx >= 0 && ((2 * idx) + 1) > vetor.length) {
            aux[0] = null;
            aux[1] = null;
        // Se o elemento não tiver filhos
        } else if (idx >= 0 && ((2 * idx) + 2) >= vetor.length) {
            aux[0] = vetor[(2 * idx) + 1];
            aux[1] = null;
        } else {
            aux[0] = vetor[(2 * idx) + 1];
            aux[1] = vetor[(2 * idx) + 2];
        }

        // Devolve um vetor com os filhos do elemento
        return aux;
    }

    /**
     * Calcula e retorna o nível do elemento na árvore
     * @param element elemento a ter o nível calculado
     * @return nível do elemento
     */
    public int height(int element) {
        // Procura pelo elemento no vetor
        int idx = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (Objects.equals(element, vetor[i])){
                idx = i;
                break;
            }
        }

        return (int)((Math.log(idx + 1) / Math.log(2)) + 1);
    }

    /**
     * Retorna o comprimento do vetor que está sendo usado no Heap.
     * @return tamanho do vetor.
     */
    public int length() {
        return this.vetor.length;
    }

    /**
     * Calcula e retorna o tamanho total da árvore.
     * @return tamanho total da árvore.
     */
    public int totalHeight() {
        int totalHeight;
        if ((Math.log(this.vetor.length) / Math.log(2)) % 2 == 0) {
            totalHeight = (int)(Math.log(this.vetor.length) / Math.log(2)) + 1;
        } else {
            totalHeight = (int)Math.ceil(Math.log(this.vetor.length) / Math.log(2));
        }

        return totalHeight;
    }
}
