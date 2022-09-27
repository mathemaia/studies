package Listas;

/**
 * Classe que implementa uma lista linear usando arranjo (lista estática).
 * @author Matheus Maia
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
    }

    /**
     * Define uma nova capacidade máxima ao vetor da lista.
     * @param capacity
     */
    public void setCapacity(int capacity) {
        // Se a nova capacidade for diferente do tamanho do vetor, cria um novo vetor.
        if (capacity != dados.length) {
            int min = 0;
            Integer[] novoVetor = new Integer[capacity];

            // Bloco que define até qual posição irá adicionar os dados do vetor antigo
            if (dados.length < capacity) {
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
}

