public class Montagem extends UnidadeDeProcessamento {
    private int qtdPasteis;
    private int qtdPizzas;
    /**
     * Modifica o atributo tempoParaProcessar do objeto para:
     *      3 instantes p/ pizza.
     *      1 instante p/ pastel.
     */
    public void setTempoNecessario() {
        this.pedido.setTempoParaProcessar(pedido.getQtdPizzas() + pedido.getQtdPasteis());
    }
}
