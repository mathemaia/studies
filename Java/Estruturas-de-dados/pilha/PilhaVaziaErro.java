/**
 * Classe que faz o tratamento de erro para pilha vazia.
 * @author matheus maia
 */

public class PilhaVaziaErro extends RuntimeException {
    public PilhaVaziaErro(String mensagem) {
        super(mensagem);
    }
}
