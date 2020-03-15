/*
 Given an array arr of N integers. Find the contiguous sub-array with maximum sum
 Print the maximum sum of the contiguous sub-array in a separate line for each test case.
*/


import java.util.*;
import java.io.*;

class KadaneAlgorithm {
	public static void main (String[] args) {
		//code
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-->0){
	        int n = sc.nextInt();
	        int a[] = new int[n];
	        
	        for(int i=0; i<n; i++){
	            a[i]= sc.nextInt();
	        }
	        
	        int maxEndingHere = a[0]; 
	        int maxSumSoFar = a[0]; 
	        
	        for(int i=1; i<n; i++){
	            maxEndingHere = maxEndingHere +a[i];
	            if(maxEndingHere <a[i])
	                maxEndingHere = a[i];
	                
	            if(maxEndingHere > maxSumSoFar)
	                maxSumSoFar = maxEndingHere;
	        }
	        
	        System.out.println(maxSumSoFar);
	    }
	    
	}
}