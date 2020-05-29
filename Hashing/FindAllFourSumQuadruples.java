package Hashing;
import java.util.*;
/**
 * Given an array A of size N, find all combination of four elements in the array whose sum is equal to a given value K. For example, if the given array is {10, 2, 3, 4, 5, 9, 7, 8} and K = 23, one of the quadruple is “3 5 7 8” (3 + 5 + 7 + 8 = 23).
The output should contain only unique quadrples  For example, if input array is {1, 1, 1, 1, 1, 1} and K = 4, then output should be only one quadrple {1, 1, 1, 1}.
Note: Print -1 if no such quadruple is found. 
Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two lines. The first line of input contains two integers N and K. Then in the next line are N space separated values of the array.
Output:
For each test case in a new line print all the quadruples present in the array separated by space which sums up to value of K. Each quadruple is unique which are separated by a delimeter "$" and are in increasing order.
Example:
Input:
2
5 3
0 0 2 1 1 
7 23
10 2 3 4 5 7 8

Output:
0 0 1 2 $
2 3 8 10 $2 4 7 10 $3 5 7 8 $
 */
public class FindAllFourSumQuadruples {
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-->0) {
		    int n= sc.nextInt();
		    int target = sc.nextInt();
		    
		    int a[] = new int[n];
		    
		    for (int i=0; i<n; i++) {
		        a[i] = sc.nextInt();
		    }
		    Arrays.sort(a);
		    
		    HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
		    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		    
		    for (int i=0; i<n; i++) { // First number
		        for (int j=i+1; j<n; j++) { // Second number
		            int k = j+1;
		            int l = n-1;
		            
		            // For third and fourth we use binary search 2 pointers.
		            while (k<l) {
		                int sum = a[i] + a[j] + a[k] + a[l]; 
		                
		                if (sum > target)
		                    l--;
		                else if (sum < target)
		                    k++;
		                else {
		                    ArrayList<Integer> item = new ArrayList<Integer>();
		                    
		                    item.add(a[i]);
		                    item.add(a[j]);
		                    item.add(a[k]);
		                    item.add(a[l]);
		                    
		                    if (hs.contains(item) == false) {
		                        hs.add(item);
		                        result.add(item);
		                    }
		                    k++;
		                    l--;
		                }
		            }
		        }
		    }
		    int size = result.size(); 
		    if (size > 0) {
		        for (int i= 0; i<size; i++) {
		            ArrayList<Integer> item = result.get(i);
		            System.out.print(item.get(0) + " "
		            + item.get(1) + " " 
		            + item.get(2) + " " 
		            + item.get(3) + " $");
		        }
		    } else {
		        System.out.print(-1);
		    }
		    System.out.println();
		    
        }   
        sc.close();
	}
}