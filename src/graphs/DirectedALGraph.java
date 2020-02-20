package graphs;

import java.util.HashMap;
import java.util.Map;

public class DirectedALGraph<V> implements IGraph<V> {

    //fields
    private Map<V, Node> adjacencyList;

    public DirectedALGraph() {
        adjacencyList= new HashMap<>();
    }

    @Override
    public void addVertex(V vertex) {
        // precondition
        if(hasVertex(vertex)){
            throw new IllegalArgumentException("Vertex is already in the graph");
        }
        else{
            // insert new vertex
            adjacencyList.put(vertex, null);
        }
    }

    @Override
    public void addVertex(V... vertices) {
        for(V vertex: vertices){
            addVertex(vertex);
        }
    }

    @Override
    public void addEdge(V source, V destination, double weight) {
        if(!hasVertex(source) || !hasVertex(destination)){ // make sure both vertices exist
            throw new IllegalArgumentException("Source or destination does not exist in the group");
        }
        else if(source.equals(destination)){ // check for a self loop
            throw new IllegalArgumentException("No self loops allowed");
        }
        else if(hasEdge(source, destination)){
            throw new IllegalArgumentException("Edge already exists");
        }

        Node first = adjacencyList.get(source);
        if(first == null ){ // the first incident edge
            // put the edge in the map
            adjacencyList.put(source, new Node(destination));
        }
        else{ // place the node at the start of the linked list
            Node newNode = new Node(destination, first);
            adjacencyList.put(source, newNode);

             // or
            // adjacencyList.put(source, new Node(destination, first));
        }
    }

    @Override
    public void addEdges() {

    }

    @Override
    public boolean hasVertex(V vertex) {
        return adjacencyList.containsKey(vertex);
    }

    @Override
    public boolean hasEdge(V source, V destination) {
        return false;
    }

    @Override
    public int vertexSize() {
        return adjacencyList.size();
    }

    @Override
    public int edgeSize() {
        return 0;
    }

    @Override
    public boolean removeVertex(V vertex) {
        return false;
    }

    @Override
    public boolean removeEdge(V source, V destination) {
        return false;
    }

    @Override
    public boolean areAdjacent(V first, V second) {
        return false;
    }

    @Override
    public boolean updateEdgeWeight(V source, V destination, double newWeight) {
        return false;
    }


    public class edge{
        private V source;
        private V destination;
        private double weight;
    }

    private class Node{
        private V vertex;
        private Node next;

        public Node(V vertex, Node next) {
            this.vertex = vertex;
            this.next = next;
        }

        public Node(V vertex) {
            this.vertex = vertex;
        }
    }
}
