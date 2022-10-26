package Sistema;

/**
 * Classe que implementa a estrutura abstrata de dados lista duplamente encadeada.
 * @author Matheus Maia
 * @version 03-10-2022
 */
 
public class ListaDuplamenteEncadeada {
    // Referência que aponta pra a posição corrente na lista.
    private Nodo current;
    // Contador de elementos.
    private int count;
    // Sentinelas.
    private Nodo header;
    private Nodo trailer;

    /**
     * Classe interna Nodo. Contém um elemento, uma referência para o Nodo anterior outra para o próximo
     */
    private static class Nodo {
        private Integer element;
        private Nodo next;
        private Nodo previous;

        public Nodo(Integer elemento) {
            this.element = elemento;
            this.next = null;
            this.previous = null;
        }
    }

    /**
     * Construtor.
     */
    public ListaDuplamenteEncadeada() {
        this.count = 0;
        this.header = new Nodo(null);
        this.header.next = this.trailer;
        this.trailer = new Nodo(null);
        this.trailer.previous = this.header;
    }

    /**
     * Adiciona um elemento à última posição da lista.
     * @param elemento elemento a ser inserido.
     */
    public void add(Integer elemento) {
        Nodo aux = new Nodo(elemento);

        // Conecta o nodo na última posição da lista.
        aux.next = this.trailer;
        aux.previous = this.trailer.previous;
        this.trailer.previous.next = aux;
        this.trailer.previous = aux;

        this.count++;
    }

    /**
     * Retorna o Nodo do índice passado como parâmetro sem removê-lo.
     * @param indice índice do nodo.
     * @return Nodo.
     */
    public Integer get(int indice) {
        // Lança uma exceção se o índice for inválido.
        if (indice >= this.count || indice < 0)
            throw new IndexOutOfBoundsException("Indice inválido!");

        Nodo aux = getNodeByIndex(indice);
        return aux.element;
    }

    /**
     * Retorna o nodo do índice passado como parâmetro.
     * @param indice indice do elemento a se procurar.
     * @return Nodo.
     */
    private Nodo getNodeByIndex(int indice) {
        // Percorre a lista até o índice passado como parâmentro.
        Nodo aux;
        if (indice <= this.count / 2) {
            aux = this.header.next;
            for (int i = 0; i < indice; i++) {
                aux = aux.next;
            }
        } else {
            aux = this.trailer.previous;
            for (int i = count - 1; i > indice; i++) {
                aux = aux.previous;
            }
        }

        return aux;
    }

    /**
     * Adiciona um elemento por indice.
     * @param elemento elemento a ser inserido na lista.
     * @param indice indice
     */
    public void addByIndex(Integer elemento, int indice) {
        // Lança uma exceção se o indice passado for inválido.
        if (indice > this.count || indice < 0)
            throw new IndexOutOfBoundsException("Indice inválido!");

        // Se o índice for igual ao tamanho atual da lista, adiciona no fim.
        if (this.count == indice) add(elemento);

        // Percorre a lista até o índice passado.
        Nodo aux = new Nodo(elemento);
        Nodo ptr = getNodeByIndex(indice);

        // Linka o novo Nodo como o próximo do Nodo de índice passado.
        aux.previous = ptr.previous;
        aux.next = ptr;
        ptr.next = aux;
        ptr.next.previous = aux;

        this.count++;
    }

    /*
    public Integer getByIndex(int indice) {

    }
     */


    /**
     * Retorna o tamanho atual da lista.
     * @return tamanho atual.
     */
    public int size() {
        return this.count;
    }
}
