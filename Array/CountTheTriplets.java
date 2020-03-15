/* 
   Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
   If no such triplets can form, print "-1".
*/


import java.util.*;
import java.io.*;

class CountTheTriplets {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		    int n = sc.nextInt();
		    int a[] = new int[n];
		    int count = 0;
		    for(int i=0; i<n; i++) {
		        a[i] = sc.nextInt();
		    }
		    Arrays.sort(a);
		    int i=0, j=n-2, k= n-1; 
		    
		    while((i>=0 && j>=0) && (i<k && j<k)) {
		        if (i>=j) {
		            k = k-1; 
		            i = 0; 
		            j = k-1;
		        }
		        
		        else if (a[i] + a[j] == a[k]) {
		            count++; 
		            i++;
		            j--;
		        } else if (a[i] + a[j] < a[k]) {
		            i++;
		        } else if (a[i] + a[j] > a[k]){
		            j--;
		        }
		    }
		    
		    if (count == 0)
		        count = -1; 
		        
		    System.out.println(count);
		    
		}
	}
}