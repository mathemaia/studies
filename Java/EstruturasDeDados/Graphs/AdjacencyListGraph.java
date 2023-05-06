package AlestII.Graphs;

import java.util.ArrayList;

/**
 * This class implements a Graph using the Adjacency List concept.
 * @author Matheus Maia
 * @version 06-05-2023
 */

public class AdjacencyListGraph {
    /**
     * Inner class that implements the vertices of the graph
     */
    private class Vertex {
        // Identification number of the vertex
        int id;
    }

    // Parameters
    ArrayList<Vertex> verticesList;
    int numEdges;

    // Setters


    // Getters
    /**
     * Return the number of vertices of the graph
     * @RunningTime O(1)
     * @return number of vertices
     */
    public int numVertices() {
        return verticesList.size();
    }
    /**
     * Return the number of edges of the graph
     * @RunningTime O(1)
     * @return number of edges
     */
    public int numEdges() {
        return numEdges;
    }
    /**
     * Return an array of objects (vertices)
     * @RunningTime O(n)
     * @return array of vertices
     */
    public Vertex[] vertices() {
        Vertex[] aux = new Vertex[verticesList.size()];
        return verticesList.toArray(aux);
    }
    public int edges() {
        return 0;
    }
    public int endVertices() {
        return 0;
    }
    public int opposite() {

    }

}
