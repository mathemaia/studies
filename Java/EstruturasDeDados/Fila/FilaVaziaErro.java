/**
 * Classe criada para sinalizar um erro quando a fila estiver fazia.
 * @author matheus
 * @version 04/09/2022
 */

public class FilaVaziaErro extends RuntimeException {
    public FilaVaziaErro(String mensagem) {
        super(mensagem);
    }
}
