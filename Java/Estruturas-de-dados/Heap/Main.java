package Alest2.Heap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HeapArray heap = new HeapArray(new Integer[]{48, 30, 31, 53, 36, 83, 31, 2, 21, 74});

        System.out.println(Arrays.toString(heap.childs(83)));

    }
}
