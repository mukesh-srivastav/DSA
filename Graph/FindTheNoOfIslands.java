package Graph;
import java.util.*;

/**
 *  Given a Matrix consisting of 0s and 1s. Find the number of islands of connected 1s present in the matrix. 
 * This is a variation of the standard problem: “Counting the number of connected components in an undirected graph”.
Note: A 1 is said to be connected if it has another 1 around it (either of the 8 directions).
 */
public class FindTheNoOfIslands {
    static int findIslands(ArrayList<ArrayList<Integer>> A, int N, int M) {

        boolean visited[][] = new boolean[N][M];
        int cnt = 0;
        // Initialize count as 0 and travese through the all cells 
        // of given matrix 
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                // If a cell with 
                // value 1 is not 
                // visited yet, then new island found, Visit all 
                // cells in this island and increment island count 
                if (A.get(i).get(j) == 1 && visited[i][j] == false) {
                    dfs(i, j, visited, A);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    // A utility function to do DFS for a 2D boolean matrix. 
    // It only considers the 8 neighbors as adjacent vertices 
    static void dfs(int i, int j, boolean visited[][],ArrayList<ArrayList<Integer>> A)
    {
        int row[] = new int[] {-1,-1,-1, 0, 0, 1, 1, 1};
        int col[] = new int[] {-1, 0, 1, 1, -1, -1, 0, 1};
        
        visited[i][j] = true;
        
        // Recur for all connected neighbours 
        for (int k=0; k<8; k++) {
            if (isSafe(i+row[k], j + col[k], visited, A)){
                dfs(i+row[k], j + col[k], visited, A);
            }
        }
    }
    // A function to check if a given cell (row, col) can 
    // be included in DFS 
    static boolean isSafe(int i, int j, boolean visited[][], ArrayList<ArrayList<Integer>> A)
    {
        int m = A.size();
        int n = A.get(0).size();
        // row number is in range, column number is in range 
        // and value is 1 and not yet visited 
        return ((i>=0) && (i<m) && (j>=0) && (j<n) && visited[i][j] == false && A.get(i).get(j) == 1);
    }
}