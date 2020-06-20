package Greedy;
import java.util.*;

/**
 * Given a weighted, undirected and connected graph. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
 * Expected Time Complexity: O(V2).
Expected Auxiliary Space: O(V).
 */
public class PrimsMinimumSpanningTree {
    static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph) {
        int sum = 0;
        // To assign a value to each vertex to pick up next. 
        int key[] = new int[V];
        boolean mstSet[] = new boolean[V];
        
        // Initially no node is included in MST, and all node values are false.
        for (int i=0; i<V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        
        // Make first one zero so that it can be picked up next. 
        key[0] = 0;
        
        for (int i=1; i<V; i++) {
            // Picks min valued node which is not yet included in MST. 
            int minNode = getMin(key, mstSet);
            
            // Include node into MST. 
            mstSet[minNode] = true;
            // Fetch adj list of minNode.
            ArrayList<Integer> adj = graph.get(minNode);

            // Check each vertex, if its adjacent to fetched min valued node, then update its value if there is a edge exists between minNode and v which cost is less than its current value.
            for (int v=0; v < V; v++) {
                if (mstSet[v] == false && key[v] > adj.get(v) && adj.get(v) != 0) {
                    key[v] = adj.get(v);
                }
            }
        }
        
        // Key includes each nodes values which are included in MST. Node values are nothing but just the minimum cost edge between the node and its connecting node in MST. 
        for (int i=0; i<V; i++) {
            sum += key[i];
        }
        
        // Return the sum of the MST edges.
        return sum;
    }
    

    // Get min valued node which is not included in MST and have less value than others.
    static int getMin(int key[], boolean mstSet[])
    {
        int min = Integer.MAX_VALUE, min_index = -1; 
        int n = key.length;
        
        for (int i=0; i<n; i++) {
            if (mstSet[i] == false && key[i] < min) {
                min = key[i];
                min_index = i;
            }
        }
        
        return min_index;
    }
}