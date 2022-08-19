import java.util.Scanner;
import java.util.Locale;

/**
 * A empresa ABC resolveu conceder um aumento de salários a seus funcionários de acordo com a tabela abaixo:
 *      0 - 400.00: 15% de reajuste
 *      400.01 - 800.00: 12% de reajuste
 *      800.01 - 1200.00: 10% de reajuste
 *      1200.01 - 2000.00: 7% de reajuste
 *      Acima de 2000.00: 4% de reajuste
 *Leia o salário do funcionário e calcule e mostre o novo salário, bem como o valor de reajuste ganho e o índice reajustado,
 * em percentual.
 * @author Matheus Maia
 * @version 05/07/2022
 */

public class BeeCrowd1048 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Scanner in = new Scanner(System.in);

        double reajuste;
        double novoSalario;
        int percentual;

        // Entrada.
        double salarioInicial = in.nextDouble();

        // Árvore de decisão e saídas.
        if (salarioInicial <= 400.00) {
            percentual = 15;
            reajuste = Math.round(salarioInicial * (percentual / 100.00));
            novoSalario = salarioInicial + reajuste;
            System.out.printf("Novo salario: %.2f\nReajuste ganho: %.2f\nEm percentual: %d %%\n", novoSalario, reajuste, percentual);
        } else if (salarioInicial > 400.00 && salarioInicial <= 800.00) {
            percentual = 12;
            reajuste = Math.round(salarioInicial * (percentual / 100.00));
            novoSalario = salarioInicial + reajuste;
            System.out.printf("Novo salario: %.2f\nReajuste ganho: %.2f\nEm percentual: %d %%\n", novoSalario, reajuste, percentual);
        } else if (salarioInicial > 800.00 && salarioInicial <= 1200.00) {
            percentual = 10;
            reajuste = Math.round(salarioInicial * (percentual / 100.00));
            novoSalario = salarioInicial + reajuste;
            System.out.printf("Novo salario: %.2f\nReajuste ganho: %.2f\nEm percentual: %d %%\n", novoSalario, reajuste, percentual);
        } else if (salarioInicial > 1200.00 && salarioInicial <= 2000.00) {
            percentual = 7;
            reajuste = Math.round(salarioInicial * (percentual / 100.00));
            novoSalario = salarioInicial + reajuste;
            System.out.printf("Novo salario: %.2f\nReajuste ganho: %.2f\nEm percentual: %d %%\n", novoSalario, reajuste, percentual);
        } else if (salarioInicial > 2000.00) {
            percentual = 4;
            reajuste = Math.round(salarioInicial * (percentual / 100.00));
            novoSalario = salarioInicial + reajuste;
            System.out.printf("Novo salario: %.2f\nReajuste ganho: %.2f\nEm percentual: %d %%\n", novoSalario, reajuste, percentual);
        }
    }
}
