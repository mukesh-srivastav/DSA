 /**
  * Given an array A (distinct elements) of size N. Rearrange the elements of array in zig-zag fashion.
  * The converted array should be in form a < b > c < d > e < f. 
  * The relative order of elements is same in the output i.e you have to iterate on the original array only.
  */

  /*package whatever //do not write package name here */

import java.util.*;
import java.io.*;

class ConvertArrayIntoZigZagFashion {
	public static void main (String[] args) {
		//code
			Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		    int n = sc.nextInt();
		    int a[] = new int[n];
		    for(int i=0; i<n;i++)  {
		        a[i] = sc.nextInt();
		    }
		    
		    boolean flag = true; // <
		    int temp;
		    for(int i=0; i<n-1;i++)  {
		        if(flag) {
		            if (a[i] > a[i+1]) {
		                temp = a[i];
		                a[i]= a[i+1];
		                a[i+1] = temp;
		            }
		        } else { // >
		            if (a[i] < a[i+1]) {
		                temp = a[i];
		                a[i]= a[i+1];
		                a[i+1] = temp;
		            }
		        }
		        flag = !flag;
		    }
		    
		    for (int i: a) {
		        System.out.print(i + " ");
		    }
		    System.out.println();
		}
	}
}