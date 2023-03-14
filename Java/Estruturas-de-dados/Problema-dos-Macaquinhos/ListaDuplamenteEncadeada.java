package Alest2;

import java.util.Objects;

/**
 * Classe que implementa a estrutura abstrata de dados lista duplamente encadeada.
 * @author Matheus Maia
 * @version 03-10-2022
 */
 
public class ListaDuplamenteEncadeada {
    // Contador de elementos.
    private int count;
    // Sentinelas.
    private final Nodo header;
    private final Nodo trailer;

    /**
     * Classe interna Nodo. Contém um elemento, uma referência para o Nodo anterior outra para o próximo
     */
    public static class Nodo {
        private Macaquinho macaquinho;
        private Nodo next;
        private Nodo previous;

        public Nodo(Macaquinho macaquinho) {
            this.macaquinho = macaquinho;
            this.next = null;
            this.previous = null;
        }

        /**
         * Retorna o Macaquinho do nodo
         * */
        public Macaquinho getMacaquinho() {
            return macaquinho;
        }
    }

    /**
     * Construtor.
     */
    public ListaDuplamenteEncadeada() {
        this.header = new Nodo(null);
        this.trailer = new Nodo(null);
        this.header.next = this.trailer;
        this.trailer.previous = this.header;
        this.count = 0;
    }

    /**
     * Adiciona um elemento à última posição da lista.
     * @param macaquinho elemento a ser inserido.
     */
    public void append(Macaquinho macaquinho) {
        Nodo aux = new Nodo(macaquinho);

        // Conecta o nodo na última posição da lista.
        aux.next = this.trailer;
        aux.previous = this.trailer.previous;
        this.trailer.previous.next = aux;
        this.trailer.previous = aux;

        this.count++;
    }

    /**
     * Adiciona um macaquinho por indice.
     * @param macaquinho macaquinho a ser inserido na lista.
     * @param indice indice do macaquinho a ser inserido.
     */
    public void set(int indice, Macaquinho macaquinho) {
        // Lança uma exceção se o indice passado for inválido.
        if ((indice > this.count) || (indice < 0))
            throw new IndexOutOfBoundsException("Indice inválido!");

        // Se o índice for igual ao tamanho atual da lista, adiciona no fim.
        if (this.count == indice) append(macaquinho);

        // Percorre a lista até o índice passado.
        Nodo aux = new Nodo(macaquinho);
        Nodo ptr = getNode(indice);

        // Linka o novo Nodo como o próximo do Nodo de índice passado.
        ptr.previous.next = aux;
        aux.previous = ptr.previous;
        ptr.previous = aux;
        aux.next = ptr;

        this.count++;
    }

    /**
     * Retorna o Nodo do índice passado como parâmetro sem removê-lo.
     *
     * @param indice índice do nodo.
     * @return Nodo.
     */
    public Nodo getNode(int indice) {
        // Lança um erro caso o parâmetro passado seja negativo ou maior/igual ao número de elementos.
        if ((indice < 0) || (indice >= count))
            throw new IndexOutOfBoundsException();

        // Percorre a lista até o índice passado como parâmentro.
        Nodo aux;
        if (indice <= (this.count / 2)) {
            aux = this.header.next;
            for (int i = 0; i < indice; i++) {
                aux = aux.next;
            }
        } else {
            aux = this.trailer.previous;
            for (int i = count - 1; i > indice; i--) {
                aux = aux.previous;
            }
        }

        return aux;
    }

    /**
     * Retorna o elemento do índice passado como parâmentro.
     * @param indice posição do elemento.
     * @return elemento de posição índice.
     */
    public Macaquinho get(int indice) {
        // Checa se o índice é válido.
        if ((indice < 0) || (indice >= this.count))
            throw new IndexOutOfBoundsException("Indice invalido!");

        return getNode(indice).macaquinho;
    }

    /**
     * Remove o elemento de posição indice.
     * @param indice posição do elemento a ser removido.
     * @return elemento removido.
     */
    public Macaquinho remove(int indice) {
        // Verifica se o index é válido.
        if ((indice < 0) || (indice >= count))
            throw new IndexOutOfBoundsException("Indice invalido!");

        // Se está antes da metade, começa percorrendo pelo header.
        Nodo aux = getNode(indice);
        aux.previous.next = aux.next;
        aux.next.previous = aux.previous;

        // Retorna o elemento.
        this.count--;
        return aux.macaquinho;
    }

    /**
     * Retorna um valor booleano para se a lista está ou não vazia.
     * @return true ou false.
     */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Retorna o tamanho atual da lista.
     * @return tamanho atual.
     */
    public int size() {
        return this.count;
    }

    /**
     * Retorna um valor booleano para se existe o macaquinho passado como parâmetro.
     * @param macaquinho macaquinho a ser procurado.
     * @return true ou false.
     */
    public boolean contains(Macaquinho macaquinho) {
        Nodo aux = this.header.next;
        boolean contem = false;

        // Começa a iteração no primeiro macaquinho e termina quando alcançar o trailer.
        while (aux != this.trailer) {
            if (Objects.equals(aux.macaquinho, macaquinho)) {
                contem = true;
                break;
            }
            aux = aux.next;
        }
        return contem;
    }

    /**
     * Retorna o indice da primeira aparição do macaquinho. Caso não exista, retorna -1.
     * @param macaquinho macaquinho a ter o indice retornado.
     * @return indice do macaquinho passado como parâmetro.
     */
    public int indexOf(Macaquinho macaquinho) {
        if (contains(macaquinho)) {
            Nodo aux = this.header.next;
            int idx = 0;

            // Itera a lista até encontrar o trailer.
            for (int i = 0; i < count; i++) {
                if (Objects.equals(aux.macaquinho, macaquinho)) {
                    idx = i;
                    break;
                }
            }

            return idx;
        }

        return -1;
    }

    /**
     * Esvazia a lista.
     */
    public void clear() {
        this.header.next = this.trailer;
        this.trailer.previous = this.header;
        this.count = 0;
    }

    /**
     * Imprime no terminal todos os elementos da lista.
     * @return todos os elementos da lista.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Nodo aux = header.next;
        for (int i = 0; i < this.count; i++) {
            s.append(aux.macaquinho.toString());
            s.append("\n");
            aux = aux.next;
        }

        return s.toString();
    }

    /**
     * Retorna a quantidade vezes que o macaquinho passado como parâmetro aparece na lista.
     * @param macaquinho macaquinho a ser contabilizado.
     * @return quantidade de vezes que o macaquinho aparece.
     */
    public int countOccurrences(Macaquinho macaquinho) {
        Nodo aux = header.next;
        int contador = 0;

        for (int i = 0; i < this.count; i++) {
            if (aux.macaquinho.equals(macaquinho)) {
                contador++;
            }
            aux = aux.next;
        }

        return contador;
    }
}
