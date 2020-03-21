/**
 * Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). 
 * Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. Incase of conflict, return the substring which occurs first ( with the least starting index ).
 * NOTE: Required Time Complexity O(n2).
 */

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
		    
		    int start = 0, maxLength = 1;
		    int low, high;
		    
		    for (int i=1; i<n; i++) {
		        low = i - 1;
		        high = i;
		        
		        while(low>=0 && high < n && s.charAt(low) == s.charAt(high)) {
		            if (high - low + 1 > maxLength) {
		                maxLength = high - low +1;
		                start = low;
		            }
		            low--; high++;
		        }
		        
		        low = i-1;
		        high = i+1;
		        
		        while(low>=0 && high < n && s.charAt(low) == s.charAt(high)) {
		            if (high - low + 1 > maxLength) {
		                maxLength = high - low +1;
		                start = low;
		            }
		            low--; high++;
		        }
		        
		    }
		    
		    System.out.println(s.substring(start, start+maxLength));
		    
		}
	}
}