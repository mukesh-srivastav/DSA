/**
 * Given arrival and departure times of all trains that reach a railway station. Your task is to find the minimum number of platforms required for the railway station so that no train waits.
 * Note: Consider that all the trains arrive on the same day and leave on the same day.
 * Also, arrival and departure times will not be same for a train, but we can have arrival time of one train equal to departure of the other. 
 * In such cases, we need different platforms, i.e at any given instance of time, same platform can not be used for both departure of a train and arrival of another.
 * Note: Time intervals are in the 24-hour format(hhmm),  of the for HHMM , where the first two charcters represent hour (between 00 to 23 ) and last two characters represent minutes (between 00 to 59).
 * 1 <= A[i] < D[i] <= 2359
 */

import java.util.*;
import java.io.*;

class MinimumPlatform {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		    int n = sc.nextInt();
		    int arr[] = new int[n];
		    int dept[] = new int[n];
		    
		    for(int i=0; i<n;i++) 
		        arr[i] = sc.nextInt();
		    for(int i=0; i<n;i++) 
		        dept[i] = sc.nextInt();
		        
		    System.out.println(minPlat(arr, dept, n));
		}
		        
	}
	
	static int minPlat(int arr[], int dept[], int n) {
	    Arrays.sort(arr);
	    Arrays.sort(dept);
	    
	    int i=1, j=0; 
	    int plat_needed = 1, res= 1; 
	    
	    while(i<n && j<n) {
	        if (arr[i] <= dept[j]) {
	            plat_needed++; 
	            i++;
	            if(plat_needed > res)
	                res = plat_needed;
	        } else {
	            plat_needed--;
	            j++;
	        }
	    }
	    return res;
	}
}