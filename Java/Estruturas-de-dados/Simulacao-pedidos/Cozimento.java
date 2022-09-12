public class Cozimento extends UnidadeDeProcessamento {

    /**
     * Modifica o atributo tempoParaProcessar do objeto para:
     *      4 instantes p/ pizza.
     *      2 instantes p/ pastel.
     */

    public int getTempoNecessario() {
        return this.pedido.getTempoParaProcessar();
    }
}
