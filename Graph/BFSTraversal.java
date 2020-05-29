package Graph;

import java.util.*;
/**
 * Given a directed graph. The task is to do Breadth First Search of this graph.
 * You don't need to read input or print anything. Your task is to complete the function bfs() takes the Graph and the number of vertices as its input and returns a list containing the BFS traversal of the graph starting from the 0th vertex.

Expected Time Complexity: O(V + E).
Expected Auxiliary Space: O(V).
 *  g[]: adj list of the graph
 *  N : number of vertices
 * Graph doesn't contain multiple edges and self loops.
 */
public class BFSTraversal {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        boolean visited[] = new boolean[N];
        
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()) {
            int v = q.remove();
            res.add(v);
            
            for (int i=0; i<g.get(v).size(); i++) {
                int adj = g.get(v).get(i);
                if (visited[adj] == false) {
                    visited[adj] = true;
                    q.add(adj);
                }
            }
        }
        
        return res;
    }
}
