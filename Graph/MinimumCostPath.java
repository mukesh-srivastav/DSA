package Graph;

import java.util.*;

/**
 * Given a square grid of size N, each cell of which contains integer cost which represents a cost to traverse through that cell, we need to find a path from top left cell to bottom right cell by which total cost incurred is minimum. You can move in 4 directions : up, down, left an right.

Note : It is assumed that negative cost cycles do not exist in input matrix.

Input:
The first line of input will contain number of testcases T. Then T test cases follow. Each test case contains 2 lines. The first line of each test case contains an integer N denoting the size of the grid. Next line of each test contains a single line containing N*N space separated integers depicting the cost of respective cell from (0,0) to (N,N).

Output:
For each test case output a single integer depecting the minimum cost to reach the destination.
https://www.geeksforgeeks.org/minimum-cost-path-left-right-bottom-moves-allowed/
 */
class MinimumCostPath {

    static class Node {
        int x, y;
        int cost;
        
        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        Node (int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		    int n = sc.nextInt();
		    int a[][] = new int[n][n];
		    
		    
		    for(int i=0; i<n; i++) {
		        for (int j=0; j<n; j++) {
		            a[i][j] = sc.nextInt();
		        }
		    }
		    
		    Node src = new Node(0, 0, a[0][0]), dest = new Node(n-1, n-1);
		    
		    System.out.println(minimumCostPath(a, src, dest, n));
		    
        }
        sc.close();
	}
	
	static int minimumCostPath(int [][]a, Node src, Node dest, int n)
	{
	    int dist[][] = new int[n][n];
	    for (int i=0; i<n; i++) {
	        for (int j= 0; j<n; j++)
	            dist[i][j] = Integer.MAX_VALUE;
	    }
	    
	    List<Node> ls = new LinkedList<Node>();
	    
	    ls.add(src);
	    dist[0][0] = src.cost;
	    
	    int row_move[] = new int[] {0, 0, -1, 1};
	    int col_move[] = new int[] {1, -1, 0, 0};
	    
	    int currSize = 1;
	    
	    while (ls.isEmpty() == false) {
	        for (int size = 0; size<currSize; size++) {
    	        Node curr = ls.remove(0);

    	        for (int i=0; i<4; i++) {
    	            int next_row = curr.x + row_move[i];
    	            int next_col = curr.y + col_move[i];
    	            
    	            if (isValid(next_row, next_col, n) && dist[next_row][next_col] > dist[curr.x][curr.y] + a[next_row][next_col]) {
    	                dist[next_row][next_col] = dist[curr.x][curr.y] + a[next_row][next_col];
    	                ls.add(new Node(next_row, next_col, dist[next_row][next_col]));
    	            }
    	        }
	        }
	        currSize = ls.size();
	    }
	    
	    return dist[n-1][n-1];
	}
	
	static boolean isValid(int row, int col, int n) {
	    return (row>=0) && (row<n) && (col>=0) && (col<n);
	}
	
}