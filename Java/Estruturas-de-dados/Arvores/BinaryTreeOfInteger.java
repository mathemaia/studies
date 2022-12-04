package ArvoreBinaria;
import java.util.NoSuchElementException;



public class BinaryTreeOfInteger {


    /**
     * Conta a quantidade de nodos-folha a partir do nodo com cujo elemento é igual ao passado como parâmetro.
     * @param element elemento do nodo que o algoritmo irá começar a caminhar.
     * @return quantidade de nodos-folha.
     */
    public Integer countSeeds(int element) {
        Node aux = searchNodeRef(element, root);

        int a = 0;
        int b = 0;

        // Caso o nodo tenha filho apenas na direita
        if (aux.left == null && aux.right != null) {
            a = countSeeds(aux.right.element);
        }

        // Caso o nodo tenha filho apenas na esquerda
        if (aux.left != null && aux.right == null) {
            b = countSeeds(aux.left.element);
        }

        if (aux.left != null && aux.right != null) {
            a = countSeeds(aux.left.element);
            b = countSeeds(aux.right.element);
        }

        // Caso o nodo tenha filhos a direita e esquerda
        if (aux.left == null && aux.right == null) {
            return 1;
        }

        return a + b;
    }

}
