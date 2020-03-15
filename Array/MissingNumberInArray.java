/*
  Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing, the missing number is to be found.
*/

import java.io.*;

class MissingNumberInArray {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t--> 0) {
		    int n = sc.nextInt();
		    int sum = 0;
		    for(int i=0; i<n-1; i++) {
		        sum = sum + sc.nextInt();
		    }
		    
		    int l = ((n * (n+1)) / 2) - sum; 
		    System.out.println(l);
		}
	}
}