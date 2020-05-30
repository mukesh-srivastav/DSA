package Graph;
import java.util.*;
/**
 * In this article we will see another way to find the linear ordering of vertices in a directed acyclic graph (DAG). The approach is based on the below fact :

A DAG G has at least one vertex with in-degree 0 and one vertex with out-degree 0.
Proof: There’s a simple proof to the above fact is that a DAG does not contain a cycle which means that all paths will be of finite length. Now let S be the longest path from u(source) to v(destination). Since S is the longest path there can be no incoming edge to u and no outgoing edge from v, if this situation had occurred then S would not have been the longest path
=> indegree(u) = 0 and outdegree(v) = 0
https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/

Algorithm:
Steps involved in finding the topological ordering of a DAG:

Step-1: Compute in-degree (number of incoming edges) for each of the vertex present in the DAG and initialize the count of visited nodes as 0.

Step-2: Pick all the vertices with in-degree as 0 and add them into a queue (Enqueue operation)

Step-3: Remove a vertex from the queue (Dequeue operation) and then.

Increment count of visited nodes by 1.
Decrease in-degree by 1 for all its neighboring nodes.
If in-degree of a neighboring nodes is reduced to zero, then add it to the queue.
Step 5: Repeat Step 3 until the queue is empty.

Step 5: If count of visited nodes is not equal to the number of nodes in the graph then the topological sort is not possible for the given graph.
 */
public class TopologicalSortingKahnAlgorithm {
    static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
        Queue<Integer> q = new LinkedList<Integer>();
        int indegree[] = new int[N];
        
        // Traverse adjacency lists to fill indegrees of 
        // vertices. This step takes O(V+E) time  
        for (int i=0; i<N; i++) {
            
            for (int node: adj.get(i)) {
                indegree[node]++;
            }
        }
        
        // Create a queue and enqueue all vertices with 
        // indegree 0 
        for (int i=0; i<N; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        // Initialize count of visited vertices 
        int count = 0;
        
        // Create a array/vector to store result (A topological 
        // ordering of the vertices) 
        int res[] = new int[N];
        int i=0;
        
        while(q.isEmpty() == false) {
            
            // Extract front of queue (or perform dequeue) 
            // and add it to topological order 
            int ele = q.poll();
            res[i++] = ele;
            count++;
            
            // Iterate through all its neighbouring nodes 
            // of dequeued node u and decrease their in-degree 
            // by 1 
            for (int adjI = 0; adjI < adj.get(ele).size(); adjI++) {
                int adjEle = adj.get(ele).get(adjI);
                
                // If in-degree becomes zero, add it to queue 
                if (--indegree[adjEle] == 0) {
                    q.add(adjEle);
                }
            }
        }
        
        // Check if there was a cycle
        if (count != N)
            return new int[0];
        
        // Return topological order.
        return res;
    }
}