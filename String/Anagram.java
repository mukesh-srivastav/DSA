/**
 * Given two strings a and b consisting of lowercase characters. The task is to check whether two given strings are anagram of each other or not.
 * An anagram of a string is another string that contains same characters, only the order of characters can be different. 
 * For example, “act” and “tac” are anagram of each other.
 */

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		BufferedReader reader =  
                   new BufferedReader(new InputStreamReader(System.in)); 
		try {
		int t = Integer.parseInt(reader.readLine().trim());
		
		while(t-->0) {
		    String s[]= reader.readLine().split("\\s");
		    
		    char c1[] = s[0].toCharArray(); char c2[] = s[1].toCharArray();
		    
		    Arrays.sort(c1); Arrays.sort(c2);
		    
		    String s1 = Arrays.toString(c1);
		    String s2 = Arrays.toString(c2);
		    
		    System.out.println(s1.equals(s2) ? "YES" : "NO");
		}
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
	}
}