/**
 * Given two strings a and b. The task is to find if a string 'a' can be obtained by rotating another string 'b' by 2 places.
 * i/p=> 2 amazon azonam geeksforgeeks geeksgeeksfor
 * o/p=> 1 0
 */
import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		    String s1 = sc.next();
		    String s2 = sc.next();
		    
		    if((s1.substring(s1.length()-2) + s1.substring(0, s1.length()-2)).equals(s2) || (s1.substring(2) + s1.substring(0, 2)).equals(s2))
		        System.out.println(1); 
		    else 
		        System.out.println(0); 
		}
	}
}