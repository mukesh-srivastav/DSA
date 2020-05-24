package Hashing;
import java.util.*;
/**
 * Given a string S and text T. Output the smallest window in the string S having all characters of the text T. Both the string S and text T contains lowercase english alphabets.
 * Output the smallest window of the string containing all the characters of the text. If such window doesn`t exist or this task can not be done then print -1.
 */
public class SmallestSubsequenceWindow {
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    String s1 = sc.next();
		    String s2 = sc.next();
		    
		    System.out.println(smallestSubstringWindow(s1,s2));
		}
	}
	
	static String smallestSubstringWindow(String s1, String s2)
	{
	    int n = s1.length();
        int m = s2.length();
        
        // check if string's length is less than pattern's 
        // length. If yes then no such window can exist 
        if (n<m)
            return "" + -1;
	    
	    int str_count[] = new int[256];
	    int pat_count[] = new int[256];
        
         // store occurrence ofs characters of pattern 
	    for (int i=0; i<m;i++) {
	        pat_count[s2.charAt(i)]++;
	    }
	    
	    int start =0, start_index = -1, min_length = Integer.MAX_VALUE, count = 0;
	    
	    for (int i=0; i<n; i++) {
	        char c = s1.charAt(i);
            
            // count occurrence of characters of string 
            str_count[c]++;
            
            // If string's char matches with pattern's char 
            // then increment count 
	        if (pat_count[c]!=0 && str_count[c] <= pat_count[c])
                count++;
                
	        // if all the characters are matched  
	        if (count == m) {
                // Try to minimize the window i.e., check if 
                // any character is occurring more no. of times 
                // than its occurrence in pattern, if yes 
                // then remove it from starting and also remove 
                // the useless characters. 
	            while (str_count[s1.charAt(start)] > pat_count[s1.charAt(start)]
	            || pat_count[s1.charAt(start)]==0) {
	                if (str_count[s1.charAt(start)] > pat_count[s1.charAt(start)])
	                    str_count[s1.charAt(start)]--;
	                start++;
	            }
	            int len_window = i - start +1;
	            // update window size 
	            if (len_window < min_length) {
	                start_index = start;
	                min_length = len_window;
	            }
	        }
	    }
	    // If no window found 
	    if (start_index ==-1) {
	        return "" + -1;
	    } else {
	        return s1.substring(start_index, start_index + min_length);
	    }
	}
}