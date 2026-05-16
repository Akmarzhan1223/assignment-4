// Search.java (Abstract base class)
import java.util.*;

public abstract class Search<V> {
    protected Set<Vertex<V>> visited;
    protected Map<Vertex<V>, Vertex<V>> parent;
    
    public Search() {
        this.visited = new HashSet<>();
        this.parent = new HashMap<>();
    }
    
    public abstract void search(WeightedGraph<V> graph, V start);
    
    public List<V> getPath(V destination) {
        List<V> path = new ArrayList<>();
        Vertex<V> target = new Vertex<>(destination);
        
        if (!parent.containsKey(target)) {
            return path;
        }
        
        Stack<V> stack = new Stack<>();
        Vertex<V> current = target;
        
        while (current != null) {
            stack.push(current.getData());
            current = parent.get(current);
        }
        
        while (!stack.isEmpty()) {
            path.add(stack.pop());
        }
        
        return path;
    }
    
    public boolean visited(V vertex) {
        return visited.contains(new Vertex<>(vertex));
    }
    
    public void clear() {
        visited.clear();
        parent.clear();
    }
}