public class Cozimento extends UnidadeDeProcessamento {
    /**
     * Modifica o atributo tempoParaProcessar do objeto para:
     *      4 instantes p/ pizza.
     *      2 instantes p/ pastel.
     */
    public void setTempoNecessario(Integer pasteis, Integer pizzas) {
        pedido.setTempoParaProcessar((pizzas * 4)  + (pasteis * 2));
    }
    @Override
    public void colocaNaFila(Pedido pedido) {
        fila.inserir(pedido);
        this.pedido = pedido;
        System.out.println("\n#" + pedido.getNumero() + " entrou na COZIMENTO.\n");
    }
}
