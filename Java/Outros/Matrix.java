package testes;
import java.util.Random;

public class Matrix {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        String letras = "abcdefghijklmnopqrstuvxzwy";

        // Cursor invisivel
        System.out.print("\u001b[?25l");
        System.out.print("\u001b[2J");
        System.out.print("\u001b[8m");

        while (true) {
            System.out.print("\u001b[8m");

            // Gera numeros aleatórios em toda matriz do terminal por iteração
            for  (int i = 1; i < 45; i++) {
                for (int j = 1; j < 200; j++) {
                    String letra = Character.toString(letras.charAt(random.nextInt(letras.length())));
                    System.out.printf("\u001b[%d;%dH%s", i, j, letra);
                }
            }

            int coluna = random.nextInt(200);

            for (int i = 0; i < 45; i++) {
                System.out.printf("\u001b[28m\u001b[%d;%dH", i, coluna);
            }


            Thread.sleep(1000);






        }
    }
}
