package Graph;
import java.util.*;

/**
 * Given a graph of V nodes represented in the form of the adjacency matrix. The task is to find the shortest distance of all the vertex's from the source vertex.
 */
public class DijkstraShortestPathAlgorithm {
    static int[] dijkstra(ArrayList<ArrayList<Integer>> g, int src, int V)
    {
        int dist[] = new int[V]; // The output array. dist[i] will hold 
        // the shortest distance from src to i

        // sptSet[i] will true if vertex i is included in shortest 
        // path tree or shortest distance from src to i is finalized 
        boolean spt_set[] = new boolean[V];
        
        for (int i=0; i<V; i++) {
            dist[i] = Integer.MAX_VALUE;
            spt_set[i] = false;
        }
        
        dist[src] = 0;
        
        for (int i=0; i<V-1; i++) {
            // Pick the minimum distance vertex from the set of vertices 
            // not yet processed. u is always equal to src in first 
            // iteration. 
            int u = minDistance(dist, spt_set);
            
            spt_set[u] = true;
            
            // Update dist value of the adjacent vertices of the 
            // picked vertex. 
            for (int v=0; v<V; v++) {
                int adj = g.get(u).get(v);
                
                // Update dist[v] only if is not in sptSet, there is an 
                // edge from u to v, and total weight of path from src to 
                // v through u is smaller than current value of dist[v] 
                if (spt_set[v] == false && dist[u] != Integer.MAX_VALUE && adj != 0 && dist[u] + adj < dist[v]) {
                    dist[v] = dist[u] + adj;
                }
            }
        }
        
        return dist;
    }
    
    // A utility function to find the vertex with minimum distance value, 
    // from the set of vertices not yet included in shortest path tree 
    static int minDistance(int []dist, boolean []spt_set) {
        
        int min_index = -1, min = Integer.MAX_VALUE;
        
        for (int i=0; i<dist.length; i++) {
            if (spt_set[i] == false && dist[i] <= min) {
                min = dist[i];
                min_index = i;
            }
        }
        
        return min_index;
    }
}