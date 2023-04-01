/**
 * Classe que faz o tratamento de erro para pilha cheia
 * @author matheus maia
 */

public class PilhaCheiaErro extends RuntimeException {
    public PilhaCheiaErro(String mensagem) { super(mensagem); }
}
