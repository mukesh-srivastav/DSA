package DynamicProgramming;
/**
 * Given two strings X and Y. The task is to find the length of the longest common substring.
 */
import java.util.*;
public class LongestCommonSubstring {
    public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    String s1 = sc.next();
		    String s2 = sc.next();
		    
		    System.out.println(longestCommonSubstring(s1, s2, n, m));
		}
		
		sc.close();
	}
	
	static int longestCommonSubstring(String s1, String s2, int n, int m) {
	    if (n==0 || m==0)
	        return 0;
	        
	    int dp[][] = new int[n+1][m+1];
	    
	    for (int i=0; i<=n; i++) {
	        dp[i][0] = 0;
	    }
	    
	    for (int i=0; i<=m; i++) {
	        dp[0][i] = 0;
	    }
	    
	    int maxLength= 0;
	    for (int i=1; i<=n; i++) {
	        for (int j=1; j<=m; j++) {
	            if (s1.charAt(i-1) == s2.charAt(j-1)) {
	                dp[i][j] = 1 + dp[i-1][j-1];
	            } else {
	                dp[i][j] = 0;
	            }
	            
	            maxLength = Math.max(maxLength, dp[i][j]);
	        }
	    }
	    
	   // for (int i=0; i<=n; i++) {
	   //     for (int j=0; j<=m; j++) {
	   //         System.out.print(dp[i][j] + " ");       
	   //     }
	   //     System.out.println();
	   // }
	    
	    return maxLength;
	}
}