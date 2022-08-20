import java.util.Scanner;
import java.util.Locale;

/**
 * Em um país imaginário denominado Lisarb, todos os habitantes ficam felizes em pagar seus impostos, pois sabem que nele
 * não existem políticos corruptos e os recursos arrecadados são utilizados em benefício da população, sem qualquer desvio.
 * A moeda deste país é o Rombus, cujo símbolo é o R$.
 *      de 0.00 a R$ 2000.00: Isento
 *      de R$ 2000.01 até R$ 3000.00: 8%
 *      de R$ 3000.01 até R$ 4500.00: 18%
 *      acima de R$ 4500.00: 28%
 * Leia um valor com duas casas decimais, equivalente ao salário de uma pessoa de Lisarb. Em seguida, calcule e mostre o
 * valor que esta pessoa deve pagar de Imposto de Renda, segundo a tabela abaixo.
 * Lembre que, se o salário for R$ 3002.00, a taxa que incide é de 8% apenas sobre R$ 1000.00, pois a faixa de salário
 * que fica de R$ 0.00 até R$ 2000.00 é isenta de Imposto de Renda. No exemplo fornecido (abaixo), a taxa é de 8% sobre
 * R$ 1000.00 + 18% sobre R$ 2.00, o que resulta em R$ 80.36 no total. O valor deve ser impresso com duas casas decimais.
 
 * @author Matheus Maia
 * @version 07/07/2022
 */

public class BeeCrowd1051 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner in = new Scanner(System.in);

        double taxa;

        // Entrada.
        double renda = in.nextDouble();

        // Cálculos e saída.
        if (renda > 2000.00) {
            if (renda < 3000.00) {
                taxa = (renda - 2000.00) * (8 / 100.0);
                System.out.printf("R$ %.2f\n", taxa);
            } else if (renda <= 4500) {
                taxa = (((renda - 2000.00) - (renda - 3000)) * (8 / 100.0)) + ((renda - 3000) * (18 / 100.0));
                System.out.printf("R$ %.2f\n", taxa);
            } else {
                taxa = ((((renda - 2000.00) - (renda - 3000)) * (8 / 100.0)) + ((renda - 3000) - (renda - 4500)) * (18 / 100.0)) + ((renda - 4500) * (28 / 100.0));
                System.out.printf("R$ %.2f\n", taxa);
            }
        } else if (renda <= 2000.00 && renda > 0){
            System.out.println("Isento");
        }
    }
}
