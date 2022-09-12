public class Empacotamento extends UnidadeDeProcessamento {
    /**
     * Modifica o atributo tempoParaProcessar do objeto para:
     *      1 instante p/ pizza.
     *      1 instante p/ pastel.
     */
    public void setTempoNecessario() {
        int qtdPasteis = this.pedido.getQtdPasteis();
        int qtdPizzas = this.pedido.getQtdPizzas();
        int tempo = qtdPizzas  + qtdPasteis;
        this.pedido.setTempoParaProcessar(tempo);
    }
    public int getTempoNecessario() {
        return pedido.getTempoParaProcessar();
    }
}
