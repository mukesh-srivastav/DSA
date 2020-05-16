package Hashing;

import java.util.*;

/**
 * Given two arrays A1[] and A2[] of size N and M respectively. The task is to sort A1 in such a way that the relative order among the elements will be same as those in A2. For the elements not present in A2, append them at last in sorted order. It is also given that the number of elements in A2[] are smaller than or equal to number of elements in A1[] and A2[] has all distinct elements.
Note: Expected time complexity is O(N log(N)).

Example:
Input:
2
11 4
2 1 2 5 7 1 9 3 6 8 8
2 1 8 3
8 4
2 6 7 5 2 6 8 4 
2 6 4 5
Output:
2 2 1 1 8 8 3 5 6 7 9
2 2 6 6 4 5 7 8
 */
class RelativeSorting {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int a1 [] = new int[n];
		    int a2 [] = new int[m];
		    
		    for (int i=0; i<n; i++)
		        a1[i] = sc.nextInt();
		    for (int i=0; i<m; i++)
		        a2[i] = sc.nextInt();
		        
		    TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		    
		    for (int i=0; i<n; i++) {
		        if (tm.containsKey(a1[i])) {
		            tm.put(a1[i], tm.get(a1[i]) + 1);
		        } else {
		            tm.put(a1[i], 1);
		        }
		    }
		    
		    for (int i=0; i<m; i++) {
		        if (tm.containsKey(a2[i])) {
		            int c = tm.get(a2[i]);
		            
		            while (c-- > 0) {
		                System.out.print (a2[i] + " ");
		            }
		            
		            tm.remove(a2[i]);
		        }
		    }

		    for (Map.Entry<Integer, Integer> e : tm.entrySet())  {
		        int count = e.getValue();
		        int k = e.getKey();
		        while (count-->0){
		            System.out.print(k+ " ");
		        }
		    }
		    System.out.println();
        }
        
        sc.close();
	}
}