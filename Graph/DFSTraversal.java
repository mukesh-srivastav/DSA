package Graph;
import java.util.*;

/**
 * Given a connected undirected graph. Perform a Depth First Traversal of the graph.
Note: Use recursive approach.
You don't need to read input or print anything. Your task is to complete the function dfs() which takes the Graph and the number of vertices as inputs and returns a list containing the DFS Traversal of the graph starting from the 0th node.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).
Graph doesn't contain multiple edges and self loops.
 */
public class DFSTraversal {
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N)
    {
       boolean visited[] = new boolean[N];
       ArrayList<Integer> res = new ArrayList<Integer>();
       dfsUtil(0, g, visited, res);
       
       return res;
    }
    
    static void dfsUtil(int v, ArrayList<ArrayList<Integer>> g, boolean []visited, ArrayList<Integer> res)
    {
        
        if (visited[v] == false) {
            res.add(v);
            visited[v] = true;
            
            for (int i=0; i<g.get(v).size(); i++) {
                dfsUtil(g.get(v).get(i), g, visited, res);
            }
        }
    }   
}