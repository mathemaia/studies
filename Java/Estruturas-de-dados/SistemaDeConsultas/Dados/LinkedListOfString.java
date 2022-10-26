
public class LinkedListOfString {
    // Classe interna Node
    private class Node {
        public String element;
        public Node next;

        public Node(String element) {
            this.element = element;
            next = null;
        }
        
        public Node(String element, Node next) {
            this.element = element;
            this.next = next;
        }        
    }

    
    // Referência para o primeiro elemento da lista encadeada.
    private Node head;
    // Referência para o último elemento da lista encadeada.
    private Node tail;
    // Contador para a quantidade de elementos que a lista contem.
    private int count;
    // referencia para a última palavra inserida na lista
    Node current;

    
    /**
     * Construtor da lista.
     */
    public LinkedListOfString() {
        head = null;
        tail = null;
        count = 0;
    }
    
    /**
     * Retorna true se a lista nao contem elementos.
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Retorna o numero de elementos da lista.
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Esvazia a lista
     */
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }    

    /**
     * Adiciona um elemento ao final da lista.
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add (String element)  { // O(1)
        Node n = new Node(element);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        count++;
    }
    
    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posição da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public String get(int index) { // O(n)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == count-1)
            return tail.element;
        
        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        return (aux.element);
    }
    
    @Override
    public String toString() { // O(n)
        StringBuilder s = new StringBuilder();

        Node aux = head;

        while (aux != null) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }    
    
    ////////////////////////////////////////////////////////////////
    
    /**
     * Insere um elemento em uma determinada posicao da lista.
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, String element) { // O(n)
        // Primeiro verifica se index eh valido
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException(); // erro
        
        // Depois cria o nodo e incrementa count
        Node n = new Node(element);
        count++;
        
        // "Encadear" o nodo criado na lista
        if (index == 0) { // Insercao no inicio
            if (head == null) { // se a lista estava vazia
                tail = n;
            }
            else {
                n.next = head;
            }
            head = n;
        }
        else if (index == count) { // Insercao no fim
            tail.next = n;
            tail = n;
        }
        else { // Insercao no meio
            Node ant = head;
            for (int i=0; i<index-1; i++) 
                ant = ant.next;
            n.next = ant.next;
            ant.next = n;
        }
    }

    /**
     * Substitui o elemento armanzenado em uma determinada posicao da lista pelo
     * elemento indicado.
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public String set(int index, String element) { // O(n)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == count-1) { //se for a ultima posicao
            String num = tail.element; // guarda o elemento da posicao index
            tail.element = element; // troca o element da posicao index
            return num; // retorna o elemento que foi substituido
        }
        Node aux = head;
        for (int i=0; i<index; i++) 
            aux = aux.next;
        String num = aux.element;
        aux.element = element;
        return num;
    }

    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente.
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(String element) { // O(n)
        if (count == 0) // se a lista estiver vazia
            return false;
        
        if (head.element.equals(element)) { // se remocao do primeiro
            head = head.next;
            if (count==1) { // se tinha apenas 1 elemento na lista
                tail = null;
            }
            count--; // atualiza o count
            return true;
        }
        
        Node aux = head.next;
        Node ant = head;
        while (aux != null) {
            if (aux.element.equals(element)) { // se achou o elemento a ser removido
                if (aux == tail) { // se remocao do ultimo
                    tail = ant;
                    tail.next = null;
                }
                else { // se remocao do meio
                    ant.next = aux.next;
                }
                count--;
                return true;
            }
            aux = aux.next;
            ant = ant.next;
        }
        return false;
    }

    /**
     * Remove o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public String removeByIndex(int index) {
        // Primeiro verifica se index eh valido
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException(); //erro
        
        // Se remocao do primeiro elemento da lista
        if (index == 0) {
            String elem = head.element;
            head = head.next;
            if (count==1) // se tinha apenas 1 elemento na lista
                tail = null;
            count--; // atualiza o contador
            return elem;
        }
        
        // Se remocao do ultimo ou do meio
        Node aux = head;
        Node ant = null;
        for (int i=0; i<index; i++) {
            ant = aux;
            aux = aux.next;
        }
        if (aux==tail) { // se remocao do ultimo
            tail = ant;
            tail.next = null;
        }
        else { // remocao do meio
            ant.next = aux.next;
        }
        count--;
        return aux.element;
    }

    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento.
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento
     */
    public int indexOf(String element) {
        Node aux = head;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element))
                return i;
            aux = aux.next;
        }
        return -1;
    }

    /**
     * Retorna false se a lista nao contem o elemento especificado.
     * @param element o elemento a ser testado
     * @return true se o elemento existir e false caso contrário 
     */
    public boolean contains(String element) {
        Node aux = head;
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }
/**
     * Retorna uma referencia para o nodo que contem o elemento especificado.
     * @param element o elemento a ser testado
     * @return uma referencia para a primeira ocorrencia nodo que contem o elemento especificado.
     * Caso não exista, retorna null
     */
    public Node getRef(String element) {
        Node aux = head;
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element)) {
                return aux;
            }
            aux = aux.next;
        }
        return null;
    }

    /**
     * Retorna um arranjo que contem os elementos da lista original entre 
     * fromIndex (inclusivo) e toIndex (exclusivo).
     * @param fromIndex posicao a partir da qual os elementos serao inseridos no
     * arranjo a ser retornado
     * @param toIndex indica a posicao final dos elementos que devem ser inseridos
     * @return Um arranjo com um subconjunto dos elementos da lista.
     * @throws IndexOutOfBoundsException se (fromIndex < 0 || toIndex > size())
     * @throws IllegalArgumentException se (fromIndex >= toIndex)
     */   
    public Integer[] subList (int fromIndex , int toIndex) {
        // Primeiro verifica se os indices sao validos
        if (fromIndex < 0 || toIndex > size())
            throw new IndexOutOfBoundsException();
        if (fromIndex >= toIndex)
            throw new IllegalArgumentException();
        
        // Cria o arranjo
        
        // "Caminha" ate a posicao fromIndex
        
        // Copia os elementos de fromIndex a toIndex para o arranjo
        
        // Retorna o arranjo
        return null;
    }

    public void addIncreasingOrder(String element)
    {
      int i;
      Node aux = head;
      for(i=0; i<count; i++) {
          if (aux.element.compareTo(element) > 0)
              break;
          aux = aux.next;
      }
      add(i,element);
      aux = getRef(element); // obtem uma referencia para o nodo dentro da lista
      System.out.println("Elemento inserido: " + aux.element); // imprime o nodo
    }

    public int countOccurrences(String element)
    {
        int nOccurences=0;
        
        Node aux = head;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element))
                nOccurences++;
            aux = aux.next;
        }
        return nOccurences;
    }
   
      public Node EncontraAnterior(Node ptr) {
        if (ptr == head) // o 1o. nao tem anterior
          return null;
        Node aux;
        aux = head;
        while (aux != null) {
          if (aux.next == ptr)
            break;
          aux = aux.next;
        }
        return aux;
      }

}
