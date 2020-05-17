package Hashing;

/**
 * Given an array of integers and a number k, write a function that returns true if given array can be divided into pairs such that sum of every pair is divisible by k.
 * 1) If length of given array is odd, return false. 
    An odd length array cannot be divided into pairs.
2) Traverse input array and count occurrences of 
    all reminders. 
      freq[arr[i] % k]++
3) Traverse input array again. 
   a) Find the remainder of the current element.
   b) If remainder divides k into two halves, then
      there must be even occurrences of it as it 
      forms pair with itself only.
   c) If the remainder is 0, then there must be 
      even occurrences.
   c) Else, number of occurrences of current 
      the remainder must be equal to a number of 
      occurrences of "k - current remainder".
 */

import java.util.*;

public class ArrayPairSumDivisibilityProblem {
    public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    int a [] = new int[n];
		    for (int i=0; i<n; i++) {
		        a[i] = sc.nextInt();
		    }
		    int k = sc.nextInt();
		    
		    System.out.println(checkPairSumDivisibility(a, k));
        }
        sc.close();
	}
	
	static String checkPairSumDivisibility(int a[], int k)
	{
	    HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
	    
	    int n = a.length;
	    
	    if (n%2==1)
	        return "False";
	    
	    for (int i =0 ;i<n; i++) {
	        hs.put(a[i] % k, hs.getOrDefault(a[i]%k, 0) + 1);
	    }
	    
	    for (int i=0; i<n; i++) {
	        int rem = a[i] % k;
	        
	        if (2*rem == k) {
	            if (hs.get(rem) %2 ==1)
	                return "False";
	        } else if (rem%k == 0) {
	            if (hs.get(rem) %2 ==1)
	                return "False";
	        } else {
	            if (hs.get(k - rem) != hs.get(rem))
	                return "False";
	        }
	    }
	    
	    return "True";
	}
	
}
