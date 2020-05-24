package Hashing;

import java.util.*;
/**
 * Given an array arr[] of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
 */
class LongestConsecutiveSubsequence {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    
		    int a [] = new int[n];
		    HashSet<Integer> hs = new HashSet<Integer>();
		    
		    for (int i=0; i<n; i++) {
		        a[i] = sc.nextInt();
		        hs.add(a[i]);
		    }
		    
		    int max = 0;
		    for (int i=0; i<n; i++) {
		        // check If a[i] is not the part of subsequence already.
		        if (hs.contains(a[i] - 1) == false) {
    		        int j = a[i];
    		        
    		        int c = 0;
    		        
    		        while (hs.contains(j))
    		            j++;
    		        c = j - a[i];
    		        
    		        if (c>max)
    		            max = c;
		        }
		    }
		    
		    System.out.println(max);
        }
        sc.close();
	}
}