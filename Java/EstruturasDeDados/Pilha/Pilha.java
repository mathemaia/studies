/**
 * Classe da estrutura de dados pilha com todos os seus métodos.
 * @author matheus maia
 * @version 28/08/2022
 */

public class Pilha {
    private Integer[] pilha;
    private int count;

    /**
     * Construtor que inicia a pilha com 10 posições por padrão.
     */
    public Pilha() {
        pilha = new Integer[10];
        count = 0;
    }
    /**
     * Construtor que inicializa a pilha com o tamanho escolhido.
     * @param tamanho define o tamanho da pilha
     */
    public Pilha(int tamanho) {
        pilha = new Integer[tamanho];
        count = 0;
    }

    /**
     * Insere um elemento no topo da pilha.
     * @param elemento elemento a ser inserido
     */
    public void inserir(Integer elemento) {
        if (count == pilha.length)
            throw new PilhaCheiaErro("Pilha cheia.");
        this.pilha[count] = elemento;
        count++;
    }

    /**
     * Remove e retorna o elemento do topo da pilha (com erro se estiver vazia)
     * @return num
     */
    public Integer retirar() {
        if (count == 0)
            throw new PilhaVaziaErro("Pilha vazia.");
        Integer num = pilha[count - 1];
        pilha[count - 1] = null;
        count--;
        return num;
    }

    /**
     * Retorna o elemento do topo da pilha sem removê-lo.
     * @return pilha[count - 1]
     */
    public Integer topo() {
        if (count == 0)
            throw new PilhaVaziaErro("Pilha Vazia.");
        return pilha[count - 1];
    }

    /**
     * Retorna o tamanho atual da pilha.
     * @return count
     */
    public int tamanho() {
        return count;
    }

    /**
     * Método que retorna se a pilha está ou não vazia com um valor booleano.
     * @return true ou false
     */
    public boolean estaVazia() {
        return count == 0;
    }

    /**
     * Esvazia a pilha.
     */
    public void esvaziar() {
        pilha = new Integer[10];
        count = 0;
    }
}
