/**
 * Classe dedicada a manipular os elementos da fila e realizar suas operações.
 * @author matheus
 * @version 04/09/2022
 */

public class Fila {
    private Pedido[] fila;
    private int quantidade;
    private int inicio;
    private int fim;

    // Contrutores.
    public Fila() {
        this.fila = new Pedido[100];
        this.quantidade = 0;
    }

    /**
     * Método para inserir novos elementos no fim da fila.
     * @param elemento elemento a ser inserido
     */
    public void inserir(Pedido elemento) {
        if (quantidade == fila.length)
            throw new FilaCheiaErro("Fila cheia!");
        this.fila[fim] = elemento;
        this.quantidade++;
        fim = (fim + 1) % fila.length;
    }

    /**
     * Método que retira o primeiro elemento que foi inserido na fila.
     * @return primeiro elemento
     */
    public Pedido retirar() {
        if (quantidade == 0)
            throw new FilaVaziaErro("Fila Vazia!");
        Pedido aux = fila[inicio];
        this.quantidade--;
        this.inicio = (inicio + 1) % fila.length;
        return aux;
    }

    /**
     * Retorna primeiro elemento da fila sem retirá-lo.
     * @return primeiro elemento
     */
    public Pedido inicio() {
        if (quantidade == 0)
            throw  new FilaVaziaErro("Fila vazia!");
        return fila[inicio];
    }

    /**
     * Retorna o tamanho da fila;
     * @return quantidade
     */
    public int tamanho() { return this.quantidade; }

    /**
     * Retorna true se a fila estiver vazia e false caso o contrário.
     * @return true ou false.
     */
    public boolean estaVazia() { return (quantidade == 0); }

    /**
     * Método que esvazia a fila reiniciando-a.
     */
    public void esvaziar() {
        this.fila = new Pedido[1000];
        this.quantidade = 0;
        this.inicio = 0;
        this.fim = 0;
    }
}

