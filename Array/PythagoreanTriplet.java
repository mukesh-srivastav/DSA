/**
 * Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
 */

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		
		Scanner sc = new Scanner(System.in);
        int t  = sc.nextInt();
         
        while (t-->0) {

		    int n = sc.nextInt();
            int a[] = new int[n];
            
	        for (int i=0; i<n; i++) {
	            a[i] = sc.nextInt();
	            a[i] = a[i]*a[i];
            }
            
	        int f= 0 ;
	        Arrays.sort(a);
	        
	        for (int i=n-1; i>=2; i--) {
	            int l = 0; 
	            int r = i-1;
                
                while (l<r) {

    	            if (a[l]+a[r] ==a[i]) {
    	                f= 1; 
    	                break;
    	            } else {
    	                if (a[l]+a[r] < a[i]) {
    	                    l++;
    	                } else {
    	                    r--;
    	                }
    	            }
	            }
	        }
	        
	        if(f==1)
	        System.out.println("Yes");
	        else
	        System.out.println("No");
        }
    }
}