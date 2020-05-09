package Recursion;
/**
 * Imagine you have a special keyboard with the following keys: 
Key 1:  Prints 'A' on screen
Key 2: (Ctrl-A): Select screen
Key 3: (Ctrl-C): Copy selection to buffer
Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed. If you can only press the keyboard for N times (with the above four keys), write a program to produce maximum numbers of A's. That is to say, the input parameter is N (No. of keys that you can press), the output is M (No. of As that you can produce).

https://www.ideserve.co.in/learn/print-maximum-number-of-a-using-four-keys-of-special-keyboard
 */
import java.util.*;
public class SpecialKeyboard {
    
    static int MAX = 75;
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		    int n = sc.nextInt();
		    int max[] = new int[MAX];
		    Arrays.fill(max, -1);
		    System.out.println(findMaxAs(n, max));
        }
        sc.close();
	}
	
	static int findMaxAs(int n, int max[]) 
	{
	    if (n<7) return n;
	    if (n>75) return -1;
        
        /**
        * f(N) = N if N < 7
        *      = max{2*f(N-3), 3*f(N-4),..., (N-2)*f(1)}
        */   
        
        int max_so_far = 0, max_with_this_i = 0, multiplier = 2;
	    
	    for (int i= n-3; i>=0; i--) {
	        if (max[i] == -1) {
	            max[i] = findMaxAs(i, max);
	        }
	        
	        max_with_this_i = multiplier * max[i];
	        
	        if (max_with_this_i > max_so_far) {
	            max_so_far = max_with_this_i;   
	        }
	        multiplier +=1;
	    }
	    
	    return max_so_far;
	}
}