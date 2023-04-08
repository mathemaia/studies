package Listas;
import java.util.Objects;

/**
 * Classe que implementa uma lista encadeada (alocação dinâmica).
 * @author Matheus Maia
 * @version 02-10-2022
 */

public class ListaEncadeada {
    /**
     * Classe interna Nodo. Contém um elemento e uma referência para o próximo.
     */
    private static class Nodo {
        private String nome;
        private Integer element;
        private Nodo next;

        /**
         * Construtor.
         * @param element elemento a ser inicializado com o nodo.
         * @param proximo referência ao próximo elemento da cadeia.
         */
        public Nodo(String nome, Integer element, Nodo proximo) {
            this.nome = nome;
            this.element = element;
            this.next = proximo;
        }
        public Nodo(String nome, Integer element) {
            this.nome = nome;
            this.element = element;
            this.next = null;
        }
    }

    // Referência para o primeiro elemento da lista encadeada.
    private Nodo head;
    // Referência para o último elemento da lista encadeada.
    private Nodo tail;
    // Contador de elementos.
    private int count;

    /**
     * Construtor.
     */
    public ListaEncadeada() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    /**
     * Valor booleano para o estado de tamanho atual da lista - se está vazia ou não.
     * @return true ou false
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Informa o tamanho atual da lista.
     * @return tamanho da lista.
     */
    public int size() {
        return this.count;
    }

    /**
     * Esvazia a lista e retorna aos seus valores padrão.
     */
    public void clear() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    /**
     * Adiciona um elemento na posição passada como parâmetro.
     * @param elemento elemento a ser adicionado.
     * @param indice posição que o elemento será inserido.
     * @throws IndexOutOfBoundsException se o índice passado for inválido.
     */
    public void add(int indice, String nome, Integer elemento) {
        Nodo aux = new Nodo(nome, elemento);

        // Lança exceção se o índice for inválido.
        if (indice < 0 || indice > this.count)
            throw new IndexOutOfBoundsException("Indice invalido!");

        // Se o índice for a primeira posição...
        if (indice == 0) {
            // ...e a lista estiver vazia:
            if (this.head == null) {
                this.tail = aux;
            // ...e a lista não estiver vazia:
            } else {
                aux.next = head;
            }
            this.head = aux;
        // Se o índice for a última posição:
        } else if (indice == this.count) {
            this.tail.next = aux;
            this.tail = aux;
        // Se o índice estiver no meio da lista.
        } else {
            Nodo ant = head;
            for (int i = 0; i < indice; i++) {
                ant = ant.next;
            }
            aux.next = ant.next;
            ant.next = aux;
        }

        this.count++;
    }

    /**
     * Adiciona o elemento passado na última posição da lista.
     * @param nome nome do nodo.
     * @param elemento elemento a ser inserido.
     */
    public void add(String nome, Integer elemento) {
        Nodo aux = new Nodo(nome, elemento);
        if (head == null) {
            this.head = aux;
        } else {
            this.tail.next = aux;
        }
        this.tail = aux;
        this.count++;
    }

    /**
     * Retorna o nome da rua.
     * @param indice indice do Nodo.
     * @return elemento a ser retornado.
     */
    public String nome(int indice) {
        // Lança uma exceção se o indice passado for inválido.
        if (indice < 0 || indice >= this.count)
            throw new IndexOutOfBoundsException("Indice invalido!");

        // Retorna o tail se o indice for o deste.
        if (indice == this.count - 1)
            return this.tail.nome;

        // Procura pelo indice passado.
        Nodo aux = this.head;
        for (int i = 0; i < indice; i++) {
            aux = aux.next;
        }

        return aux.nome;
    }

    /**
     * Retorna o elemento Integer do nodo.
     * @param indice indice do Nodo.
     * @return elemento numérico.
     */
    public Integer element(int indice) {
        // Lança uma exceção se o indice passado for inválido.
        if (indice < 0 || indice >= this.count)
            throw new IndexOutOfBoundsException("Indice invalido!");

        // Retorna o tail se o indice for o deste.
        if (indice == this.count - 1)
            return this.tail.element;

        // Procura pelo indice passado.
        Nodo aux = this.head;
        for (int i = 0; i < indice; i++) {
            aux = aux.next;
        }

        return aux.element;
    }

    /**
     * Remove a primeira aparição do elemento na lista.
     * @param elemento elemento a ser removido.
     * @throws ListaVaziaErro se a lista estiver vazia.
     */
    public void remove(Integer elemento) {
        // Se a lista estiver vazia:
        if (this.count == 0)
            throw new ListaVaziaErro("Lista vazia!");

        // Se o elemento for o primeiro da lista:
        if (Objects.equals(this.head.element, elemento)) {
            this.head = this.head.next;
            // Se a lista conter apenas um elemento:
            if (this.count == 1) this.tail = null;
            this.count--;
        }

        // Percorre a lista até encontrar o elemento.
        Nodo aux = this.head.next;
        Nodo ant = this.head;
        while (aux != null) {
            // Se o elemento a ser removido foi encontrado...
            if (aux.element.equals(elemento)) {
                // ...e o elemento for o último.
                if (aux == this.tail) {
                    this.tail = ant;
                    tail.next = null;
                // ...e o elemento estiver no meio da lista.
                } else {
                    assert ant != null;
                    ant.next = aux.next;
                }
                this.count--;
            }

            assert ant != null;
            ant = ant.next;
            aux = aux.next;
        }
        this.count--;
    }

    /**
     * Remove o elemento da posição passada como parâmetro.
     * @param indice indice do elemento a ser removido.
     * @return elemento passado como parâmetro.
     */
    public Integer removeByIndex(int indice) {
        // Lança uma exceção se o indice for inválido.
        if (indice < 0 || indice > this.count)
            throw new IndexOutOfBoundsException("Indice invalido!");

        // Se o elemento a ser removido for o primeiro.
        if (indice == 0) {
            Integer elemento = head.element;
            this.head = this.head.next;

            // Se houver apenas 1 elemento na lista.
            if (count == 1) {
                this.tail = null;
            }
            this.count--;
            return elemento;
        }

        // Se o elemento for o último ou estiver no meio da lista.
        Nodo aux = this.head;
        Nodo ant = null;
        for (int i = 0; i < indice; i++) {
            ant = aux;
            aux = aux.next;
        }
        if (aux == this.tail) {
            this.tail = ant;
            this.tail.next = null;
        } else {
            ant.next = aux.next;
        }

        this.count--;
        return aux.element;
    }

    /**
     * Retorna o indice da primeira aparição do elemento passado como parâmetro.
     * @param elemento elemento a ser buscado.
     * @return indice do elemento ou -1 se ele não existir.
     */
    public int indexOf(Integer elemento) {
        Nodo aux = this.head;
        int indice = 0;

        // Procura pelo elemento na lista.
        for (int i = 0; i < this.count; i++) {
            if (Objects.equals(aux.element, elemento) ) return i;

            aux = aux.next;
        }

        return -1;
    }

    /**
     * Procura o elemento passado como parâmetro e retorna um valor booleano.
     * @param elemento elemento a ser procurado.
     * @return true ou false.
     */
    public boolean contains(Integer elemento) {
        Nodo aux = this.head;

        for (int i = 0; i < this.count; i++) {
            if (Objects.equals(aux.element, elemento)) return true;
            aux = aux.next;
        }

        return false;
    }

    /**
     * Procura pelo nome passasdo como parâmetro e retorna um valor booleano.
     * @param nome nome do nodo.
     * @return true ou false.
     */
    public boolean contains(String nome) {
        Nodo aux = this.head;

        for (int i = 0; i < this.count; i++) {
            if (Objects.equals(aux.nome, nome)) return true;
            aux = aux.next;
        }

        return false;
    }

    /**
     * Retorna um vetor que contém os elementos da lista original entre os indices passados como argumento.
     * @param from indice inicial da lista.
     * @param to indice final da lista.
     * @return sublista.
     */
    public Integer[] sublist(int from, int to) {
        // Se o tamanho for negativo ou zero lança uma exceção.
        if ((to <= from) || (to > this.count) || (from < 0))
            throw new IndexOutOfBoundsException("Indice invalido.");

        Nodo aux = this.head;
        Integer[] sublista = new Integer[to - from];
        int count = 0;

        for (int i = 0; i < this.count; i++) {
            if ((i >= from) && (i < to)) {
                sublista[count] = aux.element;
                count++;
            }
            aux = aux.next;
        }

        return sublista;
    }

    /**
     * Organiza a lista em ordem decrescente.
     */
    public void organize() {
        // Se a lista estiver vazia, lança um erro.
        if (this.count == 0)
            throw new ListaVaziaErro("A lista está vazia!");

        for (int i = 0; i < this.count - 1; i++) {
            Nodo aux = this.head;
            for (int j = 0; j < this.count - 1; j++) {
                if (aux.element < aux.next.element) {
                    Nodo menor = new Nodo(aux.next.nome, aux.next.element);
                    aux.next.element = aux.element;
                    aux.next.nome = aux.nome;
                    aux.element = menor.element;
                    aux.nome = menor.nome;
                }
                aux = aux.next;
            }
        }
    }

    /**
     * Retorna a lista em formato string.
     * @return lista em formato String.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Nodo aux = this.head;

        while (aux != null) {
            s.append(aux.element.toString()).append(" ");
            aux = aux.next;
        }

        return s.toString();
    }
}
