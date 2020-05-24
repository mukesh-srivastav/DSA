package Hashing;
import java.util.*;

/**
 * Given a string str and another string patt. Find the character in patt that is present at the minimum index in str. If no character of patt is present in str then print ‘No character present’.
 * Example:
Input:
2
geeksforgeeks
set
adcffaet
onkl

Output:
e
$
 */
public class MinimumIndexedCharacter {
    public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {  
		    
		    String s1 = sc.next();
		    String s2 = sc.next();
		    HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		    int flag=0;
		    
		    for (int i=0; i<s1.length(); i++) {
		        char c = s1.charAt(i);
		        if (hm.containsKey(c) == false) {
		            hm.put(c, i);
		        }
		    }
		    
		    String res=""; int index = Integer.MAX_VALUE;
		    for (int i=0; i<s2.length(); i++) {
		        char c = s2.charAt(i);
		        if (hm.containsKey(c)) {
		            if (hm.get(c) < index) {
		                res = Character.toString(c);
		                index = hm.get(c);
		                flag = 1;
		            }
		        }
		    }
		    
		    if (flag==0)
		        System.out.println("$");
		    else {
		        System.out.println(res);
		    }
        }
        sc.close();
	} 
}