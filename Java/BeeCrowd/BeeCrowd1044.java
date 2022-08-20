import java.util.Scanner;

/**
 * Leia 2 valores inteiros (A e B). Após, o programa deve mostrar uma mensagem "Sao Multiplos" ou "Nao sao Multiplos",
 * indicando se os valores lidos são múltiplos entre si.
 *
 * @author Matheus Maia
 * @version 25/06/2022
 */

public class BeeCrowd1044 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Entrada
        int a = in.nextInt();
        int b = in.nextInt();
        in.close();

        // Saída
        if (b > a) {
            if (b % a == 0) {
                System.out.println("Sao Multiplos");
            } else {
                System.out.println("Nao sao Multiplos");
            }
        } else {
            if (a % b == 0) {
                System.out.println("Sao Multiplos");
            } else {
                System.out.println("Nao sao Multiplos");
            }
        }
    }
}
