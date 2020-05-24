package Hashing;
import java.util.*;

/**
 * Find and print the uncommon characters of the two given strings S1 and S2. Here uncommon character means that either the character is present in one string or it is present in other string but not in both. The strings contains only lowercase characters and can contain duplicates.
 * For each testcase, in a new line, print the uncommon characters of the two given strings in sorted order.
 */
public class UncommonCharacters {
    public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    String s1 = sc.next();
		    String s2 = sc.next();
		    
		    int f1[] = new int[26];
		    int f2[] = new int[26];
		    
		    int n = s1.length();
		    int m = s2.length();
		    
		    for (int i=0; i<n; i++) {
		        f1[s1.charAt(i) - 'a']++;
		    }
		    
		    for (int i=0; i<m; i++) {
		        f2[s2.charAt(i) - 'a']++;
		    }
		    
		    String res = "";
		    
		    for (int i=0; i<26; i++) {
		        if ((f1[i]==0 && f2[i]!=0) || (f2[i]==0 && f1[i]!=0)) {
		            res = res + (char)(i+97);
		        }
		    }
		    System.out.println(res);
        }
        sc.close();
	}   
}