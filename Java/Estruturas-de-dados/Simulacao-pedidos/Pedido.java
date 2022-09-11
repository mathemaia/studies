import java.util.Random;

public class Pedido {
    Random random = new Random();
    private final int qtdPasteis;
    private final int qtdPizzas;
    private final String id;
    private int tempoEmpacotamento;
    private int tempoCozimento;
    private int tempoMontagem;
    private int tempoTotal;

    // Construtores
    public Pedido(String id) {
        this.qtdPasteis = random.nextInt(6) + 1;
        this.qtdPizzas = random.nextInt(2) + 1;
        this.id = "#" + id + "#";
    }
    public Pedido() {
        this.qtdPasteis = random.nextInt(6) + 1;
        this.qtdPizzas = random.nextInt(2) + 1;
        this.id = null;
    }

    // Setters
    public void setTempoTotal(int t1, int t2, int t3) {
        this.tempoTotal = t1 + t2 + t3;
        this.tempoEmpacotamento = t1;
        this.tempoCozimento = t2;
        this.tempoMontagem = t3;
    }
    public void setNovoInstante(Integer instante) {
        this.tempoTotal = getTempoTotal() - instante;
    }

    // Getters
    /**
     * @return quantidade de pasteis.
     */
    public Integer getQtdPasteis() {
        return this.qtdPasteis;
    }
    /**
     * @return quantidade de pizzas.
     */
    public Integer getQtdPizzas() {
        return this.qtdPizzas;
    }
    /**
     * @return tempo total
     */
    public int getTempoTotal() {
        return this.tempoTotal;
    }
    /**
     * @return id
     */
    public String getId() {
        return this.id;
    }
    /**
     * @return tempo de montagem.
     */
    public int tempoMontagem() { return (getQtdPizzas() * 3) + getQtdPasteis(); }
    /**
     * @return tempo de cozimento.
     */
    public int tempoCozimento() { return (getQtdPizzas() * 4) + ((getQtdPasteis() * 2)); }
    /**
     * @return tempo de empacotamento.
     */
    public int tempoEmpacotamento() { return getQtdPizzas() + getQtdPasteis(); }
}
