public class Empacotamento extends UnidadeDeProcessamento {
    /**
     * Modifica o atributo tempoParaProcessar do objeto para:
     *      1 instante p/ pizza.
     *      1 instante p/ pastel.
     */
    public void setTempoNecessario(Integer pasteis, Integer pizzas) {
        pedido.setTempoParaProcessar((pizzas * 3)  + pasteis);
    }
    public int getTempoNecessario() { return pedido.getTempoParaProcessar(); }
    @Override
    public void colocaNaFila(Pedido pedido) {
        fila.inserir(pedido);
        this.pedido = pedido;
        System.out.println("\n#" + pedido.getNumero() + " entrou no EMPACOTAMENTO.\n");
    }
}
