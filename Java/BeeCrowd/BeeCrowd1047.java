import java.util.Scanner;

/**
 * Leia a hora inicial, minuto inicial, hora final e minuto final de um jogo. A seguir calcule a duração do jogo.
 *      Obs: O jogo tem duração mínima de um (1) minuto e duração máxima de 24 horas.
 * @author Matheus Maia
 * @version 04/07/2022
 */

public class BeeCrowd1047 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        final int HINICIAL = in.nextInt();
        final int MINICIAL = in.nextInt();
        final int HFINAL = in.nextInt();
        final int MFINAL = in.nextInt();
        int qtdHoras;
        int qtdMinutos;
        int calculo ;

        if (HINICIAL >= HFINAL) {
            calculo = ((1440 - ((60 * HINICIAL) + MINICIAL)) + ((HFINAL * 60) + MFINAL));
            qtdHoras = calculo / 60;
            qtdMinutos = calculo % 60;
            if ((qtdHoras == 24 && qtdMinutos > 0) || (qtdHoras > 24)) {
                qtdHoras = 0;
                System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", qtdHoras, qtdMinutos);
            } else {
                System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", qtdHoras, qtdMinutos);
            }
        } else {
            calculo = (((HFINAL * 60) + MFINAL) - ((HINICIAL * 60) + MINICIAL));
            qtdHoras = calculo / 60;
            qtdMinutos = calculo % 60;
            if ((qtdHoras == 24 && qtdMinutos > 0) || (qtdHoras > 24)) {
                qtdHoras = 0;
                System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", qtdHoras, qtdMinutos);
            } else {
                System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", qtdHoras, qtdMinutos);
            }
        }
    }
}