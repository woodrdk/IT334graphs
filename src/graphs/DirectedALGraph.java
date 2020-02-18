package graphs;

public class DirectedALGraph implements IGraph {


    @Override
    public boolean addVertex(Object vertex) {
        return false;
    }

    @Override
    public boolean addVertex(Object[] vertices) {
        return false;
    }

    @Override
    public boolean addEdge(Object source, Object destination, double weight) {
        return false;
    }

    @Override
    public boolean addEdges() {
        return false;
    }

    @Override
    public boolean hasVertex(Object vertex) {
        return false;
    }

    @Override
    public boolean hasEdge(Object source, Object destination) {
        return false;
    }

    @Override
    public int vertexSize() {
        return 0;
    }

    @Override
    public int edgeSize() {
        return 0;
    }

    @Override
    public boolean removeVertex(Object vertex) {
        return false;
    }

    @Override
    public boolean removeEdge(Object source, Object destination) {
        return false;
    }

    @Override
    public boolean areAdjacent(Object first, Object second) {
        return false;
    }

    @Override
    public boolean updateEdgeWeight(Object source, Object destination, double newWeight) {
        return false;
    }
}
