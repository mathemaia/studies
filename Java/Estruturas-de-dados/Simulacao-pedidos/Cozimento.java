/**
 * Classe que recebe herança da classe mãe UnidadeDeProcessamento.
 * @author matheus maia
 * @version 12-09-2022
 */

public class Cozimento extends UnidadeDeProcessamento {
    /**
     * Modifica o atributo tempoParaProcessar do objeto para:
     *      4 instantes p/ pizza.
     *      2 instantes p/ pastel.
     */
    public void setTempoNecessario(Integer pasteis, Integer pizzas) {
        pedido.setTempoParaProcessar((pizzas * 4)  + (pasteis * 2));
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
        System.out.println("\n#" + pedido.getNumero() + " -> COZIMENTO.\n");
    }
}
