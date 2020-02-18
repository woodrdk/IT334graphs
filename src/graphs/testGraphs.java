package graphs;

public class testGraphs {
    public static void main(String[] args){
        IGraph<Character> letterGraph = new DirectedALGraph<>();

        // add single elements
        letterGraph.addVertex('a');
        letterGraph.addVertex('b');
        letterGraph.addVertex('c');

        // add multiple elements
        letterGraph.addVertex('d','e','f','g','h');


    }
}
