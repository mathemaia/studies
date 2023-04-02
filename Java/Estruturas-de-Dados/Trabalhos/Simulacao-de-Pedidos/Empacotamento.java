/**
 * Classe que recebe herança da classe mãe UnidadeDeProcessamento.
 * @author matheus maia
 * @version 12-09-2022
 */

public class Empacotamento extends UnidadeDeProcessamento {
    /**
     * Modifica o atributo tempoParaProcessar do objeto para:
     *      1 instante p/ pizza.
     *      1 instante p/ pastel.
     */
    public void setTNecessario(Integer pasteis, Integer pizzas) {
        pedido.setTempoParaProcessar((pizzas * 3)  + pasteis);
    }

    /**
     * Retorna o tempo necesário para o pedido ser processado.
     * @return tempo necessário
     */
    public int getTempoNecessario() { return pedido.getTempoParaProcessar(); }

    /**
     * Método sobreescrito apena para trocar o nome do processador na impressão.
     * @param pedido objeto a ser inserido.
     */
    @Override
    public void colocaNaFila(Pedido pedido) {
        fila.inserir(pedido);
        this.pedido = pedido;
        System.out.println("\n#" + pedido.getNumero() + " -> EMPACOTAMENTO.\n");
    }
}
