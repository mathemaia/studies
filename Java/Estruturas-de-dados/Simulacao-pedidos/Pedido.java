public class Pedido {
    private Integer numero;
    private Integer qtdPizzas;
    private Integer qtdPasteis;
    private Integer instante;
    private int tempoParaProcessar;
    private int tempoGasto;

    // Construtores.
    public Pedido() {
        this.qtdPizzas = null;
        this.qtdPasteis = null;
        this.instante = null;
        this.numero = null;
        this.tempoParaProcessar = 0;
        this.tempoGasto = 0;
    }
    public Pedido(Integer qtdPizzas, Integer qtdPasteis,
                  Integer instante, int numero) {
        this.qtdPizzas = qtdPizzas;
        this.qtdPasteis = qtdPasteis;
        this.instante = instante;
        this.numero  = numero;
        this.tempoParaProcessar = 0;
        this.tempoGasto = 0;
    }

    // Setters.
    public void setNumero(Integer numero) { this.numero = numero; }
    public void setQtdPizzas(Integer qtdPizzas) { this.qtdPizzas = qtdPizzas; }
    public void setQtdPasteis(Integer qtdPasteis) { this.qtdPasteis = qtdPasteis; }
    public void setInstante(Integer instante) { this.instante = instante; }
    public void setTempoParaProcessar(int tempoParaProcessar) { this.tempoParaProcessar = tempoParaProcessar; }
    public void setTempoGasto(int tempoGasto) { this.tempoGasto = tempoGasto; }

    // Getters.
    public Integer getNumero() { return numero; }
    public Integer getQtdPizzas() { return qtdPizzas; }
    public Integer getQtdPasteis() { return qtdPasteis; }
    public Integer getInstante() { return instante; }
    public int getTempoParaProcessar() { return tempoParaProcessar; }
    public int getTempoGasto() { return tempoGasto; }

    // Outros métodos.
    public void imprime() {

    }
}
