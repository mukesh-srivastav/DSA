package Recursion;

import java.util.*;
/**
 * https://qr.ae/pNyyoZ
 * 
 * Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person is killed in circle in a fixed direction.​
The task is to choose the safe place in the circle so that when you perform these operations starting from 1st place in the circle, you are the last one remaining and survive.
 */
public class JosephusProblem {
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0) {
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    
		    System.out.println(josephusRecursive(n,k));
        }
        
        sc.close();
	}
	
	static int josephusRecursive(int n, int k) {
	    return josephusHelp(n, k) + 1;
	}
	
	static int josephusHelp(int n, int k) {
	    if (n == 1)
	        return 0;
	    
	    return ((josephusHelp(n-1, k) + k) %n); 
    }
    
    static int josephusDP(int n, int k)
    {
        int result = 0;
        
        for (int i=2; i<=n; i++) {
            result = (result + k)%i;
        }
        
        return result+1;
    }
}