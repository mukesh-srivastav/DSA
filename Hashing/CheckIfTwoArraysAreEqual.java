package Hashing;

import java.util.*;
/**
 * Given two arrays A and B of equal size N, the task is to find if given arrays are equal or not. Two arrays are said to be equal if both of them contain same set of elements, arrangements (or permutation) of elements may be different though.
Note : If there are repetitions, then counts of repeated elements must also be same for two array to be equal.
For each test case, print 1 if the arrays are equal else print 0.
 */
public class CheckIfTwoArraysAreEqual {
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    
		    long a [] = new long[n];
		    long b [] = new long[n];
		    for (int i=0; i<n; i++) {
		        a[i] = sc.nextLong();
		    }
		    for (int i=0; i<n; i++) {
		        b[i] = sc.nextLong();
		    }
		    
		    System.out.println(equalOrNot(a, b, n));
        }
        sc.close();
	}
	
	static int equalOrNot(long a[], long b[], int n) {
	    HashMap<Long, Integer> hm = new HashMap<Long,Integer>();
	    
	    for (int i=0; i<n; i++) {
	        hm.put(a[i], hm.getOrDefault(a[i], 0) + 1);
		}
		
		for (int i=0; i<n; i++) {
		    if (hm.containsKey(b[i])) {
		        int freq = hm.get(b[i]);
		        if (freq <= 1)
		            hm.remove(b[i]);
		        else {
		            hm.put(b[i], freq-1);
		        }
		    } else {
		        return 0;
		    }
		}
		
		Set set = hm.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            if ((Integer)mentry.getValue() !=0)
                return 0;
        }
        
        return 1;
	}
}