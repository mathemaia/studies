public class Cozimento extends UnidadeDeProcessamento {
    /**
     * Modifica o atributo tempoParaProcessar do objeto para:
     *      4 instantes p/ pizza.
     *      2 instantes p/ pastel.
     */
    public void setTempoNecessario(Integer pasteis, Integer pizzas) {
        pedido.setTempoParaProcessar((pizzas * 3)  + pasteis);
    }
    public int getTempoNecessario() {
        return pedido.getTempoParaProcessar();
    }
}
