import java.util.Scanner;

/**
 * Neste problema, você deverá ler 3 palavras que definem o tipo de animal possível segundo o esquema abaixo, da esquerda
 * para a direita.  Em seguida conclua qual dos animais seguintes foi escolhido, através das três palavras fornecidas.
 *      1. vertebrado:
 *          2. ave:
 *              3. carnivoro:
 *                  - aguia
 *              3. onivoro:
 *                  - pomba
 *          2. mamifero:
 *              3. onivoro:
 *                  - homem
*               3. herbivoro:
 *                  - vaca
 *      1. invertebrado:
 *          2. inseto:
 *              3. hematofago:
 *                  - pulga
 *              3. herbivoro:
 *                  - lagarta
 *          2. anelideo:
 *              3. hematofago:
 *                  - sanguessuga
 *              3. onivoro:
 *                  - minhoca
 * @author Matheus Maia
 * @version 05/07/2022
 */

public class BeeCrowd1049 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Entradas:
        String nivel1 = in.next();
        String nivel2 = in.next();
        String nivel3 = in.next();
        String resultado;

        // Árvore de decisão com níveis de profundidade:
        switch (nivel1) {
            case "vertebrado":
                switch (nivel2) {
                    case "ave":
                        switch (nivel3) {
                            case "carnivoro":
                                resultado = "aguia";
                                System.out.println(resultado);
                                break;
                            case "onivoro":
                                resultado = "pomba";
                                System.out.println(resultado);
                                break;
                        }
                        break;
                    case "mamifero":
                        switch (nivel3) {
                            case "onivoro":
                                resultado = "homem";
                                System.out.println(resultado);
                                break;
                            case "herbivoro":
                                resultado = "vaca";
                                System.out.println(resultado);
                                break;
                        }
                        break;
                }
                break;
            case "invertebrado":
                switch (nivel2) {
                    case "inseto":
                        switch (nivel3) {
                            case "hematofago":
                                resultado = "pulga";
                                System.out.println(resultado);
                                break;
                            case "herbivoro":
                                resultado = "lagarta";
                                System.out.println(resultado);
                                break;
                        }
                        break;
                    case "anelideo":
                        switch (nivel3) {
                            case "hematofago":
                                resultado = "sanguessuga";
                                System.out.println(resultado);
                                break;
                            case "onivoro":
                                resultado = "minhoca";
                                System.out.println(resultado);
                                break;
                        }
                        break;
                }
                break;
        }
    }
}
