package Graph;
import java.util.*; 

/**
 * Given a N X N matrix (M) filled with 1, 0, 2, 3. The task is to find whether there is a path possible from source to destination, while traversing through blank cells only. You can traverse up, down, right and left.

A value of cell 1 means Source.
A value of cell 2 means Destination.
A value of cell 3 means Blank cell.
A value of cell 0 means Blank Wall.
Note: there is only single source and single destination.

 

Input:
The first line of input is an integer T denoting the no of testcases. Then T test cases follow. Each test case consists of 2 lines. The first line of each test case contains an integer N denoting the size of the square matrix. Then in the next line are N*N space separated values of the matrix (M).

Output:
For each test case in a new line print 1 if the path exist from source to destination else print 0.
 */
public class FindWhetherPathExists {
    static class Node {
        int x, y;
        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		    int n = sc.nextInt();
		    int a[][] = new int[n][n];
		    
		    Node src = null, dest = null;
		    for(int i=0; i<n; i++) {
		        for (int j=0; j<n; j++) {
		            a[i][j] = sc.nextInt();
		            if (a[i][j] == 1) {
		                src = new Node (i, j);
		            }
		            
		            if (a[i][j] == 2) {
		                dest = new Node(i, j);
		            }
		        }
		    }
		    
		    System.out.println(checkPathExists(a, src, dest, n));
        }
        sc.close();
	}
	
	static int checkPathExists(int [][]a, Node src, Node dest, int n)
	{
	    if (src == null || a[src.x][src.y] != 1)
	        return 0;
	       
	    if (dest == null || a[dest.x][dest.y] != 2)
	        return 0;
	        
	    boolean visited[][] = new boolean[n][n];
	    
	    Queue<Node> q = new LinkedList<Node>();
	    
	    q.add(src);
	    visited[src.x][src.y] = true;
	    
	    int row_traverse[] = new int[] {0, 0, 1, -1};
	    int col_traverse[] = new int[] {1, -1, 0, 0};
	    
	    while (q.isEmpty() == false) {
	        Node curr = q.peek();
	        
	        if (a[curr.x][curr.y] == 2 || (curr.x == dest.x && curr.y == dest.y)) {
	            return 1;
	        }
	        
	        q.remove();
	        
	        for (int i=0; i<4; i++) {
	            int next_row = curr.x + row_traverse[i];
	            int next_col = curr.y + col_traverse[i];
	            
	            if (isValid(next_row, next_col, n)) {
	                if (visited[next_row][next_col] == false && a[next_row][next_col] == 3) {
	                    visited[next_row][next_col] = true;
	                    q.add(new Node(next_row, next_col));
	                }
	                
	                if (a[next_row][next_col] == 2) {
	                    return 1;
	                }
	            }
	        }
	    }
	    
	    return 0;
	}
	
	static boolean isValid(int row, int col, int n) {
	    return (row>=0) && (row < n) && (col>=0) && (col < n);
	}
}