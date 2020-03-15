/**
 * Given an array arr[] and a number K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.
 * Expected Time Complexity: O(n)
 */

import java.util.*;
import java.io.*;

class KthSmallestElement {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0) {
		    int n = sc.nextInt();
		    int a[] = new int[n];
		    
		    for(int i=0; i<n; i++)
		        a[i] = sc.nextInt();
		     int k = sc.nextInt();
		    
		    System.out.println(KSmallest(a, 0, n-1, k));
		}
	}
	
	static  int KSmallest(int []a, int l, int r, int k) 
	{
	    if (k>0 && k<=r-l+1) {
	        int pos = randomPartition(a, l, r);
	        
	        if (pos - l == k -1)
	            return a[pos];
	       
	        if (pos - l>k-1)
	            return KSmallest(a, l, pos-1, k);
	        
	        return KSmallest(a, pos+1, r, k-pos+l-1);
	        
	    }
	    
	    return Integer.MAX_VALUE;
	}
	
	static  int randomPartition (int a[],int l, int r) {
	    int n = r-l+1;
	    int pivot = (int)(Math.random() * (n-1));
	    swap (a, l+pivot, r);
	    return partition(a, l, r);
	}
	
	static  void swap (int a[], int i, int j) {
	    int t = a[i]; 
	    a[i] = a[j];
	    a[j] = t;
	}
	
	static int partition(int a[], int l, int r) {
	    int x = a[r]; int i = l;
	    
	    for(int j = l; j<=r-1; j++) {
	        if (a[j] <=x) {
	            swap(a, i, j);
	            i++;
	        }
	    }
	    swap(a, i, r);
	    
	    return i;
	}
}