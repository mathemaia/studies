/**
 * Classe dedicada a manipular os elementos da fila e realizar suas operações.
 * @author matheus
 * @version 04/09/2022
 */

public class Fila {
    private Pedido[] vetorPedidos;
    private int inicio;
    private int fim;
    private int quantidade;

    // Contrutores.
    public Fila() {
        this.vetorPedidos = new Pedido[1000];
        this.quantidade = 0;
        this.inicio = 0;
        this.fim = 0;
    }
    public Fila(int tamanho) {
        this.quantidade = 0;
        this.inicio = 0;
        this.fim = 0;
    }

    /**
     * Retorna o tamanho da fila;
     * @return quantidade
     */
    public int tamanho() {
        return quantidade;
    }

    /**
     * Método para inserir novos elementos no fim da fila.
     * @param elemento elemento a ser inserido
     */
    public void inserir(Pedido elemento) {
        if (quantidade == vetorPedidos.length)
            throw new FilaCheiaErro("Fila cheia!");
        this.vetorPedidos[fim] = elemento;
        this.quantidade++;
        fim = (fim + 1) % vetorPedidos.length;
    }

    /**
     * Método que retira o primeiro elemento que foi inserido na fila.
     * @return primeiro elemento
     */
    public Pedido retirar() {
        if (quantidade == 0)
            throw new FilaVaziaErro("Fila Vazia!");
        Pedido aux = vetorPedidos[inicio];
        this.quantidade--;
        this.inicio = (inicio + 1) % vetorPedidos.length;
        this.vetorPedidos[inicio] = null;
        return aux;
    }

    /**
     * Retorna primeiro elemento da fila sem retirá-lo.
     * @return primeiro elemento
     */
    public Pedido inicio() {
        return vetorPedidos[inicio];
    }

    /**
     * Método que esvazia a fila reiniciando-a.
     */
    public void esvaziar() {
        this.vetorPedidos = new Pedido[1000];
        this.quantidade = 0;
        this.inicio = 0;
        this.fim = 0;
    }
}

