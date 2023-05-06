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
* **_incomingEdges(v)_**: Returns an iteration of all incoming edges to vertex v. For an undirected graph.
* **_insertVertex(x)_**: Creates and returns a new Vertex storing element x.
* **_insertEdge(u, v, x)_**: Creates and returns a new Edge from vertex u to vertex v, storing element x.
* **_removeVertex(v)_**: Removes vertex v and all its incident edges from the graph.
* **_removeEdge(e)_**: Removes edge e from the graph.
