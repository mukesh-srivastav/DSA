package Graph;
import java.util.*;

/**
 * Given a Undirected Graph. Check whether it contains a cycle or not. 
 * User task:
You don't need to read input or print anything. Your task is to complete the function isCyclic which takes the Graph and the number of vertices as inputs and returns true if the given undirected graph contains any cycle. Else, it returns false.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).
Graph doesn't contain multiple edges and self loops.
Check dry-run diagram to understand this better here:
https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
 */
class DetectCycleUndirectedGraph
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V)
    {
       boolean visited[] = new boolean[V];
       
       // Call the recursive helper function to detect cycle in 
        // different DFS trees
        for (int i=0; i<V; i++) {
            if (visited[i] == false) {
              if (isCyclicUtil(i, g, visited, -1))
                    return true;
            }
        }
    
       return false;
    }
    
    static boolean isCyclicUtil(int v,ArrayList<ArrayList<Integer>> g, boolean []visited, int parent)
    {
        // Mark the current node as visited 
        visited[v] = true;
        
        for (int i=0; i<g.get(v).size(); i++) {
            int adj = g.get(v).get(i);
            
            // If an adjacent is not visited, then recur for that 
            // adjacent 
            if (visited[adj] == false) {
                if (isCyclicUtil(adj, g, visited, v))
                    return true;
            } 
            // If an adjacent is visited and not parent of current 
            // vertex, then there is a cycle.
            else if (adj != parent) {
                return true;
            }
        }
        
        return false;
    }
}