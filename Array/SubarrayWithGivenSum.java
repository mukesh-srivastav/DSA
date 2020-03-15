/*
Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.
print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.
*/

import java.util.*;
import java.io.*;

class SubarrayWithGivenSum {
	public static void main (String[] args) {
		//code
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0){
		    int n = sc.nextInt();
		    int x = sc.nextInt();
		    int a[] = new int[n];
		    for(int i=0; i<n;i++){
		        a[i] = sc.nextInt();
		    }
		    
		    int start = 0; 
		    int end = 0;
		    int curr = a[0];
		    boolean found = false;
		    while(start < n && end < n) {
		        
		        if(curr < x) {
		            end++;
		            if(end < n)
		            curr += a[end];
		        }
		        if(curr > x) {
		            curr -= a[start];
		            start++;
		        }
		        if(curr == x) {
		            found = true;
		            break;
		        }
		    }
		    if(!found){
		        System.out.println(-1);
		    }else
		    System.out.println((1 + start) + " " + (end + 1));
		}
	}
}