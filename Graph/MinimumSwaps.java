package Graph;
import java.util.*;

/**
 * Given an array of integers. Find the minimum number of swaps required to sort the array in non-decreasing order.
 * https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
 */
public class MinimumSwaps {
    // return the minimum number of swaps required to sort the arra
	public int minSwaps(int[] arr, int N) {
	    ArrayList<Pair> g = new ArrayList<Pair>();
	    
	    for (int i=0; i<N; i++) {
	        g.add(new Pair(arr[i], i));
	    }
	    
	    Collections.sort(g, new Comparator<Pair>() {
	        @Override
	        public int compare(Pair p1, Pair p2) {
	            if (p1.e > p2.e) 
	                return 1;
	            if (p1.e == p2.e)
	                return 0;
	            return -1;
	        }
	    });
	    
	    boolean []visited = new boolean[N];
	    int count = 0;
	    int cycle_size = 0;
	    
	    for (int i=0; i<N; i++) {
	        if (visited[i] == true || g.get(i).index == i)
	            continue;
	            
	        cycle_size = 0;
	        int j= i;
	        while (visited[j] == false) {
	            visited[j] = true;
	            j = g.get(j).index;
	            cycle_size++;
	        }
	        
	        if (cycle_size > 0) {
	            count += (cycle_size - 1);
	        }
	    }
	    
	    return count;
	}
	
	class Pair {
	    int e, index;
	    
	    Pair (int e, int index) {
	        this.e = e; 
	        this.index = index;
	    }
	}
}