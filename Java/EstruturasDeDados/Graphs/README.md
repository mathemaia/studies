## Description of all methods
**numVertices()**: Returns the number of vertices of the graph.
**vertices()**: Returns an iteration of all the vertices of the graph.
**numEdges()**: Returns the number of edges of the graph.
**edges()**: Returns an iteration of all the edges of the graph.
**getEdge(u, v)**: Returns the edge from vertex u to vertex v, if one exists; otherwise return null. For an undirected graph, there is no difference between getEdge(u, v) and getEdge(v, u).
**endVertices(e)**: Returns an array containing the two endpoint vertices of edge e. If the graph is directed, the first vertex is the origin and the second is the destination.
**opposite(v, e)**: For edge e incident to vertex v, returns the other vertex of the edge; an error occurs if e is not incident to v.
**outDegree(v)**: Returns the number of outgoing edges from vertex v.
**inDegree(v)**: Returns the number of incoming edges to vertex v. For an undirected graph, this returns the same value as does outDegree(v).
**outgoingEdges(v)**: Returns an iteration of all outgoing edges from vertex v.
**incomingEdges(v)**: Returns an iteration of all incoming edges to vertex v. For an undirected graph, this returns the same collection as does outgoingEdges(v).
**addVertex(x)**: Creates and returns a new Vertex storing element x.
**removeVertex(v)**: Removes vertex v and all its incident edges from the graph.
**addEdge(u, v, x)**: Creates and returns a new Edge from vertex u to vertex v, storing element x; an error occurs if there already exists an edge from u to v.
**removeEdge(e)**: Removes edge e from the graph