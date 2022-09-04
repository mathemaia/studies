package fila;

/**
 * Classe criada para sinalizar um erro quando a fila estiver cheia.
 * @author matheus
 */

public class FilaCheiaErro extends RuntimeException {
    public FilaCheiaErro(String mensagem) {
        super(mensagem);
    }
}
