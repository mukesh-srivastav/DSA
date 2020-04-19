package Heap;

import java.util.*;

public class FindMedianInStream {
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		
		PriorityQueue<Integer> left = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<Integer>();
		int m =0; 
		
		for(int i=0; i<n; i++) {
		    a[i] = sc.nextInt();
		    m = findMedian(a[i], m, left, right);
		    System.out.println(m);
        }
        
        sc.close();
	}
	
	static int findMedian( int e, int m,
	   PriorityQueue<Integer> left,
	   PriorityQueue<Integer> right ) {
	    
	    int c = sigNum(left.size(), right.size());
	    
	    switch (c) {
	        case -1: // Right is big 
	            if (e < m) {
	                left.add(e);
	            } else {
	                left.add(right.poll());
	                right.add(e);
	            }
	            m = (left.peek() + right.peek()) / 2;
	            break;
	       case 0: // Both are equal size
	           if (e<m) {
	               left.add(e);
	               m = left.peek();
	           } else {
	               right.add(e);
	               m = right.peek();
	           }
	           break;
	       case 1: // Left is big. 
	           if (e<m) {
	               right.add(left.poll());
	               left.add(e);
	           } else {
	               right.add(e);
	           }
	           m = (left.peek() + right.peek()) / 2;
	           break;
	    }
	    
	    return m;
	}
	
	static int sigNum(int a, int b) {
	    if (a==b) return 0;
	    
	    return (a<b) ? -1 : 1;
	}
}