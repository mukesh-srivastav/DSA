package Greedy;
import java.util.*;
/**
 * Given an array consisting cost of toys. Given an integer K depicting the amount with you. Maximise the number of toys you can have with K amount.
 * Another approach: without using sorting, We can build a min heap but taking a input to insert (O(log n)) and building a heap O(n) is same as sorting in terms of time. 
 */
public class MaximizeToys {
    public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    int a[] = new int[n];
		    
		    for (int i=0; i<n; i++) {
		        a[i] = sc.nextInt();
		    }
		    
		    System.out.println(MaximizeToysCount(a, n, k));
		}
		sc.close();
	}
	
	static int MaximizeToysCount(int a[], int n, int k)
	{
	    if (n==0 || a.length == 0 || k == 0)
	        return 0;
	    Arrays.sort(a);  
	    int count = 0;
	    for(int i=0; i<n; i++) {
	        if (a[i] <= k) {
	            count++;
	            k -= a[i];
	        }
	    }
	    
	    return count;
	}    
}