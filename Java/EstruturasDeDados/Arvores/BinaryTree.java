package ArvoreBinaria;

/**
 * Classe que cria uma árvore binária com elementos inteiros.
 * @author matheus maia
 * @version 04-012-2022
 */

public class BinaryTree {
    /**
     * Classe interna Node. Cada nodo possui um pai, um elemento e uma referência para o seu filho a esquerda e direita.
     */
    private class Node {
        Node father, left, right;
        Integer element;

        public Node(Integer element, Node father) {
            this.father = father;
            this.left = null;
            this.right = null;
            this.element = element;
        }
    }

    // Atributos.
    Node root;
    int count;

    /**
     * Construtores. Caso não seja passado parâmetro, inicia com a raiz nula.
     * @param element elemento do nodo raiz.
     */
    public BinaryTree(Integer element) {
        this.root = new Node(element, null);
        this.count = 1;
    }
    public BinaryTree() {
        this.root = null;
        this.count = 0;
    }

    /**
     * Método que retorna se a árvore binária está ou não vazia.
     * @return true ou false.
     */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Método que retorna a quantidade de nodos que existem na árvore.
     * @return quantidade de nodos.
     */
    public int size() {
        return this.count;
    }

    /**
     * Método que reinicia a árvore binária zerando sua quantidade de nodos.
     */
    public void clear() {
        this.root = null;
        this.count = 0;
    }

    /**
     * Adiciona um elemento sem fazer menção ao pai.
     * @param element elemento a ser adicionado na árvore.
     */
    public void add(Integer element, Integer father) {
        Node aux = getNodeRef(father);

        if (element > aux.element) {
            aux.right = new Node(element, aux);
        } else if (element < aux.element) {
            aux.left = new Node(element, aux);
        }
    }

    /**
     * Retorna o nodo com o elemento passado como parâmetro.
     * @param element elemento que está contino no nodo que se procura.
     * @return nodo com o elemento passado como parâmetro.
     */
    private Node getNodeRef(Integer element) {
        // Se o nodo que se procura é a raiz, retorna ela.
        if (this.root.element == element) {
            return this.root;
        }

        // Procura o nodo a partir da raiz.
        Node aux = this.root;
        while (true) {
            if (element > aux.element) {
                aux = aux.right;
            } else if (element < aux.element) {
                aux = aux.left;
            } else if (element == aux.element) {
                return aux;
            } else {
                return null;
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Os Métodos abaixo servem para gerar um código para vizualização da árvore nos links abaixo.
    // Web Graph Viz: http://www.webgraphviz.com/
    // Viz JS: http://viz-js.com/
    /**
     * Gera um código para a vizualização da árvore.
     */
    public void GeraDOT() {
        System.out.println("digraph g { \nnode [shape = record,height=.1];\n" + "\n");

        GeraNodosDOT();
        System.out.println("");
        GeraConexoesDOT(root);
        System.out.println("}" + "\n");
    }
    private void GeraConexoesDOT(Node nodo) {
        if (nodo == null) {
            return;
        }

        GeraConexoesDOT(nodo.left);
        //   "nodeA":esq -> "nodeB" [color="0.650 0.700 0.700"]
        if (nodo.left != null) {
            System.out.println("\"node" + nodo.element + "\":esq -> \"node" + nodo.left.element + "\" " + "\n");
        }

        GeraConexoesDOT(nodo.right);
        //   "nodeA":dir -> "nodeB";
        if (nodo.right != null) {
            System.out.println("\"node" + nodo.element + "\":dir -> \"node" + nodo.right.element + "\" " + "\n");
        }
        //"[label = " << nodo->hDir << "]" <<endl;
    }
    private void GeraNodosDOT(Node nodo) {
        if (nodo == null) {
            return;
        }
        GeraNodosDOT(nodo.left);
        //node10[label = "<esq> | 10 | <dir> "];
        System.out.println("node" + nodo.element + "[label = \"<esq> | " + nodo.element + " | <dir> \"]" + "\n");
        GeraNodosDOT(nodo.right);
    }
    public void GeraConexoesDOT() {
        GeraConexoesDOT(root);
    }
    public void GeraNodosDOT() {
        GeraNodosDOT(root);
    }

}
