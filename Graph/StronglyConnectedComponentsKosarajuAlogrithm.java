package Graph;
import java.util.*;

/**
 * Count number of SSC in given graph of N nodes.
 * https://www.geeksforgeeks.org/strongly-connected-components/
 * The above algorithm is DFS based. It does DFS two times. DFS of a graph produces a single tree if all vertices are reachable from the DFS starting point. Otherwise DFS produces a forest. So DFS of a graph with only one SCC always produces a tree. The important point to note is DFS may produce a tree or a forest when there are more than one SCCs depending upon the chosen starting point.
 * 
 */
public class StronglyConnectedComponentsKosarajuAlogrithm {
    public int kosaraju(ArrayList<ArrayList<Integer>> adj, int N)
    {
        Stack<Integer> stack = new Stack<Integer>();
        boolean []visited = new boolean[N];
        
        // First trace every node as per its finish time in stack.
        for (int i=0; i<N; i++) {
            if (visited[i] == false)
                dfs(i, stack, visited, adj, true);
        }
        
        // Now reverse the adj list so that directions will be reversed. 
        adj = getTranspose(adj);
        
        int sccCount = 0;
        
        Arrays.fill(visited, false);
        
        while (stack.isEmpty() == false) {
            int v = (int)stack.pop();
            
            if (visited[v] == false) {
                dfs(v, stack, visited, adj, false);
                sccCount++;
            }
        }
        
        return sccCount;
    }
    
    public void dfs(int v, Stack<Integer> stack, boolean visited[], ArrayList<ArrayList<Integer>> adj, boolean addToStack) {
        visited[v] = true;
        
        for (int i=0; i<adj.get(v).size(); i++) {
            if (visited[adj.get(v).get(i)] == false)
                dfs(adj.get(v).get(i), stack, visited, adj, addToStack);
        }
        
        if (addToStack) {
            stack.push(v);    
        }
    }
    
    public ArrayList<ArrayList<Integer>> getTranspose(ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        for (int i=0; i<adj.size(); i++) {
            res.add(new ArrayList<Integer>());
        }
        
        for (int i=0; i<adj.size(); i++) {
            for (int j=0; j<adj.get(i).size(); j++) {
                res.get(adj.get(i).get(j)).add(i);
            }
        }
        
        return res;
    }
}