package graphs;

import java.util.List;

public class testGraphs {
    public static void main(String[] args){
        IGraph<Character> letterGraph = new DirectedALGraph<>();

        // add single elements
        letterGraph.addVertex('a');
        letterGraph.addVertex('b');
        letterGraph.addVertex('c');

        // add multiple elements
        letterGraph.addVertex('d','e','f','g','h');
        letterGraph.addEdge('a','b',1.0);
        letterGraph.addEdge('b','c',1.0);
        letterGraph.addEdge('c','b',1.0);

        letterGraph.addEdges(
                new DirectedALGraph.Edge<>('d','c',1.0),
                new DirectedALGraph.Edge<>('a','d',1.0),
                new DirectedALGraph.Edge<>('g','c',1.0),
                new DirectedALGraph.Edge<>('b','f',1.0),
                new DirectedALGraph.Edge<>('f','e',1.0),
                new DirectedALGraph.Edge<>('e','g',1.0),
                new DirectedALGraph.Edge<>('g','f',1.0)
        );

        System.out.println("Does an edge exist between 'a' & 'b'? " + letterGraph.hasEdge('a', 'b'));
        //System.out.println("There are " + letterGraph.edgeSize('a') + " edges on letter 'a'.");

        /*
           // add single elements
        System.out.println( letterGraph.addVertex('a'));
        System.out.println(letterGraph.addVertex('b'));
        System.out.println(letterGraph.addVertex('c'));

        // add multiple elements
        System.out.println(letterGraph.addVertex('d','e','f','g','h'));

         */
        System.out.println("There are " + letterGraph.vertexSize() + " vertexes in this graphs.");

        // test dfs() and see if it works
        List<Character> dfs = letterGraph.dfs('a');
        for(char character : dfs){
            System.out.println(character);
        }

        // test dfs() and see if it works
        List<Character> dfs2 = letterGraph.dfsOverComponents();
        for(char character : dfs2){
            System.out.println(character);
        }
    }
}
