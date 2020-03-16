/**
 * Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.
 * The result is going to be very large, hence return the result in the form of a string.
 */

import java.util.*;
import java.io.*;

class LargestNumberFormedFromArray {
	public static void main (String[] args) {
		//code
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		    int n = sc.nextInt();
		    String []arr = new String[n];
		    
		    for(int i=0; i<n; i++) {
		        arr[i] = sc.next();
		    }
		    
		    Arrays.sort(arr, new Comparator<String>() {
		        public int compare(String a, String b) {
		            String ab = a + b;
		            String ba = b + a;
		            
		            return ab.compareTo(ba) > 0 ? -1 : 1;  
		        }
		    });
		    
		    System.out.println(String.join("",arr));
		}
	}
}