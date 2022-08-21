import java.util.Scanner;

/**
 * Leia um valor inteiro entre 1 e 12, inclusive. Correspondente a este valor, deve ser apresentado como resposta o mês do ano por extenso, 
 * em inglês, com a primeira letra maiúscula.
 *      e.x: 4 -> April
 *
 * @author Matheus Maia
 * @version 20/08/2022
 */

class BeeCrowd1052 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] meses = {"January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"};

        int entrada = in.nextInt();
        in.close();

        System.out.println(meses[entrada - 1]);
    }
}
