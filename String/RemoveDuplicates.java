/**
 * Given a string, the task is to remove duplicates from it. 
 * Expected time complexity O(n) where n is length of input string and extra space O(1) under the assumption that there are total 256 possible characters in a string.
 * Note: that original order of characters must be kept same. 
 * i/p  geeksforgeeks o/p geksfor
 * 
 */


import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		//code
		//Scanner sc = new Scanner(System.in); 
		BufferedReader reader =  
                   new BufferedReader(new InputStreamReader(System.in)); 
		try {
		int t = Integer.parseInt(reader.readLine().trim());
		
		while(t-->0) {
		    String s= reader.readLine();    
		    
		    String count = removeDups(s, s.length());
		    
		    System.out.println(count);
		}
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
	}
	
	static String removeDups(String s, int n)
	{
	    int a[] = new int[256];
	    char c[] = s.toCharArray();
	   // for(int i=0; i<n; i++) {
	   //     a[c[i]]++;
	   // }
	    
	    String res = "";
	    for (int i=0;i<n; i++) {
	        if(a[(int)c[i]]==0) {
	            res += c[i];
	            a[(int)c[i]]++;
	        }
	       // } else if(a[c[i]]>1) {
	       //     a[c[i]]--;
	       // }
	    }
	    
	    return res;
	}
	
	// Method to remove duplicates 
	static char[] removeDuplicatesFromString(String string) 
	{ 
		//table to keep track of visited characters 
		int[] table = new int[256]; 
		char[] chars = string.toCharArray(); 

		//to keep track of end index of resultant string 
		int endIndex = 0; 
	
		for(int i = 0; i < chars.length; i++) 
		{ 
			if(table[chars[i]] == 0) 
			{ 
				table[chars[i]] = -1; 
				chars[endIndex++] = chars[i]; 
			} 
		} 
	
		return Arrays.copyOfRange(chars, 0, endIndex); 
	} 
}