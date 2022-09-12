public class Montagem extends UnidadeDeProcessamento {
    /**
     * Modifica o atributo tempoParaProcessar do objeto para:
     *      3 instantes p/ pizza.
     *      1 instante p/ pastel.
     */
    public void setTempoNecessario(Integer pasteis, Integer pizzas) {
        pedido.setTempoParaProcessar((pizzas * 3)  + pasteis);
    }
    public int getTempoNecessario() {
        return pedido.getTempoParaProcessar();
    }
}
