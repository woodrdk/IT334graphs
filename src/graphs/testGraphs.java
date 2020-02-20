package graphs;

public class testGraphs {
    public static void main(String[] args){
        IGraph<Character> letterGraph = new DirectedALGraph<>();

        // add single elements
        System.out.println( letterGraph.addVertex('a'));
        System.out.println(letterGraph.addVertex('b'));
        System.out.println(letterGraph.addVertex('c'));

        // add multiple elements
        System.out.println(letterGraph.addVertex('d','e','f','g','h'));

        System.out.println(letterGraph.vertexSize());
    }
}
