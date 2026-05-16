// Main.java - Example usage
public class Main {
    public static void main(String[] args) {
        // Create a weighted graph
        WeightedGraph<String> graph = new WeightedGraph<>();
        
        // Add vertices
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        
        // Add directed edges
        graph.addEdge("A", "B", 4.0);
        graph.addEdge("A", "C", 2.0);
        graph.addEdge("B", "C", 1.0);
        graph.addEdge("B", "D", 5.0);
        graph.addEdge("C", "D", 8.0);
        graph.addEdge("C", "E", 10.0);
        graph.addEdge("D", "E", 2.0);
        graph.addEdge("E", "D", 6.0);
        
        // Test BFS
        System.out.println("=== BFS from A ===");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>();
        bfs.search(graph, "A");
        
        System.out.println("Path from A to E: " + bfs.getPath("E"));
        System.out.println("Visited A: " + bfs.visited("A"));
        System.out.println("Visited D: " + bfs.visited("D"));
        
        // Test Dijkstra
        System.out.println("\n=== Dijkstra from A ===");
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>();
        dijkstra.search(graph, "A");
        
        System.out.println("Shortest path from A to E: " + dijkstra.getPath("E"));
        System.out.println("Distance from A to E: " + dijkstra.getDistance("E"));
        System.out.println("Distance from A to D: " + dijkstra.getDistance("D"));
        System.out.println("Distance from A to B: " + dijkstra.getDistance("B"));
        System.out.println("Distance from A to C: " + dijkstra.getDistance("C"));
        
        // Test undirected graph
        System.out.println("\n=== Undirected Graph Example ===");
        WeightedGraph<String> undirectedGraph = new WeightedGraph<>();
        undirectedGraph.addVertex("X");
        undirectedGraph.addVertex("Y");
        undirectedGraph.addVertex("Z");
        
        undirectedGraph.addUndirectedEdge("X", "Y", 3.0);
        undirectedGraph.addUndirectedEdge("X", "Z", 5.0);
        undirectedGraph.addUndirectedEdge("Y", "Z", 2.0);
        
        DijkstraSearch<String> dijkstraUndirected = new DijkstraSearch<>();
        dijkstraUndirected.search(undirectedGraph, "X");
        
        System.out.println("Shortest path from X to Z: " + dijkstraUndirected.getPath("Z"));
        System.out.println("Distance from X to Z: " + dijkstraUndirected.getDistance("Z"));
    }
}