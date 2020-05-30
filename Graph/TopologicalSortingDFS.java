package Graph;
import java.util.*;

/**
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
 * https://www.geeksforgeeks.org/topological-sorting/
 */
    
public class TopologicalSortingDFS {
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
        Stack<Integer> stack = new Stack<Integer>();
        boolean visited[] = new boolean[N];
        
        // traverse DFS starting from every node. 
        for (int i=0; i<N; i++) {
            if (visited[i] == false) {
                dfs(i, adj, visited, stack);        
            }
        }
        
        // print stack's content in reverse order i.e. stack[1,2,3,4] = res[4,3,2,1]
        int res[] = new int[N];
        int i=0;
        while(stack.isEmpty() == false) {
            res[i++] = stack.pop();
        }
        
        return res;
    }
    
    static void dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        
        visited[v] = true;
        
        for (int i=0; i<adj.get(v).size(); i++) {
            int nextAdj = adj.get(v).get(i);
            if (visited[nextAdj] == false) {
                dfs(nextAdj, adj, visited, stack);
            }
        }
        // Enter current element after all its adjacent elements are entered in Stack, so that it can be pulled out before than them.
        stack.push(v);
    }
}