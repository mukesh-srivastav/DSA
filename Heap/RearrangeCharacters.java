package Heap;

import java.util.*;
import java.io.*;

/**
 * Given a string S with repeated characters (only lowercase). The task is to rearrange characters in a string such that no two adjacent characters are same.
 * Note : It may be assumed that the string has only lowercase English alphabets.
 * For each test case in a new line print "1" (without quotes) if the generated string doesn't contains any same adjacent characters,
 * else if no such string is possible to be made print "0" (without quotes).
 */
class Key {
    int freq;
    char val;
    
    Key(int freq, char val) {
        this.freq = freq;
        this.val  = val;
    }
}

class KeyComparator implements Comparator<Key> {
    public int compare(Key k1, Key k2) {
        if (k1.freq < k2.freq)
            return 1;
        else if (k1.freq > k2.freq)
            return -1;
        else
            return 0;
    }
}


public class RearrangeCharacters {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-->0) {
		    String s = sc.next();
		    System.out.println(rearrangedString(s));
        }

        sc.close();
	}
	
	static int rearrangedString(String s) {
	    PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator()); 
	    
	    int n = s.length();
	    
	    int count[] = new int[26];
	    
	    for (int i=0; i<n; i++) {
	        count[s.charAt(i) - 'a']++;
	    }
	    
	    for (char c='a'; c<='z'; c++) {
	        int val = c - 'a';
	        
	        if(count[val]>0) {
	            pq.add(new Key(count[val], c));
	        }
	    }
	    
	    String str = "";
	    Key prev = new Key(-1, '#');
	    
	    while(pq.size() != 0) {
	        Key k = pq.peek();
	        pq.poll();
	        str = str + k.val;
	        
	        if (prev.freq > 0) {
	            pq.add(prev);
	        }
	        
	        (k.freq)--;
	        prev = k;
	    }
	    
	    if (n!=str.length())
	        return 0;
	    else
	        return 1;
	}
}