package ArvoreGenerica;

import java.util.LinkedList;

public class ArvoreGenerica {
    // Classe interna nodo.
    private static class SubArvore {
        // Atributos.
        private SubArvore pai;
        private Integer elemento;
        private LinkedList<SubArvore> filhos;

        /**
         * Construtor.
         * @param elemento elemento do nodo.
         */
        public SubArvore(Integer elemento) {
            this.elemento = elemento;
            this.pai = null;
            this.filhos = new LinkedList<>();
        }

        /**
         * Adiciona um filho à sub-arvore (nodo) atual.
         * @param filho nodo que será inserido como sub-árvore.
         */
        private void addSubtree(SubArvore filho) {
            // Define que o pai desta sub-árvore é o nodo atual.
            filho.pai = this;
            // Adiciona este nodo à lista de nodos filhos - subtrees.
            this.filhos.add(filho);
        }

        /**
         * Remove uma sub-árvore (nodo) da lista de filhos.
         * @param subArvore sub-árvore a ser removida.
         * @return se foi possível remover da lista, retorna true;
         */
        private boolean removeSubtree(SubArvore subArvore) {
            subArvore.pai = null;
            return this.filhos.remove(subArvore);
        }

        /**
         * Obtém uma sub-árvore (nodo) de índice i.
         * @param i indice da sub-árvore.
         * @return sub-árvore escolhida.
         */
        public SubArvore getSubtree(int i) {
            if ((i < 0) || (i >= filhos.size()))
                throw new IndexOutOfBoundsException();
            return this.filhos.get(i);
        }

        /**
         * Obtém o tamanho sub-árvore (nodo) em questão.
         * @return quantidade de filhos da sub-árvore.
         */
        public int size() {
            return this.filhos.size();
        }
    }

    // Atributos.
    private SubArvore raiz;
    private int contador;

    /**
     * Construtor.
     */
    public ArvoreGenerica() {
        this.raiz = null;
        this.contador = 0;
    }

    /**
     * Insere 'elemento' como filho da sub-árvore 'elementoPai'.
     * @param elemento elemento a ser inserido.
     * @param elementoPai elemento pai.
     * @return true se conseguir e false se não conseguir.
     */
    public boolean add(Integer elemento, Integer elementoPai) {
        // Cria a sub-árvore (nodo) a ser adicionada.
        SubArvore subarvore = new SubArvore(elemento);

        // Se 'elementoPai' for null então a sub-árvore a ser inserida será a nova raiz.
        if (elementoPai == null) {
            // Se a árvore genérica não estiver vazia.
            if (this.raiz != null) {
                subarvore.addSubtree(this.raiz);
            // Se a árvore genérica estiver vazia.
            } else {
                this.raiz = subarvore;
                this.contador++;
                return true;
            }
        // Se não, insere 'elemento' como filho de 'elementoPai'.
        } else {
            // Encontra a posição da árvore 'elementoPai'.
            SubArvore aux = searchNodeRef(elementoPai, this.raiz);
        }
    }

    /**
     * Procura pelo filho (elemento) de uma sub-árvore.
     * @param elemento filho a ser procurado em uma subárvore.
     * @param subArvore sub-árvore que irá ser vasculhada.
     * @return referência do nodo a qual o elemento está armazenado - se não existir retorna null.
     */
    private SubArvore searchNodeRef(Integer elemento, SubArvore subArvore) {
        // Se a sub-árvore (nodo) passada como parâmetro for null, retorna null.
        if (subArvore == null) {
            return null;
        }

        // Se o elemento for o da sub-árvore (nodo) passada como parâmetro.
        if (elemento.equals(subArvore.elemento)) {
            return subArvore;
        // Se não, checa se está em um dos filhos de 'subarvore'.
        } else {
            SubArvore aux = null;
            for (int i = 0; i < subArvore.size(); i++) {
                aux = searchNodeRef(elemento, subArvore.getSubtree(i));
            }
            return aux;
        }
    }

}
