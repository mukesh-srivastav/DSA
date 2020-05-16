package Hashing;

import java.util.*;

/**
 * Given two arrays of integers, write a program to check if a pair of values (one value from each array) exists such that swapping the elements of the pair will make the sum of two arrays equal.
 * Explanation: 
 * sum1 - x + y = sum2 - y + x
 * 2(y - x) = sum2 - sum1
 * 2(y - x) = diff
 * y = x + diff/2
 * So, first of all if there is difference in sum then it should be divisible by 2 else its not possible and return -1. And if the difference is divisible by 2 then iterate over array with smaller sum and find a entry in map which is equal to arr[i] + (diff/2)
 */
public class SwappingPairsMakeSumEqual {
    public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int a1 [] = new int[n];
		    int a2 [] = new int[m];
		    int sum1 = 0;
		    int sum2 = 0;
		    HashSet<Integer> hs1 = new HashSet<Integer>();
		    HashSet<Integer> hs2 = new HashSet<Integer>();
		    
		    for (int i=0; i<n; i++) {
		        a1[i] = sc.nextInt();
		        sum1 += a1[i];
		        hs1.add(a1[i]);
		    }
		    
		    for (int i=0; i<m; i++) {
		        a2[i] = sc.nextInt();
		        sum2 += a2[i];
		        hs2.add(a2[i]);
		    }
		    
		    if (sum1 - sum2 == 0) {
		        System.out.println(1);
		        continue;
		    }
		    int diff = Math.abs(sum1 - sum2);
		    int set = 0;
		    if (diff %2 ==0) {
    		    int [] a = (sum1 > sum2) ? a2 : a1;
    		    HashSet<Integer> hs = (sum1 > sum2) ? hs1: hs2;
    		    
    		    for (int i=0; i<a.length; i++) {
    		        if (hs.contains(a[i] + diff/2)) {
    		            System.out.println(1);
    		            set = 1;
    		            break;
    		        }
    		    }
		    }
		    if (set == 0)
		        System.out.println(-1);
        }
        sc.close();
	}
}