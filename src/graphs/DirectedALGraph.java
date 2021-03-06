package graphs;

import org.w3c.dom.Node;

import java.util.*;

public class DirectedALGraph<V> implements IGraph<V> {

    //fields
    private Map<V, Node> adjacencyList;

    public List<V> dfs(V source)
    {
        if(!hasVertex(source)){
            throw new IllegalArgumentException("Source vertex does not exist");
        }
        // create some helper data structures
        List<V> results = new ArrayList<>();
        Set<V> seen = new HashSet<>();

        dfs(source,results, seen);
        return results;
    }
    // this method wil be called when we want to visit a new vertex (called current)
    private void dfs(V current, List<V> results, Set<V> seen) {
        // check first that I have not seen this vertex
        if (!seen.contains(current)) {
            results.add(current);
            seen.add(current);

            // check adjacent vertices
            Node list = adjacencyList.get(current);
            while (list != null) {
                // check the adjacent vertex
                dfs(list.vertex, results, seen);
                // move to the next
                list = list.next;
            }
        }

    }
    public List<V> dfsOverComponents(){
        // create some helper data structures
        List<V> results = new ArrayList<>();
        Set<V> seen = new HashSet<>();
        for(V vertex: adjacencyList.keySet()){
            dfs(vertex, results, seen);
        }
        return results;
    }
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
    public void addEdges(Edge<V>... edges) {
        for(Edge<V> edge : edges){
            addEdge(edge.source, edge.destination, edge.weight);
        }
    }

    @Override
    public boolean hasVertex(V vertex) {
        return adjacencyList.containsKey(vertex);
    }

    @Override
    public boolean hasEdge(V source, V destination) {
        Node first = adjacencyList.get(source);

        if (first == null){
            return false;
        }
        else{
            while(first != null && !first.vertex.equals(destination)){
                first = first.next;
            }
        }

        return first != null && first.vertex.equals(destination);
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


    public static class Edge<V>{
        private V source;
        private V destination;
        private double weight;

        public Edge(V source, V destination, double weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        public V getSource() {
            return source;
        }

        public void setSource(V source) {
            this.source = source;
        }

        public V getDestination() {
            return destination;
        }

        public void setDestination(V destination) {
            this.destination = destination;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }
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
