package Sistema;

import java.util.Objects;

/**
 * Classe que implementa uma lista linear usando arranjo (lista estática).
 * @author Matheus Maia
 * @version 01-10-2022
 */

public class ListaEstatica {
    private final int TAMANHO_INICIAL = 10;
    private Integer[] dados;
    private int count;

    /**
     * Construtores.
     */
    public ListaEstatica() {
        this.dados = new Integer[TAMANHO_INICIAL];
        this.count = 0;
    }
    public ListaEstatica(int tam) {
        if (tam > 0) {
            this.dados = new Integer[tam];
            this.count = 0;
        }
    }

    /**
     * Esvazia a lista e cria uma nova vazia.
     */
    public void clear() {
        this.dados = new Integer[TAMANHO_INICIAL];
        this.count = 0;
    }

    /**
     * Define uma nova capacidade máxima ao vetor da lista. Tamanho padrão: 10
     */
    public void setCapacity(int capacity) {
        // Se a nova capacidade for diferente do tamanho do vetor, cria um novo vetor.
        if (capacity != dados.length) {
            int min = 0;
            Integer[] novoVetor = new Integer[capacity];

            // Bloco que define até qual posição irá adicionar os dados do vetor antigo
            if (this.dados.length < capacity) {
                min = dados.length;
            } else {
                min = capacity;
            }
            for (int i = 0; i < min; i++) {
                novoVetor[i] = this.dados[i];
            }
            dados = novoVetor;
        }
    }

    /**
     * Adiciona um novo elemento na última posição da lista.
     * @param elemento o que será inserido
     */
    public void add(Integer elemento) {
        if (count == dados.length) {
            setCapacity(dados.length * 2);
        }
        this.dados[count] = elemento;
        this.count++;
    }

    /**
     * True ou False se estiver vazia.
     * @return true ou false.
     */
    public boolean isEmpty() { return count == 0; }

    /**
     * Retorna o tamanho atual da lista.
     * @return tamanho.
     */
    public int size() { return this.count; }

    /**
     * Retorna um elemento de index fornecido e sem removê-lo.
     * @param index índice do elemento.
     * @return elemento da posição index.
     * @throws IndexOutOfBoundsException se (index < 0 || index >= count)
     */
    public int get(int index) {
        if (index < 0 || index >= count)
            throw new IndexOutOfBoundsException("Index: " + index);
        return this.dados[index];
    }

    /**
     * Substitui o elemento armazenado no indice inserido pelo elemento passado como parâmetro e o retorna.
     * @param index posição a ser inserida.
     * @param elemento elemento da posição inserido.
     * @return elemento da posição inserida.
     */
    public Integer set(int index, Integer elemento) {
        if (count == 0)
            throw new ListaVaziaErro("Lista vazia!");
        Integer aux = this.dados[index];
        this.dados[index] = elemento;
        return aux;
    }

    /**
     * Procura pelo emento passado como parâmetro e retorna true se ele estiver na lista.
     * @param elemento elemento a ser procurado.
     * @return true ou false.
     * @throws ListaVaziaErro se a lista estiver vazia.
     */
    public boolean contains(Integer elemento) {
        if (count == 0)
            throw new ListaVaziaErro("Lista vazia!");
        boolean aux = false;
        for (Integer dado : this.dados) {
            if (Objects.equals(dado, elemento)) {
                aux = true;
            }
        }
        return aux;
    }

    /**
     * @return capacidade máxima da lista.
     */
    public int capacity() {
        int aux;
        if (count == 0) {
            aux = TAMANHO_INICIAL;
        } else {
            aux = this.dados.length;
        }
        return aux;
    }
}

