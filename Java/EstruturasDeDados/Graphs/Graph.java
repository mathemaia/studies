package AlestII.Graphs;

import java.util.ArrayList;

/**
 * Directed Graph implemented with Adjacency Lists
 * @param <E> the type that the Vertices will contain
 * @author Matheus Maia
 * @version 14-05-2023
 */
public class Graph<E> {
    // Atributes
    private ArrayList<Vertex<E>> vertices;
    private ArrayList<Edge<E>> egdes;

    // Constructor
    public Graph() {
        this.vertices = new ArrayList<>();
        this.egdes = new ArrayList<>();
    }

    // Getters
    /**
     * Returns the number of vertices of the graph.
     * @return number of vertices
     */
    public int numVertices() {
        return vertices.size();
    }
    /**
     * Reterun the object that has the value passed as its element
     * @param e element
     * @return object Vertex
     */
    public Vertex<E> getVertex(E e) {
        Vertex<E> aux = null;
        for (Vertex<E> vertex : this.vertices) {
            if (vertex.getElement().equals(e)) {
                aux = vertex;
                break;
            }
        }
        return aux;
    }
    /**
     * Do the Breadth-First Search
     * @param e the vertex that will start the search
     */
    public void BFS(E e) {
        ArrayList<Vertex<E>> marks = new ArrayList<>();
        ArrayList<Vertex<E>> toVisit = new ArrayList<>();
        Vertex<E> aux = this.getVertex(e);

        marks.add(aux);
        toVisit.add(aux);

        System.out.println(aux.getElement());

        while (toVisit.size() > 0) {
            Vertex<E> visited = toVisit.get(0);
            for (int i = 0; i < visited.getOutgoing().size(); i++) {
                Vertex<E> next = visited.getOutgoing().get(i).getDestiny();
                if (!marks.contains(next)) {
                    marks.add(next);
                    System.out.println(next.getElement());
                    toVisit.add(next);
                }
            }
            toVisit.remove(0);
        }
    }

    // Setters
    public void addVertex(E v) {
        this.vertices.add(new Vertex<>(v));
    }
    public void addEdge(E origin, E destiny) {
        Vertex<E> o = this.getVertex(origin);
        Vertex<E> d = this.getVertex(destiny);
        Edge<E> edge = new Edge<>(o, d);

        this.egdes.add(edge);

        o.addOutgoingEdge(edge);
        d.addIncomingEdge(edge);
    }
    public void removeEdge() {
    }
    public void removeVertex() {
    }
}


/**
 * Inner class Vertex
 * @param <E> the element type that the Vertex contains
 */
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
    public ArrayList<Edge<E>> getIncoming() {
        return incomingEdges;
    }
    public ArrayList<Edge<E>> getOutgoing() {
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


/**
 * Inner class Edge
 * @param <E> the element type that the Vertex contains
 */
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


