import java.util.Locale;
import java.util.Scanner;

/**
 * Leia 3 valores reais (A, B e C) e verifique se eles formam ou não um triângulo. Em caso positivo, calcule o perímetro
 * do triângulo e apresente a mensagem:
 *  	Perímetro = XX.X
 * Em caso negativo, calcule a área do trapézio que tem A e B como base e C como altura, mostrando a mensagem
 *  	Area = XX.X
 *
 * @author Matheus Maia
 * @version 25/06/2022
 */

public class BeeCrowd1043 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner in = new Scanner(System.in);

        // Entrada
        double a = in.nextDouble(), b = in.nextDouble(), c = in.nextDouble();

        // Cálculos e saída
        if ((a < b + c) && (b < a + c) && (c < a + b)) {
            double perimetro = a + b + c;
            System.out.printf("Perimetro: %.1f\n", perimetro);
        } else {
            double area = ((a + b) * c) / 2;
            System.out.printf("Area = %.1f\n", area);
        }
    }
}
