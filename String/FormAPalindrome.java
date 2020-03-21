/**
 * Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
 * For Example:
 * ab: Number of insertions required is 1. bab or aba
 * aa: Number of insertions required is 0. aa
 * abcd: Number of insertions required is 3. dcbabcd
 */


import java.util.*;
import java.io.*;

class FormAPalindrome {
	public static void main (String[] args) {
		//code
		
		Scanner sc = new Scanner(System.in); 
		
		int t = sc.nextInt();
		
		while(t-->0) {
		    String s = sc.next();
		    
		    int count = getFormPalindromeCount(s, s.length());
		    
		    System.out.println(count);
		}
	}
	
	static int getFormPalindromeCount(String s, int n) 
	{
	    char c[] = s.toCharArray();
	    
	    int a[][] = new int[n][n];
	    
	    int gap =1; 
	    
	    for (gap=1; gap<n;gap++ ) {
	        for(int l=0, h=gap; h<n; l++, h++) {
	            a[l][h] = (c[l] == c[h]) ? 
	                           a[l+1][h-1] : 
	                           (Integer.min(a[l+1][h], a[l][h-1]) +1);
	        }
	    }
	    return a[0][n-1];
	}
}