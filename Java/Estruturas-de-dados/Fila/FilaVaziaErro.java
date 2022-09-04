package fila;

/**
 * Classe criada para sinalizar um erro quando a fila estiver fazia.
 * @author matheus
 */

public class FilaVaziaErro extends  RuntimeException {
    public FilaVaziaErro(String mensagem) {
        super(mensagem);
    }
}
