import java.util.Arrays;
import java.util.Random;

/**
 * Programa que sorteia numeros de 1-75 de forma aleatória e sem repetir números que já foram sorteados
 */

public class Bingo {
    public static void main(String[] args) {
        Random random = new Random();

        // Array de números sorteados
        int[] numeros = new int[74];

        // Variável que guarda o índice do lugar onde será inserido o número sorteado, caso ele não exista
        int indice = 0;

        // Loop que vai rodar até sortear todos os números
        while (indice < 74) {
            // Sorteia um número de 0-75 de forma aleatória
            int numeroSorteado = random.nextInt(75) + 1;

            // Variável booleana que controla o loop for abaixo
            boolean existe = false;

            // Loop que percorre o array de números já sorteado
            for (int j = 0; j < indice; j++) {
                // Se o número sorteado for igual a qualquer número do array, é porque já foi sorteado, então sai
                if (numeroSorteado == numeros[j]) {
                    existe = true;
                    break;
                }
            }

            // Se após sair do loop acima e a variavel 'existe' continuar false, é porque o número não existe no array e
            // por isso será inserido na posição 'indice'
            if (existe == false) {
                numeros[indice] = numeroSorteado;

                // Incrementa para apontar sempre para a pŕoxima posição do array de números
                indice++;
            }
        }

        // Imprime o array dos números sorteados
        System.out.println(Arrays.toString(numeros));

    }
}
