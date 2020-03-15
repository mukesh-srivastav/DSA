/**
 * Given an array A of positive integers of size N, where each value represents number of chocolates in a packet. Each packet can have variable number of chocolates. There are M students, the task is to distribute chocolate packets such that :
 * 1. Each student gets one packet.
 * 2. The difference between the number of chocolates given to the students having packet with maximum chocolates and student having packet with minimum chocolates is minimum.
 * https://www.geeksforgeeks.org/chocolate-distribution-problem/
 */

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
		    int n = sc.nextInt();
		    int a[]= new int[n];
		    for(int i=0; i<n; i++){
		        a[i]= sc.nextInt();
		    }
		    int m = sc.nextInt();
            Arrays.sort(a);
            
		    int first=0, last =m-1, dif=Integer.MAX_VALUE; 
		    for (first=0; last<n; last++) {
		       int sub=a[last]-a[first];
		       // System.out.println(a[last]+"-"+a[first]+"="+sub);
		       if(sub<dif){
		           dif=sub;
		           
		       }
		       first++;
		    }
		    System.out.println(dif);
		}
	}
}