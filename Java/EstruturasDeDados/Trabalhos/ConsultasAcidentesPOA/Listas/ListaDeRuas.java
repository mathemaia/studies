package Listas;

import java.util.Objects;

/**
 * Esta é a classe da lista de acidentes.
 * @author matheus maia
 * @version 27-10-2022
 */

public class ListaDeRuas {
    /**
     * Classe interna Nodo. Contém um elemento, uma referência para o Nodo anterior outra para o próximo
     */
    private static class Rua {
        // Nome da rua.
        private String nome;
        // Elemento do nodo: lista de acidentes.
        private ListaDeAcidentes listaDeAcidentes;
        // Referência para os nodos (Ruas) adjacentes.
        private Rua next;
        private Rua prev;

        public Rua(String nome, ListaDeAcidentes listaDeAcidentes) {
            this.nome = nome;
            this.listaDeAcidentes = listaDeAcidentes;
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {
            return this.nome;
        }
    }

    /**
     * Construtor.
     */
    public ListaDeRuas() {
        this.header = new Rua(null,null);
        this.trailer = new Rua(null, null);
        this.header.next = this.trailer;
        this.trailer.prev = this.header;
        this.count = 0;
    }

    // Contador de elementos.
    private int count;
    // Sentinelas.
    private final Rua header;
    private final Rua trailer;

    /**
     * Adiciona uma Rua (nodo) com sua ListaDeAcidentes (elemento) à última posição da lista.
     * @param acidentes elemento a ser inserido.
     */
    public void addRua(String nome, ListaDeAcidentes acidentes) {
        if (contains(nome)) {
            System.out.println("Já existe uma rua com este nome.");
        } else {
            Rua aux = new Rua(nome, acidentes);

            // Conecta o nodo na última posição da lista.
            aux.next = this.trailer;
            aux.prev = this.trailer.prev;
            this.trailer.prev.next = aux;
            this.trailer.prev = aux;

            this.count++;
        }
    }

    /**
     * Adiciona uma ListaDeAcidentes (elemento) por indice.
     * @param acidentes elemento a ser inserido na lista.
     * @param indice indice do elemento a ser inserido.
     */
    public void addByIndex(int indice, String nome, ListaDeAcidentes acidentes) {
        // Lança uma exceção se o indice passado for inválido.
        if ((indice > this.count) || (indice < 0))
            throw new IndexOutOfBoundsException("Indice inválido!");

        // Se o índice for igual ao tamanho atual da lista, adiciona no fim.
        if (this.count == indice) {
            addRua(nome, acidentes);
        } else {
            // Percorre a lista até o índice passado.
            Rua aux = new Rua(nome, acidentes);
            Rua ptr = getRua(indice);

            // Linka o novo Nodo como o próximo do Nodo de índice passado.
            ptr.prev.next = aux;
            aux.prev = ptr.prev;
            ptr.prev = aux;
            aux.next = ptr;

            this.count++;
        }
    }

    /**
     * Remove a primeira ocorrência da Rua (nodo) na lista - se existir.
     * @param rua nome da Rua (nodo) a ser removida da lista.
     * @return true ou false se a lista contém a Rua (nodo) especificada.
     */
    public boolean remove(String rua) {
        Rua aux = header.next;

        // Percorre a lista de ruas até o trailer.
        while (aux != trailer) {
            if (Objects.equals(aux.nome, rua)) {
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                this.count--;
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    /**
     * Remove a Rua (nodo) de posição indice e retorna sua ListaDeAcidentes (elemento).
     * @param indice posição da Rua (elemento) a ser removida.
     * @return ListaDeAcidentes (elemento) da Rua (nodo) removida.
     */
    public ListaDeAcidentes removeByIndex(int indice) {
        // Verifica se o index é válido.
        if ((indice < 0) || (indice >= count))
            throw new IndexOutOfBoundsException("Indice invalido!");

        // Se está antes da metade, começa percorrendo pelo header.
        Rua aux = getRua(indice);
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;

        // Retorna o elemento.
        this.count--;
        return aux.listaDeAcidentes;
    }

    /**
     * Retorna um valor booleano para se existe a Rua (nodo) passado como parâmetro.
     * @param rua nome da rua a ser procurada na lista de ruas.
     * @return true ou false.
     */
    public boolean contains(String rua) {
        Rua aux = this.header.next;
        boolean contem = false;

        // Começa a iteração no primeiro elemento e termina quando alcançar o trailer.
        while (aux != this.trailer) {
            if (aux.nome.equals(rua)) {
                contem = true;
                break;
            }
            aux = aux.next;
        }
        return contem;
    }

    /**
     * Retorna a ListaDeAcidentes (elemento) da Rua (nodo) de índice passado como parâmentro.
     * Equivalente ao método get().
     * @param indiceRua indice da Rua (nodo).
     * @return ListaDeAcidentes (elemento) da Rua (nodo) encontrada.
     */
    public ListaDeAcidentes listaDeAcidentes(int indiceRua) {
        // Checa se o índice é válido.
        if ((indiceRua < 0) || (indiceRua >= this.count))
            throw new IndexOutOfBoundsException("Indice invalido!");

        return getRua(indiceRua).listaDeAcidentes;
    }

    /**
     * Retorna a Rua (nodo) do índice passado como parâmetro sem removê-lo.
     * Equivalente ao método getNodeIndex().
     * @param indice índice do nodo.
     * @return Nodo.
     */
    public Rua getRua(int indice) {
        // Lança um erro caso o parâmetro passado seja negativo ou maior/igual ao número de elementos.
        if ((indice < 0) || (indice >= count))
            throw new IndexOutOfBoundsException("Indice invalido!");

        // Percorre a lista até o índice passado como parâmentro.
        Rua aux;
        if (indice <= (this.count / 2)) {
            aux = this.header.next;
            for (int i = 0; i < indice; i++) {
                aux = aux.next;
            }
        } else {
            aux = this.trailer.prev;
            for (int i = count - 1; i > indice; i--) {
                aux = aux.prev;
            }
        }

        return aux;
    }

    /**
     * Retorna o indice da primeira aparição da Rua (nodo). Caso não exista, retorna -1.
     * @param rua Rua (nodo) a ser procurada e ter o indice retornado.
     * @return indice da Rua (nodo) passado como parâmetro.
     */
    public int indexOf(String rua) {
        if (contains(rua)) {
            Rua aux = this.header.next;
            int idx = 0;

            // Itera a lista até encontrar o trailer.
            for (int i = 0; i < count; i++) {
                if (Objects.equals(aux.nome, rua)) {
                    idx = i;
                    break;
                }
                aux = aux.next;
            }

            return idx;
        }

        return -1;
    }

    /**
     * Esvazia a lista de ruas.
     */
    public void clear() {
        this.header.next = this.trailer;
        this.trailer.prev = this.header;
        this.count = 0;
    }

    /**
     * Retorna o tamanho atual da lista.
     * @return tamanho atual.
     */
    public int size() {
        return this.count;
    }

    /**
     * Retorna um valor booleano para se a lista está ou não vazia.
     * @return true ou false.
     */
    public boolean isEmpty() {
        return this.count == 0;
    }
}