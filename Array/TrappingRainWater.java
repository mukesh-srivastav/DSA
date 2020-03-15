/**
 * Given an array arr[] of N non-negative integers representing height of blocks at index i as Ai where the width of each block is 1. 
 * Compute how much water can be trapped in between blocks after raining.
 */

/*package whatever //do not write package name here */

import java.util.*;
import java.io.*;

class TrappingRainWater {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
 		int t  = sc.nextInt();
 		while(t-->0){
		    int n = sc.nextInt();
		    int a[]= new int[n];
 		    for(int i=0; i<a.length; i++){
		        a[i]=  sc.nextInt();
 		    }
 		    System.out.println(findWater(a, n));
 		}
	}
	
	static int findWater(int arr[], int n) 
    { 
        // initialize output 
        int result = 0; 
  
        // maximum element on left and right 
        int left_max = -1, right_max = -1; 
  
        // indices to traverse the array 
        int lo = 0, hi = n - 1; 
  
        while (lo <= hi) { 
            if (arr[lo] < arr[hi]) { 
                if (arr[lo] > left_max) 
  
                    // update max in left 
                    left_max = arr[lo]; 
                else
  
                    // water on curr element = 
                    // max - curr 
                    result += left_max - arr[lo]; 
                lo++; 
            } 
            else { 
                if (arr[hi] > right_max) 
  
                    // update right maximum 
                    right_max = arr[hi]; 
  
                else
                    result += right_max - arr[hi]; 
                hi--; 
            } 
        } 
  
        return result; 
    } 
}