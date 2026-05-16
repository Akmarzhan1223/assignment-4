// WeightedGraph.java
import java.util.*;

public class WeightedGraph<V> {
    private Map<V, Vertex<V>> vertices;
    
    public WeightedGraph() {
        this.vertices = new HashMap<>();
    }
    
    public void addVertex(V data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
    }
    
    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }
    
    public void addEdge(V sourceData, V destData, double weight) {
        Vertex<V> source = vertices.get(sourceData);
        Vertex<V> dest = vertices.get(destData);
        
        if (source == null || dest == null) {
            throw new IllegalArgumentException("Vertex not found");
        }
        
        source.addAdjacentVertex(dest, weight);
    }
    
    public void addUndirectedEdge(V sourceData, V destData, double weight) {
        addEdge(sourceData, destData, weight);
        addEdge(destData, sourceData, weight);
    }
    
    public Collection<Vertex<V>> getAllVertices() {
        return vertices.values();
    }
    
    public boolean hasVertex(V data) {
        return vertices.containsKey(data);
    }
    
    public boolean hasEdge(V sourceData, V destData) {
        Vertex<V> source = vertices.get(sourceData);
        Vertex<V> dest = vertices.get(destData);
        
        if (source == null || dest == null) {
            return false;
        }
        
        return source.hasAdjacentVertex(dest);
    }
    
    public double getEdgeWeight(V sourceData, V destData) {
        Vertex<V> source = vertices.get(sourceData);
        Vertex<V> dest = vertices.get(destData);
        
        if (source == null || dest == null) {
            return Double.POSITIVE_INFINITY;
        }
        
        return source.getWeightTo(dest);
    }
    
    public int getVertexCount() {
        return vertices.size();
    }
}