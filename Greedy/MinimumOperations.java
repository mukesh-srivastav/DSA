package DynamicProgramming;
/**
 * You are given a number N. You have to find the number of operations required to reach N from 0. You have 2 operations available:

Double the number
Add one to the number
Example:
Input:
2
8
7
Input:
4
5

Explanation:
Testcase1:
Input  : N = 8
Output : 4
0 + 1 = 1, 1 + 1 = 2, 2 * 2 = 4, 4 * 2 = 8
Testcase2:
Input  : N = 7
Output : 5
0 + 1 = 1, 1 + 1 = 2, 1 + 2 = 3, 3 * 2 = 6, 6 + 1 = 7
 */
import java.util.*;
public class MinimumOperations {
    public static void main (String[] args) {
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    
		    System.out.println(minimumOperations(n));
        }
        sc.close();
	}
	
	static int minimumOperations(int n)
	{
	    if (n == 0) return 0;
	    int count =0;
	    
	    while (n!=0) {
	        if (n%2==0)
	            n = n/2;
	        else
	            n = n-1;
	        count++;
	    }
	    
	    return count;
	}
}