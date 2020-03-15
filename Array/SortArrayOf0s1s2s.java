
/**
 * Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.
 * Try to sort the array in-place with 0(1) extra space.
 */
import java.util.*;
import java.io.*;

class SortArrayOf0s1s2s {
	public static void main (String[] args) {
		//code
		BufferedReader br = new BufferedReader(new
        InputStreamReader(System.in));
 		try{
 		int t = Integer.parseInt(br.readLine());
 		while(t-->0){
 		    int n = Integer.parseInt(br.readLine());
		    int a[]= new int[n];
		    String arr[] = br.readLine().split(" ");
		    for(int i=0; i<n; i++){
		      a[i]=  Integer.parseInt(arr[i]);
		    }
		    
		    int zero=0; 
		    int mid=0;
		    int high=n-1;
		    while(mid<=high){
		        switch(a[mid]){ 
		           case 0 : 
		               int temp = a[zero];
		               a[zero] = a[mid];
		               a[mid]= temp; 
		               zero++; 
		               mid++;
		               break;
		           case 1 :
		               mid++;
		               break;
		           case 2 : 
		               int t1 = a[mid];
		               a[mid] = a[high];
		               a[high]= t1; 
		               high--;
		               break;
		        }
		    }
		    
		    for(int i=0;i<n; i++){
		      System.out.print(a[i] + " ");  
		    }
		    System.out.println();
 		    
 		}
 		}
 		catch(Exception e){
             System.out.println("Error while reading the data.");
    
        }
	}
}