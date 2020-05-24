package Hashing;

import java.util.Scanner;
/**
 * Given a string s which contains lower alphabetic characters, the task is to check if its possible to remove at most one character from this string in such a way that frequency of each distinct character becomes same in the string.
 * For each test case in a new line print 1 if its possible to make frequencies of all characters equal else print 0.
 * Example:
Input:
2
xyyz
xxxxyyzz

Output:
1
0
 */
public class CheckFrequencies {
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    String s = sc.next();
		    int n = s.length();
		    int a[] = new int[26];
		    
		    for (int i=0; i<n;i++)
		        a[s.charAt(i) - 'a']++;
		        
		    int minFreq = Integer.MAX_VALUE, maxFreq = Integer.MIN_VALUE;
		    for (int i=0; i<26; i++) {
		        if (a[i]!=0 && minFreq > a[i])
		            minFreq = a[i];
		        if (a[i]!=0 && maxFreq < a[i])
		            maxFreq = a[i];
		    }
		    
		    int greaterThanMinCount = 0;
		    int smallerThanMaxCount = 0;
		    for (int i=0; i<26; i++) {
		        if (a[i]!=0 && minFreq < a[i])
		            greaterThanMinCount +=  (a[i] - minFreq);
		        if (a[i]!=0 && maxFreq > a[i])
		            smallerThanMaxCount +=  (maxFreq - a[i]);
		    }
		    
		    
		    if ( greaterThanMinCount <=1 || smallerThanMaxCount <= 1)
		        System.out.println(1);
		    else
		        System.out.println(0);
        }
        sc.close();
	}
}