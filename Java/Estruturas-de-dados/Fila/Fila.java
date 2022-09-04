/**
 * Classe dedicada a manipular os elementos da fila e realizar suas operações.
 * @author matheus
 * @version 04/09/2022
 */

public class Fila {
    private Integer[] fila;
    private int inicio;
    private int fim;
    private int quantidade;

    // Contrutores.
    public Fila() {
        this.fila = new Integer[5];
        this.inicio = 0;
        this.fim = -1;
        this.quantidade = 0;
    }
    public Fila(int tamanho) {
        this.fila = new Integer[tamanho];
        this.inicio = 0;
        this.fim = -1;
        this.quantidade = 0;
    }

    /**
     * Retorna o tamanho da fila;
     * @return quantidade
     */
    public int tamanho() {
        return quantidade;
    }

    /**
     * Retorna true se for possível inserir um novo elemento e false caso contrário.
     * @return true ou false
     */
    public boolean temLugar() {
        return quantidade < fila.length;
    }

    /**
     * Método para inserir novos elementos no fim da fila.
     * @param elemento elemento a ser inserido
     */
    public void inserir(Integer elemento) {
        if (!temLugar())
            throw new FilaCheiaErro("Fila cheia!");
        this.fim++;
        this.fila[fim] = elemento;
        this.quantidade++;
    }

    /**
     * Método que retira o primeiro elemento que foi inserido na fila.
     * @return primeiro elemento
     */
    public Integer retirar() {
        if (quantidade == 0)
            throw new FilaVaziaErro("Fila Vazia!");
        Integer aux = fila[inicio];
        this.fila[inicio] = null;
        this.inicio++;
        this.quantidade--;
        return aux;
    }

    /**
     * Retorna primeiro elemento da fila sem retirá-lo.
     * @return primeiro elemento
     */
    public Integer inicio() {
        return fila[inicio];
    }

    /**
     * Método que esvazia a fila reiniciando-a.
     */
    public void esvaziar() {
        this.fila = new Integer[5];
        this.inicio = 0;
        this.fim = -1;
        this.quantidade = 0;
    }
}
