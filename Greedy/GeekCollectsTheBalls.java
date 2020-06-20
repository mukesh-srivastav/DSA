package Greedy;
import java.util.*;

/**
 * There are two parallel roads, each containing N and M buckets, respectively. Each bucket may contain some balls. The buckets on both roads are kept in such a way that they are sorted according to the number of balls in them. Geek starts from the end of the road which has the bucket with a lower number of balls(i.e. if buckets are sorted in increasing order, then geek will start from the left side of the road).
The geek can change the road only at the point of intersection(which means, buckets with the same number of balls on two roads). Now you need to help Geek to collect the maximum number of balls.

 Take for example the following two sequences where intersection points are
printed in bold:

First= 3 5 7 9 20 25 30 40 55 56 57 60 62
Second= 1 4 7 11 14 25 44 47 55 57 100
You can ‘walk” over these two sequences in the following way:

You may start at the beginning of any of the two sequences. Now start moving forward.
At each intersection point, you have the choice of either continuing with the same sequence you’re currently on, or switching to the other sequence.
The objective is ﬁnding a path that produces the maximum sum of data you walked over. In the above example, the largest possible sum is 450, which is the result of adding 3, 5, 7, 9, 20, 25, 44, 47, 55, 56, 57, 60, and 62

Example:
Input:
1
5 5
1 4 5 6 8
2 3 4 6 9

Output:
29

Explanation:

The path with maximum sum is (2,3,4)[5,6](9). Integers in [] are the buckets of first road and in () are the buckets of second road. So, max balls geek can collect is 29.

Reference: https://hackerranksolutionc.blogspot.com/2019/02/collects-balls-between-two-roads.html
https://www.spoj.com/problems/ANARC05B/
 */
public class GeekCollectsTheBalls {
    public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int a[] = new int[n];
		    int b[] = new int[m];
		    
		    for (int i=0; i<n; i++) {
		        a[i] = sc.nextInt();
		    }
		    
		    for (int i=0; i<m; i++) {
		        b[i] = sc.nextInt();
		    }
		    
		    System.out.println(geekCollectsTheBalls(a, n, b, m));
		}
		sc.close();
	}
	
	static int geekCollectsTheBalls(int []a, int n, int []b, int m)
	{
	    int i=0, j=0, first=0, second=0, res=0;
	    // Traverse both arrays.
	    while (i<n && j < m) {
            // Keep total of each list until it hits a common element. 
	        if (a[i] < b[j]) {
	            first += a[i++];
	        } else if (a[i] > b[j]) {
	            second += b[j++];
	        } else {
                // Now check whichever is maximum + current element.
	            res += Math.max(first, second) + a[i];
                
                // Reset the counters.
	            first = 0; 
	            second = 0;
	            int temp = a[i];
	            i++; j++;
                
                // These are scenarios to handle situations like this: 
                // 1 2 4 4 4, 2 3 4 4 4
                // 1 2 4 4 4, 2 3 4 5 6
                // 1 2 3 4 5, 2 3 4 4 4
                while (i< n && j<m && a[i] == temp && b[j] == temp) {
	                res += a[i];
	                i++; j++;
                }
	        }
	    }
	    
	    while (i < n)
	        first += a[i++];
	    
	    while (j < m)
	        second += b[j++];
	    
	    return res + Math.max(first, second);
	}
}