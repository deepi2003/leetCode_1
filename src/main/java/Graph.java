import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    int[][] adjacencyMatrix;

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void addDirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
    }

    public void dfsVisit() {
        Stack<GraphNode> visitList = new Stack<>();
        visitList.add(nodeList.get(0));
        while (!visitList.isEmpty()) {
            GraphNode currentNode = visitList.pop();
            System.out.println(currentNode.name + " ");
            ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
           currentNode.isVisited = true;
            neighbors.parallelStream().forEach(node -> {
                        if (!node.isVisited && !visitList.contains(node))
                            visitList.push(node);
                    }
            );
        }
    }

    public void bfsVisit() {
        Queue<GraphNode> visitList = new LinkedList<>();
        visitList.add(nodeList.get(0));
        while (!visitList.isEmpty()) {
            GraphNode currentNode = visitList.remove();
            System.out.println(currentNode.name + " ");
            ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
            currentNode.isVisited = true;
            neighbors.parallelStream().forEach(node -> {
                        if (!node.isVisited && !visitList.contains(node))
                            visitList.add(node);
                    }
            );
        }
    }


    public ArrayList<GraphNode> getNeighbors(GraphNode node) {
        ArrayList<GraphNode> neighbors = new ArrayList<>();
        int nodeIndex = nodeList.indexOf(node);
        for (int i = 0; i < nodeList.size(); i++) {
            if (adjacencyMatrix[nodeIndex][i] == 1)
                neighbors.add(nodeList.get(i));
        }
        return neighbors;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + " ");
        }
        s.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            s.append(nodeList.get(i).name + ": ");
            for (int j : adjacencyMatrix[i]) {
                s.append((j) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

}
