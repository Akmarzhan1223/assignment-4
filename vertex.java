// Vertex.java
import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;
    
    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }
    
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }
    
    public void removeAdjacentVertex(Vertex<V> destination) {
        adjacentVertices.remove(destination);
    }
    
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }
    
    public V getData() {
        return data;
    }
    
    public void setData(V data) {
        this.data = data;
    }
    
    public double getWeightTo(Vertex<V> vertex) {
        return adjacentVertices.getOrDefault(vertex, Double.POSITIVE_INFINITY);
    }
    
    public boolean hasAdjacentVertex(Vertex<V> vertex) {
        return adjacentVertices.containsKey(vertex);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) obj;
        return data.equals(vertex.data);
    }
    
    @Override
    public int hashCode() {
        return data.hashCode();
    }
    
    @Override
    public String toString() {
        return "Vertex{" + data + "}";
    }
}