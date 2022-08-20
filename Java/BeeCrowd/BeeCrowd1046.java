import java.util.Scanner;

/**
 * Leia a hora inicial e a hora final de um jogo. A seguir calcule a duração do jogo, sabendo que o mesmo pode começar
 * em um dia e terminar em outro, tendo uma duração mínima de 1 hora e máxima de 24 horas.
 *
 * @author Matheus Maia
 * @version 29/06/2022
 */

public class BeeCrowd1046 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Entradas.
        int hInicial = in.nextInt();
        int hFinal = in.nextInt();

        // Cálculos e saídas.
        if (hFinal > hInicial) {
            System.out.printf("O JOGO DUROU %d HORA(S)\n", hFinal - hInicial);
        } else {
            System.out.printf("O JOGO DUROU %d HORA(S)\n", (24 - hInicial) + hFinal);
        }
    }
}
