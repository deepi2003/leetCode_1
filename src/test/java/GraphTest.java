import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class GraphTest {
    @Test
    public void test(){

        ArrayList<GraphNode> nodes = new ArrayList<>();
        nodes.add(new GraphNode("A", 0));
        nodes.add(new GraphNode("B", 1));
        nodes.add(new GraphNode("C", 2));
        nodes.add(new GraphNode("D", 3));
        nodes.add(new GraphNode("E", 4));
        Graph g = new Graph(nodes);
        g.addDirectedEdge(0,1);
        g.addDirectedEdge(0,2);
        g.addDirectedEdge(1,2);
        g.addDirectedEdge(2,4);
        g.addDirectedEdge(1,3);
        g.addDirectedEdge(3,4);
        System.out.println(" DFS VISIT::  ");
        g.dfsVisit();


        ArrayList<GraphNode> nodes1 = new ArrayList<>();
        nodes1.add(new GraphNode("A", 0));
        nodes1.add(new GraphNode("B", 1));
        nodes1.add(new GraphNode("C", 2));
        nodes1.add(new GraphNode("D", 3));
        nodes1.add(new GraphNode("E", 4));
        Graph g1 = new Graph(nodes1);
        g1.addDirectedEdge(0,1);
        g1.addDirectedEdge(0,2);
        g1.addDirectedEdge(1,2);
        g1.addDirectedEdge(2,4);
        g1.addDirectedEdge(1,3);
        g1.addDirectedEdge(3,4);

        System.out.println(" BFS VISIT::  ");
        g1.bfsVisit();

    }

}