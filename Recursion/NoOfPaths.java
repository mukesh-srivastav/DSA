package Recursion;

import java.util.Scanner;

public class NoOfPaths {
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0) {
		    int m = sc.nextInt();
		    int n = sc.nextInt();
		    
		    System.out.println(countPaths(m,n));
        }
        sc.close();
	}
	
	static int countPaths(int m, int n) {
	    if (m==1 || n ==1) 
	        return 1;
	       
	    return countPaths(m-1, n) + countPaths(m, n-1);
	}
}