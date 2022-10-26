package Sistema;

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
        public Integer elemento;
        public Nodo proximo;

        /**
         * Construtor.
         * @param elemento elemento a ser inicializado com o nodo.
         * @param proximo referência ao próximo elemento da cadeia.
         */
        public Nodo(Integer elemento, Nodo proximo) {
            this.elemento = elemento;
            this.proximo = proximo;
        }
        public Nodo(Integer elemento) {
            this.elemento = elemento;
            this.proximo = null;
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
     * Adiciona um elemento no final da lista.
     * @param elemento elemento a ser adicionado.
     * @param indice posição que o elemento será inserido.
     * @throws IndexOutOfBoundsException se o índice passado for inválido.
     */
    public void add(int indice, Integer elemento) {
        Nodo aux = new Nodo(elemento);

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
                aux.proximo = head;
            }
            this.head = aux;
        // Se o índice for a última posição:
        } else if (indice == this.count) {
            this.tail.proximo = aux;
            this.tail = aux;
        // Se o índice estiver no meio da lista.
        } else {
            Nodo ant = head;
            for (int i = 0; i < indice; i++) {
                ant = ant.proximo;
            }
            aux.proximo = ant.proximo;
            ant.proximo = aux;
        }

        this.count++;
    }

    /**
     * Retorna o elemento de indice passado como argumento.
     * @param indice indice do elemento a ser retornado.
     * @return elemento a ser retornado.
     */
    public Integer get(int indice) {
        // Lança uma exceção se o indice passado for inválido.
        if (indice < 0 || indice >= this.count)
            throw new IndexOutOfBoundsException("Indice invalido!");

        // Retorna o tail se o indice for o deste.
        if (indice == this.count - 1)
            return this.tail.elemento;

        // Procura pelo indice passado.
        Nodo aux = this.head;
        for (int i = 0; i < indice; i++) {
            aux = aux.proximo;
        }

        return aux.elemento;
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
        if (Objects.equals(this.head.elemento, elemento)) {
            this.head = this.head.proximo;
            // Se a lista conter apenas um elemento:
            if (this.count == 1) this.tail = null;
            this.count--;
        }

        // Percorre a lista até encontrar o elemento.
        Nodo aux = this.head.proximo;
        Nodo ant = this.head;
        while (aux != null) {
            // Se o elemento a ser removido foi encontrado...
            if (aux.elemento.equals(elemento)) {
                // ...e o elemento for o último.
                if (aux == this.tail) {
                    this.tail = ant;
                    tail.proximo = null;
                // ...e o elemento estiver no meio da lista.
                } else {
                    assert ant != null;
                    ant.proximo = aux.proximo;
                }
                this.count--;
            }

            assert ant != null;
            ant = ant.proximo;
            aux = aux.proximo;
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
            Integer elemento = head.elemento;
            this.head = this.head.proximo;

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
            aux = aux.proximo;
        }
        if (aux == this.tail) {
            this.tail = ant;
            this.tail.proximo = null;
        } else {
            ant.proximo = aux.proximo;
        }

        this.count--;
        return aux.elemento;
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
            if (Objects.equals(aux.elemento, elemento) ) return i;

            aux = aux.proximo;
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
            if (Objects.equals(aux.elemento, elemento)) return true;
            aux = aux.proximo;
        }

        return false;
    }

    /**
     * Conta o número de ocorrências do elemento passado como parâmetro.
     * @param elemento elemento a ser contabilizado.
     * @return quantidade de vezes que ele aparece na lista.
     */
    public int countOccurrences(Integer elemento) {
        Nodo aux = this.head;
        int count = 0;

        for (int i = 0; i < this.count; i++) {
            if (Objects.equals(aux.elemento, elemento)) count++;
            aux = aux.proximo;
        }

        return count;
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
                sublista[count] = aux.elemento;
                count++;
            }
            aux = aux.proximo;
        }

        return sublista;
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
            s.append(aux.elemento.toString()).append(" ");
            aux = aux.proximo;
        }

        return s.toString();
    }
}
