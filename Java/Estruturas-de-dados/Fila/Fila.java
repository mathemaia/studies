package fila;

/**
 * Classe da fila em sí, contendo seus métodos de inserção, remoção, etc.
 * @author matheus
 */

public class Fila {
    private Integer[] fila;
    private int count;
    private int primeiro;
    private int ultimo;

    public Fila() {
        fila = new Integer[5];
        count = 0;
    }

    /**
     * Insere o elemento no fim da fila.
     * @param elemento elemento a ser inserido
     */
    public void enqueue(Integer elemento) {
        if (count == fila.length)
            throw new FilaCheiaErro("Fila cheia!");

        fila[ultimo] = elemento;
        count++;
        ultimo = (ultimo + 1) % fila.length;
        System.out.println("Ultimo: " + ultimo);
    }


}
