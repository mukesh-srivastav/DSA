package Hashing;

import java.util.*;

/**
 * Given two arrays: arr1[0..m-1] of size m and arr2[0..n-1] of size n. Task is to check whether arr2[] is a subset of arr1[] or not. Both the arrays can be both unsorted or sorted. It may be assumed that elements in both array are distinct.
 * Example:
Input:
3
6 4
11 1 13 21 3 7
11 3 7 1
6 3
1 2 3 4 5 6
1 2 4
5 3
10 5 2 23 19
19 5 3

Output:
Yes
Yes
No
 */
class ArraySubsetOfAnotherArray {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    
		    int a [] = new int[n];
		    int b [] = new int[m];
		    
		    HashSet<Integer> hs = new HashSet<Integer>();
		    
		    for (int i=0; i<n; i++) {
		        a[i] = sc.nextInt();
		        hs.add(a[i]);
		    }
		    int i = 0;
		    int flag = 0;
		    for (i=0; i<m; i++) {
		        b[i] = sc.nextInt();
		    }
		    
		    for (i=0; i<m; i++) {
		        if (hs.contains(b[i]) == false) {
		            System.out.println("No");
		            flag = 1;
		            break;
		        }
		    }
		    if (flag == 0)
		        System.out.println("Yes");
		    
        }
        sc.close();
	}
}