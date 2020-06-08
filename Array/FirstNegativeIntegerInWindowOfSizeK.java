package Array;
import java.util.*;
/**
 * Given an array and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k.
 * Time: O(n)
 * Space: O(k)
 */
public class FirstNegativeIntegerInWindowOfSizeK {
    public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    int a[] = new int[n];
		    
		    for (int i=0; i<n; i++) {
		        a[i] = sc.nextInt();
		    }
		    
		    int k = sc.nextInt();
		    
		    int curr = 0;
		    LinkedList<Integer> di = new LinkedList<Integer>();
		    
		    for (int i=0; i<k; i++) {
		        if (a[i] < 0)
		            di.add(i);
		    }
		    
		    for (int i=k; i<n; i++) {
		        if (di.isEmpty())
		            System.out.print(0 + " ");
		        else
		            System.out.print(a[di.peek()] + " ");
		           
		        if (di.isEmpty() == false && di.peek() < i - k+1)
		            di.remove();
		            
		        if (a[i] < 0)
		            di.add(i);
		    }
		    
		    if (di.isEmpty())
    		    System.out.println(0);
    		else
    		    System.out.println(a[di.peek()]);
		}
	}
}