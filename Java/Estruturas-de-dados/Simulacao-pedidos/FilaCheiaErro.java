/**
 * Classe criada para sinalizar um erro quando a fila estiver cheia.
 * @author matheus
 * @version 04/09/2022
 */

public class FilaCheiaErro extends RuntimeException {
    public FilaCheiaErro(String mensagem) {
        super(mensagem);
    }
}
