// BreadthFirstSearch.java
import java.util.*;

public class BreadthFirstSearch<V> extends Search<V> {
    
    @Override
    public void search(WeightedGraph<V> graph, V startData) {
        clear();
        Vertex<V> start = graph.getVertex(startData);
        
        if (start == null) {
            return;
        }
        
        Queue<Vertex<V>> queue = new LinkedList<>();
        visited.add(start);
        parent.put(start, null);
        queue.add(start);
        
        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            
            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
    }
}