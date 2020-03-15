/**
 * Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller and all right elements to it are greater than it.
 * Note: Left and right side elements can be equal to required element. And extreme elements cannot be required element.
 */

import java.util.*;
import java.io.*;

class ElementsWithLeftSideSmallerAndRightSideGreater {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		    int n = sc.nextInt();
		    int a[] = new int[n];
		    for(int i=0; i<n;i++) 
		        a[i] = sc.nextInt();
		    
		    
		        System.out.println(findElement(a, n));
		}
	}
	
	static int findElement(int a[], int n) {
	        int left[] = new int[n];
		    int right[] = new int[n];
		    
		    left[0] =a[0];
		    right[n-1] = a[n-1];
		    for(int i=1; i<n;i++) {
		        left[i] = Math.max(left[i-1], a[i]);
		    }
		    
		    for(int i=n-2; i>=0;i--) {
		        right[i] = Math.min(right[i+1], a[i]);
		    }
		    
		    int ans = -1;
		    for(int i=1; i<n-1;i++) {
		        if (left[i] == right[i]) {
		          ans = a[i]; break;
		        }
		          
		        
		    }
		    return ans;
	}
}