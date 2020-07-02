package DynamicProgramming;

/**
 * Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.

Insert
Remove
Replace
All of the above operations are of cost=1.
Both the strings are of lowercase.
Example:
Input:
1
4 5
geek gesek

Output:
1
 */
import java.util.*;
public class EditDistance {
    public static void main (String[] args) {
		//code
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n1 = sc.nextInt();
		    int n2 = sc.nextInt();
		    String s1 = sc.next(); 
		    String s2 = sc.next();
		    System.out.println(editDistance(s1, s2, n1, n2));
        }
        sc.close();
	}
	
	static int editDistance(String s1, String s2, int m, int n) {
	    
	    int dp[][] = new int[m+1][n+1];
	    //one string on y-axis the other on x-axis.
	    
	    //Fill first column with the len of string at that point.
	    //BECAUSE at 0 we have empty string and the no.of edits for any string 
	    //compared to an empty string is equal to len of string.
	    for(int i=0;i<=m;i++)
	        dp[i][0] = i;   
	
	    //Fill first row similarly.
	    for(int i=0;i<=n;i++)
	        dp[0][i] = i;
	        
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
            //If the characters are equal, then take value of prev diagonal value.(Since we dont have to make any edits value remains same)
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                
                else //Take min of topcell(Insert),leftcell(Remove) and diagonal cell(Replace) and ADD ONE.
                {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        
        
        
        return dp[m][n]; //Returns edits considering total length of both strings.
	}
}