/**
 * Classe Pedido com seus atributos e métodos.
 * @author matheus maia
 * @version 12-09-2022
 */

public class Pedido {
    private Integer numero;
    private Integer qtdPizzas;
    private Integer qtdPasteis;
    private Integer instante;
    private Integer tempoParaProcessar;

    // Construtores.
    public Pedido() {
        this.qtdPizzas = null;
        this.qtdPasteis = null;
        this.instante = 1;
        this.numero = null;
        this.tempoParaProcessar = null;
    }
    public Pedido(Integer qtdPizzas, Integer qtdPasteis, Integer instante, int numero) {
        this.qtdPizzas = qtdPizzas;
        this.qtdPasteis = qtdPasteis;
        this.numero  = numero;
        this.instante = instante;
        this.tempoParaProcessar = 0;
    }

    // Setters.
    public void setNumero(Integer numero) { this.numero = numero; }
    public void setQtdPizzas(Integer qtdPizzas) { this.qtdPizzas = qtdPizzas; }
    public void setQtdPasteis(Integer qtdPasteis) { this.qtdPasteis = qtdPasteis; }
    public void setInstante(Integer instante) { this.instante = instante; }
    public void setTempoParaProcessar(Integer tempoParaProcessar) { this.tempoParaProcessar = tempoParaProcessar; }
    public void decrementarTempo() { this.tempoParaProcessar--; }

    // Getters.
    public Integer getNumero() { return numero; }
    public Integer getQtdPizzas() { return qtdPizzas; }
    public Integer getQtdPasteis() { return qtdPasteis; }
    public Integer getInstante() { return instante; }
    public Integer getTempoParaProcessar() { return tempoParaProcessar; }

    // Outros métodos.
    public void imprime(int tempoFinal) {
        System.out.println("\n****************************");
        System.out.println("#" + getNumero());
        System.out.println("entrou no tempo " + instante + ".");
        System.out.println("tempo total: " + (tempoFinal - instante));
        System.out.println("qtdPasteis: " + getQtdPasteis());
        System.out.println("qtdPizzas: " + getQtdPizzas());
        System.out.println("****************************");
    }
}
