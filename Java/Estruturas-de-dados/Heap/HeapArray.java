package Alest2.Heap;

import java.util.Objects;

public class HeapArray {
    Integer[] array;

    public HeapArray(Integer[] array) {
        this.array = array;
    }

    public Integer[] childs(Integer element) {
        // Procura pelo elemento no vetor
        int idx = -1;
        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(element, array[i])){
                idx = i;
                break;
            }
        }

        Integer[] aux = new Integer[2];
        // Se o elemento tiver apenas o filho da esquerda
        if (idx >= 0 && ((2 * idx) + 1) > array.length) {
            aux[0] = null;
            aux[1] = null;
        // Se o elemento não tiver filhos
        } else if (idx >= 0 && ((2 * idx) + 2) >= array.length) {
            aux[0] = array[(2 * idx) + 1];
            aux[1] = null;
        }

        // Devolve um vetor com os filhos do elemento
        return aux;
    }
}
