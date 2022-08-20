import java.util.Locale;
import java.util.Scanner;

/**
 * Leia 3 valores de ponto flutuante A, B e C e ordene-os em ordem decrescente, de modo que o lado A representa o maior
 * dos 3 lados. A seguir, determine o tipo de triângulo que estes três lados formam, com base nos seguintes casos, sempre
 * escrevendo uma mensagem adequada:
 *      se A ≥ B+C, apresente a mensagem: NAO FORMA TRIANGULO
 *      se A2 = B2 + C2, apresente a mensagem: TRIANGULO RETANGULO
 *      se A2 > B2 + C2, apresente a mensagem: TRIANGULO OBTUSANGULO
 *      se A2 < B2 + C2, apresente a mensagem: TRIANGULO ACUTANGULO
 *      se os três lados forem iguais, apresente a mensagem: TRIANGULO EQUILATERO
 *      se apenas dois dos lados forem iguais, apresente a mensagem: TRIANGULO ISOSCELES
 *
 * @author Matheus Maia
 * @version 29/06/2022
 */

public class BeeCrowd1045 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner in = new Scanner(System.in);

        double a, b, c;
        double aux;

        // Entradas e armazenamento.
        a = in.nextDouble();
        b = in.nextDouble();
        c = in.nextDouble();
        in.close();
        double[] vetor = {a, b, c};

        // Organização em ordem decrescente.
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor.length; j++) {
                if ((j + 1 < vetor.length) && (vetor[j] < vetor[j + 1])) {
                    aux = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = aux;
                }
            }
        }
        a = vetor[0];
        b = vetor[1];
        c = vetor[2];

        // Cálculos e classificação dos triângulos.
        double somaBC = Math.pow(b, 2) + Math.pow(c, 2);
        boolean retangulo = Math.pow(a, 2) == somaBC;
        boolean obtusangulo = Math.pow(a, 2) > somaBC;
        boolean acutangulo = Math.pow(a, 2) < somaBC;
        boolean equilatero = (a == b) && (b == c);
        boolean isosceles = ((a == c) && (b != a)) || ((c == b) && (a != c)) || ((b == a) && (c != b));
        boolean[] tipos = {retangulo, obtusangulo, acutangulo, equilatero, isosceles};
        if ((a >= b + c) && ((a > 0) && (b > 0) && (c > 0))) {
            System.out.println("NAO FORMA TRIANGULO");
        } else if ((a > 0) && (b > 0) && (c > 0)) {
            for (int i = 0; i < tipos.length; i++) {
                if (tipos[i]) {
                    switch (i) {
                        case 0 : System.out.print("TRIANGULO RETANGULO\n");
                        case 1 : System.out.print("TRIANGULO OBTUSANGULO\n");
                        case 2 : System.out.print("TRIANGULO ACUTANGULO\n");
                        case 3 : System.out.print("TRIANGULO EQUILATERO\n");
                        case 4 : System.out.print("TRIANGULO ISOSCELES\n");
                    }
                }
            }
        }
    }
}
