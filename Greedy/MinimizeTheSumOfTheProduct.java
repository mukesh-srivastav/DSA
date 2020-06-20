package Greedy;
import java.util.*;

public class MinimizeTheSumOfTheProduct {
    public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    
		    long a[] = new long[n];
		    long b[] = new long[n];
		    
		    for (int i=0; i<n; i++) {
		        a[i] = sc.nextLong();
		    }
		    
		    for (int i=0; i<n; i++) {
		        b[i] = sc.nextLong();
		    }
		    
		    System.out.println(minimizeTheSumOfProducts(a, b, n));
		}
		sc.close();
	}
	
	static long minimizeTheSumOfProducts(long a[], long b[], int n) {
	    Arrays.sort(a);
	    Arrays.sort(b);
	    
	    long res = 0;
	    for (int i=0; i<n; i++) {
	        res += a[i] * b[n - i - 1];
	    }
	    
	    return res;
	}
}