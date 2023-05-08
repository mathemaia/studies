package AlestII.Graphs;

import java.util.ArrayList;

public class Graph<E> {
    // Atributes
    private ArrayList<Vertex<E>> vertices;
    private ArrayList<Edge<E>> egdes;

    // Constructor
    public Graph() {
        this.vertices = new ArrayList<>();
        this.egdes = new ArrayList<>();
    }

    // Setters
    public void addVertex(E vertex) {
        this.vertices.add(new Vertex<>(vertex));
    }
    public void addEdge() {
    }
    public void removeEdge() {
    }
    public void removeVertex() {
    }
}

class Vertex<E> {
    // Atributes
    private E element;
    private ArrayList<Edge<E>> incomingEdges;
    private ArrayList<Edge<E>> outgoingEdges;

    // Constructor
    public Vertex(E element) {
        this.element = element;
        this.incomingEdges = new ArrayList<>();
        this.outgoingEdges = new ArrayList<>();
    }

    // Getters
    public E getElement() {
        return element;
    }
    public ArrayList<Edge<E>> getIncomingEdges() {
        return incomingEdges;
    }
    public ArrayList<Edge<E>> getOutgoingEdges() {
        return outgoingEdges;
    }

    // Setters
    public void setElement(E element) {
        this.element = element;
    }
    public void addIncomingEdge(Edge<E> incomingEdge) {
        this.incomingEdges.add(incomingEdge);
    }
    public void addOutgoingEdge(Edge<E> outgoingEdge) {
        this.outgoingEdges.add(outgoingEdge);
    }
}

class Edge<E> {
    // Atributes
    private Vertex<E> origin;
    private Vertex<E> destiny;

    // Constructor
    public Edge(Vertex<E> origin, Vertex<E> destiny) {
        this.origin = origin;
        this.destiny = destiny;
    }

    // Getters
    public Vertex<E> getOrigin() {
        return origin;
    }
    public Vertex<E> getDestiny() {
        return destiny;
    }

    // Setters
    public void setOrigin(Vertex<E> origin) {
        this.origin = origin;
    }
    public void setDestiny(Vertex<E> destiny) {
        this.destiny = destiny;
    }
}


