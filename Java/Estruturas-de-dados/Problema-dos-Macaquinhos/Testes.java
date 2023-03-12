package Alest2;

import java.util.Arrays;

public class Testes {
    public static void main(String[] args) {

        String[] strings = {"1", "2", "3"};
        int[] inteiros = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();



    }
}
