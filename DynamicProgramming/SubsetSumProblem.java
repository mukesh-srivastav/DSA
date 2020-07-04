package DynamicProgramming;
import java.util.*;
/**
 * Given a set of numbers, check whether it can be partitioned into two subsets such that the sum of elements in both subsets is same or not.
 * Example:
Input:
2
4
1 5 11 5
3
1 3 5 

Output:
YES
NO

Explanation:
Testcase 1: There exists two subsets such that {1, 5, 5} and {11}.
 */
public class SubsetSumProblem {
    public static void main (String[] args) {
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    int a[] = new int[n];
		    int sum = 0;
		    for (int i=0; i<n; i++) {
		        a[i] = sc.nextInt();
		        sum += a[i];
		    }
		    
		    System.out.println(subsetSum(a,n, sum));
        }
        sc.close();
	}
	
	static String subsetSum(int a[], int n, int sum)
	{
	    if (sum % 2 != 0) {
	        return "NO";
	    }
	    
	    sum = sum /2;
	    
	    if (n == 0 && sum != 0)
	        return "NO";
	        
	    boolean dp[][] = new boolean[2][sum+1];
	    
	    for (int i=0; i<=n; i++) {
	        for (int j=0; j<=sum; j++) {
	            if (j==0)
	                dp[i%2][j] = true;
	            else if (i==0)
	                dp[i%2][j] = false;
	            else if (a[i-1] <= j)
	                dp[i%2][j] = dp[(i+1)%2][j - a[i-1]] || dp[(i+1)%2][j];
	            else
	                dp[i%2][j] = dp[(i+1)%2][j];
	        }
	    }
	    
	    return (dp[n%2][sum]) ? "YES" : "NO";
	    
	}
}