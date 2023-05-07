# Methods descriptions
* **_numVertices()_**: Returns the number of vertices of the graph.
* **_vertices()_**: Returns an iteration of all the vertices of the graph.
* **_numEdges()_**: Returns the number of edges of the graph.
* **_edges()_**: Returns an iteration of all the edges of the graph.
* **_getEdge(u, v)_**: Returns the edge from vertex u to vertex v, if one exists; otherwise return null.
* **_endVertices(e)_**: Returns an array containing the two endpoint vertices of edge e.
* **_opposite(v, e)_**: For edge e incident to vertex v, returns the other vertex of the edge.
* **_outDegree(v)_**: Returns the number of outgoing edges from vertex v.
* **_inDegree(v)_**: Returns the number of incoming edges to vertex v. For an undirected graph.
* **_outgoingEdges(v)_**: Returns an iteration of all outgoing edges from vertex v.
* **_incomingEdges(v)_**: Returns an iteration of all incoming edges to vertex v.
* **_insertVertex(x)_**: Creates and returns a new Vertex storing element x.
* **_insertEdge(u, v, x)_**: Creates and returns a new Edge from vertex u to vertex v, storing element x.
* **_removeVertex(v)_**: Removes vertex v and all its incident edges from the graph.
* **_removeEdge(e)_**: Removes edge e from the graph.

# Big O
|**Method**|**Adj. List**|**Adj. Matrix**|
|--------|-----------|-------------|
|numVertices()|$O(1)$|$O(1)$|
|numEdges()|$O(1)$|$O(1)$|
|vertices()|$O(n)$|$O(n)$|
|edges()|$O(m)$|$O(m)$|
|getEdge(u, v)|$O(min(d_u, d_v)$|$O(1)$|
|outDegree(v)|$O(1)$|$O(n)$|
|inDegree(v)|$O(1)$|$O(n)$|
|outgoingEdges(v)|$O(d_v)$|$O(n)$|
|incomingEdges(v)|$O(d_v)$|$O(n)$|
|addVertex(v, elem)|$O(1)$|$O(n^2)$|
|removeVertex(v)|$O(d_v)$|$O(n^2)$|
|addEdge(u, v)|$O(1)$|$O(1)$|
|removeEdge(e)|$O(1)$|$O(1)$|
