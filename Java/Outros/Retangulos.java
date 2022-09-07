import java.util.Random;

/**
 * Estudo de manipulação de saída no terminal
 * @author matheus
 * @version 06/09/2022
 */

public class Retangulos {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int[][] vetor = new int[30][30];
        int contador = 0;

        while (true) {
            int color = random.nextInt(255);
            int posicaoX = random.nextInt(150);
            int posicaoY = random.nextInt(150);

            // Apaga o cursor
            System.out.print("\u001b[?25l");

            // RETÂNGULOS
            for (int k = 0; k < 30; k++) {
                if (contador < 30) {
                    for (int i = contador; i < 30; i++) {
                        // Deixa em negrito
                        System.out.print("\u001b[1m");
                        // Define a cor
                        System.out.printf("\u001b[38;5;%dm", color);
                        // Posiciona o cursor no eixo x
                        System.out.printf("\u001b[%dC", posicaoX);
                        for (int j = contador; j < 30; j++) {
                            if (((i == contador || i == contador + 1) || (i == vetor.length - 1 || i == vetor.length - 2))
                                    || ((j == contador || j == contador + 1) || (j == vetor.length - 1 || j == vetor.length - 2))) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println();
                    }
                    contador++;
                } else {
                    contador = 0;
                }
                Thread.sleep(25);

                // Apaga o conteúdo da tela
                System.out.print("\u001b[2J");
                // Posiciona no eixo y
                System.out.printf("\u001b[%dA", posicaoY);
            }
        }
    }
}
