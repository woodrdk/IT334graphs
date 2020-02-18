package graphs;

public interface IGraph<V> {

    // insertion into the graph
    boolean addVertex(V vertex);
    boolean addVertex(V... vertices);
    boolean addEdge(V source, V destination, double weight);
    boolean addEdges(/* TODO */);

    // detext existing elements
    boolean hasVertex(V vertex);
    boolean hasEdge(V source, V destination);

    // number of elements
    int vertexSize();
    int edgeSize();

    // remove elements
    boolean removeVertex(V vertex);
    boolean removeEdge(V source, V destination);

    // interesting methods
    boolean areAdjacent(V first, V second);
    boolean updateEdgeWeight(V source, V destination, double newWeight);
}
