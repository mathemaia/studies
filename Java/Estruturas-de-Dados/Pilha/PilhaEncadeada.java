package pilha;

/**
 * Classe criada como estudo para a disciplina de Algoritmos e Estruturas de Dados I. A ideia é criar uma pilha que tem
 * os seus elementos guardados em Nodos, tal que estes nodos guardam também referência para o próximo. A pilha inicia
 * com um Nodo base e um Nodo topo. Todos os elementos inseridos são encadeados tendo como referência o próximo do topo
 * e se tornando o novo próximo do topo.
 * @author Matheus Maia
 * @version 03-10-2022
 */

public class PilhaEncadeada {
    private int count;
    private Nodo topo;
    private Nodo base;

    private static class Nodo {
        private Integer element;
        private Nodo next;

        public Nodo(Integer element) {
            this.element = element;
            this.next = null;
        }
    }

    public PilhaEncadeada() {
        this.count = 0;
        this.topo = new Nodo(null);
        this.base = new Nodo(null);
        this.topo.next = this.base;
    }

    public void push(Integer element) {
        Nodo aux = new Nodo(element);
        aux.next = this.topo.next;
        this.topo.next = aux;
        this.count++;
    }

    public Integer pop() {
        Nodo aux = this.topo.next;
        this.topo.next = aux.next;
        aux.next = null;
        this.count--;
        return aux.element;
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public static void main(String[] args) {
        PilhaEncadeada pilha = new PilhaEncadeada();

        // Mostra os status inicial da pilha.
        System.out.println("Esta vazia: " + pilha.isEmpty());
        System.out.println("Tamanho: " + pilha.size() + "\n");

        // Insere 50 elementos na lista {50, 49, 48,..., 1}
        System.out.println("Inserindo novos elementos...\n");
        for (int i = 0, j = 50; i < 50; i++, j--) {
            pilha.push(j);
        }

        // Atualiza o status.
        System.out.println("Esta vazia: " + pilha.isEmpty());
        System.out.println("Tamanho: " + pilha.size() + "\n");

        // Retira os últimos 7 elementos inseridos.
        for (int i = 0; i < 8; i++) {
            System.out.println("pop -> " + pilha.pop());
        }

        // Atualiza o status.
        System.out.println("\nEsta vazia: " + pilha.isEmpty());
        System.out.println("Tamanho: " + pilha.size());
    }
}
