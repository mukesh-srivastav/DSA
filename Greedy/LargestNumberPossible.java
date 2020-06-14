package Greedy;
import java.util.Scanner;

/**
 * Given two numbers 'N' and 'S' , find the largest number that can be formed with 'N' digits and whose sum of digits should be equals to 'S'.
 * Print the largest number that is possible.If their is no such number, then print -1 
 * Expected Time Complexity: O(n)
 * Example: 
Input:
2
2 9
3 20
Output: 
90
992 

 */
public class LargestNumberPossible {
    public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    int s = sc.nextInt();
		    System.out.println(largestNumberPossible(n, s));
		}
		sc.close();
	}
	
	static String largestNumberPossible(int n, int sum) {
	    String s = "";
	    
	    if (sum == 0 || n == 0 || n*9 < sum)
	        return s + "-1";
	    
	    while(n>0 && sum>=0) {
	        if (sum >=9) {
	            s += "9";
	            n--;
	            sum -= 9;
	        } else {
	            s += sum;
	            sum=0;
	            n--;
	        }
	    }
	    
	    return s;
	}
}