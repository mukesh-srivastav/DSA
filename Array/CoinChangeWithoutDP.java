package Array;

/**
 * Given a value N, total sum you have. You have to make change for Rs. N, and there is infinite supply of each of the denominations in Indian currency, i.e., you have infinite supply of { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000} valued coins/notes, Find the minimum number of coins and/or notes needed to make the change for Rs N.
 * Example:
Input:
1
43

Output:
20 20 2 1

Explanation:
Testcase 1: Sum of Rs 43 can be changed with minimum of 4 coins/ notes 20, 20, 2, 1.


 */
public class CoinChangeWithoutDP {
    static void coinChange(int n)
	{
	    if (n <= 1) {
	        System.out.print(1);
	        return;
	    }
	    
	    int coins[] = new int[] {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
	    int i = 0;
	    while (n > 0 && i<coins.length) {
	        if (n >= coins[i]) {
	            int d = n/coins[i];
	            for (int index=0; index<d; index++) {
	               System.out.print(coins[i] + " "); 
	            }
	            n = n - d * coins[i];
	        }
	        i++;
	    }
	    return;
	}
}