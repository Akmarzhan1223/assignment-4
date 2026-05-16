// DijkstraSearch.java
import java.util.*;

public class DijkstraSearch<V> extends Search<V> {
    private Map<Vertex<V>, Double> distances;
    
    public DijkstraSearch() {
        super();
        this.distances = new HashMap<>();
    }
    
    @Override
    public void search(WeightedGraph<V> graph, V startData) {
        clear();
        distances.clear();
        
        Vertex<V> start = graph.getVertex(startData);
        
        if (start == null) {
            return;
        }
        
        // Initialize distances
        for (Vertex<V> vertex : graph.getAllVertices()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        
        distances.put(start, 0.0);
        parent.put(start, null);
        
        PriorityQueue<VertexDistance<V>> pq = new PriorityQueue<>(
            Comparator.comparingDouble(VertexDistance::getDistance)
        );
        pq.add(new VertexDistance<>(start, 0.0));
        
        while (!pq.isEmpty()) {
            VertexDistance<V> currentVD = pq.poll();
            Vertex<V> current = currentVD.getVertex();
            double currentDist = currentVD.getDistance();
            
            if (visited.contains(current)) {
                continue;
            }
            
            visited.add(current);
            
            for (Map.Entry<Vertex<V>, Double> entry : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = entry.getKey();
                double weight = entry.getValue();
                double newDist = currentDist + weight;
                
                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    parent.put(neighbor, current);
                    pq.add(new VertexDistance<>(neighbor, newDist));
                }
            }
        }
    }
    
    public double getDistance(V vertexData) {
        Vertex<V> vertex = new Vertex<>(vertexData);
        return distances.getOrDefault(vertex, Double.POSITIVE_INFINITY);
    }
    
    public Map<Vertex<V>, Double> getAllDistances() {
        return new HashMap<>(distances);
    }
    
    // Helper class for priority queue
    private static class VertexDistance<V> {
        private final Vertex<V> vertex;
        private final double distance;
        
        public VertexDistance(Vertex<V> vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        
        public Vertex<V> getVertex() {
            return vertex;
        }
        
        public double getDistance() {
            return distance;
        }
    }
}