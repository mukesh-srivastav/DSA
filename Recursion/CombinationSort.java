package Recursion;

import java.util.*;

class CombinationSort {
    static boolean is= false;
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-->0) {
		    int n = sc.nextInt();
		    int a[] = new int[n];
		    for(int i=0; i<n; i++)
		        a[i] = sc.nextInt();
		    int k = sc.nextInt();
		    is = false;
		    unique(a, k);
		    if (is == false)
		        System.out.print("Empty");
		    System.out.println();
        }
        sc.close();
	}
	
	static void unique(int a[], int k) {
	    Arrays.sort(a);
	    
	    Vector<Integer> local = new Vector<Integer>();
	    
	    combination(0, 0, k, local, a);
	}
	
	static void combination(int l, int sum, int k, Vector<Integer>local, int[] a) {
	    
	    if (sum == k) {
	        System.out.print("("); 
    		for (int i = 0; i < local.size(); i++) 
    		{
    			System.out.print(local.get(i)); 
    			if (i != local.size() - 1) 
    				System.out.print(" "); 
    			
    			is = true;
    		}
    		System.out.print(")"); 
		    return; 
	    }
	    
	    for (int i=l; i<a.length; i++) {
	        if (sum + a[i] > k)
	            continue;
	        
	        if (i>l && a[i] ==a[i-1])
	            continue;
	        
	        local.add(a[i]);
	        
	        combination(i+1, sum+a[i], k, local, a);
	        local.remove(local.size()-1);
	    }
	}
}