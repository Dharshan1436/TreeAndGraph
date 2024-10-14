package treeAndGraph.Graph;

import java.util.*;

class Graph<T> {
    private Map<T, List<T>> adjList = new HashMap<>();

    
    public void addNode(T node) {
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    
    public void addEdge(T source, T destination) {
        adjList.get(source).add(destination);
    }

    
    public void bfs(T startNode) {
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();

        visited.add(startNode);
        queue.add(startNode);

        while (!queue.isEmpty()) {
            T currentNode = queue.poll();
            System.out.print(currentNode + " ");

            
            for (T neighbor : adjList.get(currentNode)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

  
    public void dfs(T startNode) {
        Set<T> visited = new HashSet<>();
        dfsHelper(startNode, visited);
    }

   
    private void dfsHelper(T node, Set<T> visited) {
        visited.add(node);
        System.out.print(node + " ");

        
        for (T neighbor : adjList.get(node)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    
    public void displayGraph() {
        for (T node : adjList.keySet()) {
            System.out.print(node + ": ");
            for (T neighbor : adjList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

public class DirectedGraph {
    public static void main(String[] args) {
       
        Graph<String> graph = new Graph<>();

        
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addNode("F");
        graph.addNode("G");

        
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("B", "E");
        graph.addEdge("C", "F");
        graph.addEdge("E", "G");
        graph.addEdge("D", "F");
        graph.addEdge("F", "G");

        
        graph.displayGraph();
        
        
        System.out.println("BFS Traversal starting from node A:");
        graph.bfs("A");
        
       
        System.out.println("\nDFS Traversal starting from node A:");
        graph.dfs("A");
    }
}
