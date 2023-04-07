package Trabalho;

import java.util.Arrays;

public class Testes {
    public static void main(String[] args) {

        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] pares = Arrays.stream(numeros).filter(n -> n % 2 == 0).toArray();

        System.out.println(Arrays.toString(pares));



    }
}
