package Greedy;

import java.util.*;

public class MinimizeTheHeights {
    public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int k = sc.nextInt();
		    int n = sc.nextInt();
		    
		    int a[] = new int[n];
		    
		    for (int i=0; i<n; i++) {
		        a[i] = sc.nextInt();
		    }
		    
		    System.out.println(minimizeTheHeights(a, n, k));
		}
		sc.close();
	}
	
	/**
     * The idea is to sort all elements increasing order. And for all elements check if subtract(element-k) and add(element+k) makes any changes or not.
     * Modifies the array by subtracting/adding k to every element such that the difference between maximum and minimum is minimized.
     * 
     * @param a
     * @param n
     * @param k
     * @return
     */
	static int minimizeTheHeights(int a[], int n, int k)
	{
	    Arrays.sort(a);
        
        // Initialize result 
        int ans = a[n-1] - a[0];
        
        // Handle corner elements.
	    int low = a[0] + k; 
	    int high = a[n-1] - k;
	    
	    if (low > high) {
	        int t = low;
	        low = high;
	        high = t;
	    }
	    
	    for (int i=1; i<n-1; i++) {
	        int sub = a[i] - k;
	        int add = a[i] + k;
            
            // If both subtraction and addition 
            // do not change diff 
	        if (sub >= low || add <= high)
	            continue;
              
            // Either subtraction causes a smaller 
            // number or addition causes a greater 
            // number. Update small or big using 
            // greedy approach (If big - subtract 
            // causes smaller diff, update small 
            // Else update big) 
	        if (high - sub <= add - low) {
	            low = sub;
	        } else {
	            high = add;
	        }
	    }
	    
	    return Math.min (ans, high - low);
	}
}