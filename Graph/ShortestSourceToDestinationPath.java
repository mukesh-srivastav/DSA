package Graph;
import java.util.*;

/**
 * Given a boolean 2D matrix (0-based index), find whether there is path from (0,0) to (x,y) and if there is one path, print the minimum no of steps needed to reach it, else print -1 if the destination is not reachable. You may move in only four direction ie up, down, left and right. The path can only be created out of a cell if its value is 1.
 * Modified BFS approach. 
 */
public class ShortestSourceToDestinationPath {
    static class GridNode {
        int x, y, dist;
        
        GridNode (int x, int y) {
            this.x = x; 
            this.y = y;
        }
        
        GridNode (int x, int y, int dist) {
            this.x = x; 
            this.y = y;
            this.dist = dist;
        }
    }
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int a[][] = new int[n][m];
		    
		    for(int i=0; i<n; i++) {
		        for (int j=0; j<m; j++)
		            a[i][j] = sc.nextInt();
		    }
		    
		    int x = sc.nextInt();
		    int y = sc.nextInt();
		    GridNode destination = new GridNode(x,y);
		    System.out.println(shortestPathToDestination(a, destination, n, m));
        }
        sc.close();
	}
	
	static int shortestPathToDestination(int [][]a, GridNode dest, int n, int m)
	{
	    GridNode src = new GridNode (0,0,0);
	    if (a[0][0] != 1 || a[dest.x][dest.y] != 1) {
	        return -1;
	    }
	    
	    boolean visited[][] = new boolean[n][m];
	    
	    Queue<GridNode> q = new LinkedList<GridNode>();
	    
	    q.add(src);
	    
	    int row[] = new int[] {-1, 0, 1, 0};
	    int col[] = new int[] {0,  1, 0, -1};
	    
	    visited[src.x][src.y] = true;
	    
	    while(q.isEmpty() == false) {
	        GridNode curr = q.peek();
	        
	        if (curr.x == dest.x && curr.y == dest.y) {
	            return curr.dist;
	        }
	        
	        q.remove();
	        
	        for (int i=0; i<4; i++) {
	            int next_row = curr.x + row[i];
	            int next_col = curr.y + col[i];
	            
	            if (isValid(next_row, next_col, n, m) && visited[next_row][next_col] == false && a[next_row][next_col] == 1) {
	                visited[next_row][next_col] = true;
	               q.add(new GridNode(next_row, next_col, curr.dist + 1));
	            }
	        }
	    }
	    
	    return -1;
	}
	
	static boolean isValid(int row, int col, int n, int m) {
	    return (row >=0 && row<n) && (col>=0 && col<m);
	}
	
}