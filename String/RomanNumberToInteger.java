/**
 * Given an string in roman no format (s)  your task is to convert it to integer .
 * 1<=roman no range<4000
 */

import java.util.*;
import java.io.*;

class GFG {
    // This function returns value of a Roman symbol 
static int value(char r) 
{ 
    if (r == 'I') 
        return 1; 
    if (r == 'V') 
        return 5; 
    if (r == 'X') 
        return 10; 
    if (r == 'L') 
        return 50; 
    if (r == 'C') 
        return 100; 
    if (r == 'D') 
        return 500; 
    if (r == 'M') 
        return 1000; 
  
    return -1; 
} 
  
// Returns decimal value of roman numaral 
static int romanToDecimal(String str) 
{ 
    // Initialize result 
    int res = 0; 
  
    // Traverse given input 
    for (int i=0; i<str.length(); i++) 
    { 
        // Getting value of symbol s[i] 
        int s1 = value(str.charAt(i)); 
  
        if (i+1 < str.length()) 
        { 
            // Getting value of symbol s[i+1] 
            int s2 = value(str.charAt(i+1)); 
  
            // Comparing both values 
            if (s1 >= s2) 
            { 
                // Value of current symbol is greater 
                // or equal to the next symbol 
                res = res + s1; 
            } 
            else
            { 
                res = res + s2 - s1; 
                i++; // Value of current symbol is 
                     // less than the next symbol 
            } 
        } 
        else
        { 
            res = res + s1; 
             
        } 
    } 
    return res; 
} 
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0) {
		    String s = sc.next();
		    System.out.println(romanToDecimal(s));
		}
	}
}

