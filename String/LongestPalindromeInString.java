/**
 * Given a string S, find the longest palindromic substring in S. 
 * Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string which reads the same backwards. 
 * More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index ).
 * NOTE: Required Time Complexity O(n2).
 */

/*package whatever //do not write package name here */

/*package whatever //do not write package name here */

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t-->0){
		    String s = sc.next();
		    int n = s.length();
		    boolean dp[][] = new boolean[n][n];
		    
		    int start=0, maxLength= 1;
		    for(int i=0; i<n; i++){
		        dp[i][i] = true;
		    }
		    
		    for(int i=0; i<n-1; i++){
		        if (s.charAt(i) == s.charAt(i+1)) {
		            dp[i][i+1] = true; 
		            start = i;
		            maxLength = 2;
		        }
		    }
		    
		    for(int k = 3; k<=n; ++k) {
		        for(int i=0; i<n-k+1; ++i) {
		            int j = i+k-1;
		            
		            // if s.substring(i+1, j-1) is palindrome then check for s.substring(i,j)
		            if (dp[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
		                dp[i][j] = true;
		                if(k>maxLength) {
		                    maxLength = k ;
		                    start = i;
		                }
		            }
		        }
		    }
		    
		    System.out.println(s.substring(start,  start + maxLength));
		    
		}
	}
}