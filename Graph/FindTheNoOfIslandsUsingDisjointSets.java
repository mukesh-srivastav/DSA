package Graph;
import java.util.*;

/**
 * Given a Matrix consisting of 0s and 1s. Find the number of islands of connected 1s present in the matrix. 
Note: A 1 is said to be connected if it has another 1 around it (either of the 8 directions).
Expected Time Complexity: O(N*M).
Expected Auxiliary Space: O(N*M).
 */
public class FindTheNoOfIslandsUsingDisjointSets {
    
    // Function to find the number of island in the given list A
    // N, M: size of list row and column respectively
    static int findIslands(ArrayList<ArrayList<Integer>> A, int n, int m) {
    
        DisjointSets ds = new DisjointSets(n*m);
        
        /* The following loop checks for its neighbours 
           and unites the indexes  if both are 1. */
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int e = A.get(i).get(j);
                // If cell is 0, nothing to do 
                if (e == 0)
                    continue;
                
                // Check all 8 neighbours and do a union 
                // with neighbour's set if neighbour is  
                // also 1 
                if (i-1>=0 && A.get(i-1).get(j) == 1) {
                    ds.union(i*m + j, (i-1)*m + j);
                } 
                if (i+1 < n && A.get(i+1).get(j) == 1) {
                    ds.union(i*m + j, (i+1)*m + j);
                }
                if (i-1>=0 && j-1>=0 && A.get(i-1).get(j-1) == 1) {
                    ds.union(i*m + j, (i-1)*m + (j-1));
                } 
                if (i-1>=0 && j+1 < m && A.get(i-1).get(j+1) == 1) {
                    ds.union(i*m + j, (i-1) * m + (j+1));
                }
                if (i+1 < n && j+1 < m && A.get(i+1).get(j+1) == 1) {
                    ds.union(i*m + j, (i+1)*m + (j+1));
                }
                if (i+1 < n && j-1 >= 0 && A.get(i+1).get(j-1) == 1) {
                    ds.union(i*m + j, (i+1)*m + (j-1));
                }
                if (j-1 >=0 && A.get(i).get(j-1) == 1) {
                    ds.union(i*m + j, i*m + j-1);
                } 
                if (j + 1 < m && A.get(i).get(j+1) == 1) {
                    ds.union(i*m + j, i*m + j+1); 
                }
            }
        }
        
        // Max number of parents in freq array can be n*m in case any of elements of array didn't join with each other. 
        int freq[] = new int[n*m];
        int res = 0;
        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (A.get(i).get(j) == 1 ) {
                    int x = ds.find(i*m + j);
                    
                    // If frequency of set is 0, i.e. this set hasn't been recorded before in freq array.  
                    // increment numberOfIslands
                    if (freq[x] == 0) {
                        res++;
                    }
                    
                    freq[x]++;
                }
            }
        }
        
        return res;
    }
    
    // Class to represent Disjoint Set Data structure 
    static class DisjointSets {
        int []rank;
        int []parent;
        int n;
        DisjointSets(int n) {
            rank = new int[n];
            parent = new int[n];
            this.n = n;
            for (int i=0; i<n; i++) {
                parent[i] = i;
            }
        }
        
        int find(int x) {
            if (parent[x]!=x) {
                // if x is not the parent of itself, 
            // then x is not the representative of 
            // its set. 
            // so we recursively call Find on its parent 
            // and move i's node directly under the 
            // representative of this set s
                return find(parent[x]);
            }
            
            return parent[x];
        }
        
        // Unites the set that includes x and the set 
        // that includes y
        void union(int u, int v) {
            // Elements are in the same set, no need 
            // to unite anything. 
            int p1 = find(u);
            int p2 = find(v);
        
            // Elements are in the same set, no need 
            // to unite anything    
            if (p1 == p2)
                return;
            
            // If x's rank is less than y's rank 
            // Then move x under y  so that depth of tree 
            // remains less 
            if (rank[p1]<rank[p2]) {
                parent[p1] = p2;
            }
            // Else if y's rank is less than x's rank 
            // Then move y under x so that depth of tree 
            // remains less 
            else if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
            } else {
                // Else if their ranks are the same 
                // Then move y under x (doesn't matter 
                // which one goes where) 
                parent[p2] = p1;
                
                // And increment the result tree's 
                // rank by 1 
                rank[p1] = rank[p1] + 1;
            }
        }
    }
}
