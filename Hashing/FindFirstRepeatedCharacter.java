package Hashing;

import java.util.*;

/**
 * Given a string S. The task is to find the first repeated character in it. We need to find the character that occurs more than once and whose index of second occurrence is smallest. S contains only lowercase letters.
 * Example:
Input:
2
geeksforgeeks
hellogeeks

Output:
e
l
 */
public class FindFirstRepeatedCharacter {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    
		    
		    String s = sc.next();
		    char a [] = s.toCharArray();
		    int n = a.length;
		    
		    HashSet<Character> hs = new HashSet<Character>();
		    int f = 0;
		    for (int i=0; i<n; i++) {
		        
		        if (hs.contains(a[i]) == false) {
		            hs.add(a[i]);
		        } else {
		            if (f==0) {
		                System.out.print(a[i]);
		                f=1;
		            }
		        }
		    }
		    if (f==0) {
		        System.out.print(-1);
		    }
		    System.out.println();
        }
        sc.close();
	}
}