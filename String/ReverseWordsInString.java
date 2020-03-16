/**
 * Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.
 * i.e. i.like.this.program.very.much to much.very.program.this.like.i
 */
/*package whatever //do not write package name here */

import java.util.*;
import java.io.*;

class ReverseWordsInString {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in); 
		int t = sc.nextInt(); 
		while(t-->0) {
		    String s = sc.next();
		    String a[] = s.split("\\.");
		    
		    String res = "";
		    for (int i = 0; i < a.length; i++) {
                res = a[i] + "." + res;
            }
  
		    System.out.println(res.replaceAll("\\.+$", ""));
		}
	}
}

