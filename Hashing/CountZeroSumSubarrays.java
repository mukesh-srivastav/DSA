package Hashing;
import java.util.*;

/**
 * You are given an array A of size N. You need to print the total count of sub-arrays having their sum equal to 0
 * Based on https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
 */
public class CountZeroSumSubarrays {
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    
		    int a [] = new int[n];
		    
		    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		    
		    for (int i=0; i<n; i++) {
		        a[i] = sc.nextInt();
		    }
		    int sum = 0;
		    int count = 0;
		    
		    for (int i=0; i<n; i++) {
		        sum += a[i];
		        if (sum == 0)
		            count++;
		            
		        if (hm.containsKey(sum))
		            count+=hm.get(sum);
		        
		        hm.put(sum, hm.getOrDefault(sum, 0) + 1);
		    }
		    
		    System.out.println(count);
        }
        sc.close();
	}
}