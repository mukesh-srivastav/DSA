package Graph;

import java.util.*;

public class AllPairsShortestPathFloydWarshall {
    public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		    int n = sc.nextInt();
		    int a[][] = new int[n][n];
		    
		    for(int i=0; i<n; i++) {
		        for(int j=0; j<n; j++) {
	                a[i][j] = sc.nextInt();
		        }
		    }
		    
		    a = allPairShortestPaths(a,n);
		    
		    for(int i=0; i<n; i++) {
		        for(int j=0; j<n; j++) {
		            int r = a[i][j];
		            if (r >= 10000000)
		                System.out.print("INF" + " ");
		            else
		                System.out.print(a[i][j] + " ");
		        }
		        System.out.println();
		    }
		    
		}
		sc.close();
	}
	
	static int[][] allPairShortestPaths(int [][]adj, int n)
	{
	    
	    int res[][] = new int[n][n];
	    /* Initialize the solution matrix same as input graph matrix. 
           Or we can say the initial values of shortest distances 
           are based on shortest paths considering no intermediate 
           vertex. */

	    for (int i=0; i<n; i++) {
	        for (int j=0; j<n; j++) {
	            res[i][j] = adj[i][j];        
	        }
	    }
	    /* Add all vertices one by one to the set of intermediate 
           vertices. 
          ---> Before start of an iteration, we have shortest 
               distances between all pairs of vertices such that 
               the shortest distances consider only the vertices in 
               set {0, 1, 2, .. k-1} as intermediate vertices. 
          ----> After the end of an iteration, vertex no. k is added 
                to the set of intermediate vertices and the set 
                becomes {0, 1, 2, .. k} */
	    for (int k=0; k<n; k++) {
	        // Pick all vertices as source one by one 
	        for (int i=0; i<n; i++) {
	            // Pick all vertices as destination for the 
                // above picked source 
	            for (int j=0; j<n; j++) {
	                // If vertex k is on the shortest path from 
                    // i to j, then update the value of dist[i][j] 
	               if (res[i][j] > res[i][k] + res[k][j]) {
	                   res[i][j] = res[i][k] + res[k][j];
	               }
	            }
	        }    
	    }
	    
	    return res;
	}
}