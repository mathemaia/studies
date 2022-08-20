import java.util.Scanner;

/**
 * Leia um número inteiro que representa um código de DDD para discagem interurbana. Em seguida, informe à qual cidade o
 * DDD pertence, considerando a tabela abaixo:
 * 	61 - Brasilia
 * 	71 - Salvador
 * 	11 - Sao Paulo
 * 	21 - Rio de Janeiro
 * 	32 - Juiz de Fora
 * 	19 - Campinas
 * 	27 - Vitoria
 * 	31 - Belo Horizonte
 *
 * @author Matheus Maia
 * @version 05/07/2022
 */

public class BeeCrowd1050 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Entrada.
        int ddd = in.nextInt();

        // Saídas.
        switch (ddd) {
            case 61: System.out.print("Brasilia\n"); break;
            case 71: System.out.print("Salvador\n"); break;
            case 11: System.out.print("Sao Paulo\n"); break;
            case 21: System.out.print("Rio de Janeiro\n"); break;
            case 32: System.out.print("Juiz de Fora\n"); break;
            case 19: System.out.print("Campinas\n"); break;
            case 27: System.out.print("Vitoria\n"); break;
            case 31: System.out.print("Belo Horizonte\n"); break;
            default: System.out.print("DDD nao cadastrado\n"); break;
        }
    }
}
