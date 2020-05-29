package Graph;
import java.util.*;
/**
 * Given a Directed Graph. Check whether it contains any cycle or not.\
 * You don't need to read input or print anything. Your task is to complete the function isCyclic which takes the Graph and the number of vertices and inputs and returns true if the given directed graph contains a cycle. Else, it returns false.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).
 */
public class DetectCycleDirectedGraphUsingDFS {
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V)
    {
        boolean visited[] = new boolean[V];
        boolean inTheCall[] = new boolean[V];
        
        for (int i = 0 ; i< V; i++) {
            if (visited[i] == false) {
                if (isCyclicUtil(i, adj, visited, inTheCall))
                    return true;
            }
        }
        
        return false;
    }
    
    static boolean isCyclicUtil(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean [] inTheCall)
    {
        visited[v] = true;
        inTheCall[v] = true;
        
        for (int i=0; i<adj.get(v).size(); i++) {
            int adjV = adj.get(v).get(i);
            if (visited[adjV] == false) {
                if (isCyclicUtil(adjV, adj, visited, inTheCall)) {
                    return true;
                }
            }
            
            else if (inTheCall[adjV]) {
                return true;
            }
        }
        
        inTheCall[v] = false;
        return false;
    }
}