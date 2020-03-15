/**
 * Given a string S consisting only '0's and '1's,  print the last index of the '1' present in it.
 */
/*package whatever //do not write package name here */

import java.util.*;
import java.io.*;

class LastIndexOfOne {
	public static void main (String[] args) {
		//code
			Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		    int in = -1;
		    String s = sc.next();
		    for(int i=s.length()-1; i>=0;i--) {
		        if (Integer.parseInt("" + s.charAt(i)) == 1) {
		            System.out.println(i);
		            in = i; break;
		        }
		    }
		    if(in == -1)
		      System.out.println(-1);  
		}
	}
}