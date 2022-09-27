package Listas;

/**
 * Classe que implementa uma lista encadeada (alocação dinâmica).
 */

public class ListaEncadeada {
    // Classe interna Nodo.
    private class Nodo {
        public Integer elemento;
        public Nodo proximo;

        // Construtores.
        public Nodo(Integer elemento, Nodo proximo) {
            this.elemento = elemento;
            this.proximo = proximo;
        }
        public Nodo(Integer elemento) {
            this.elemento = elemento;
            this.proximo = null;
        }
    }

    
}
