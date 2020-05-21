package Hashing;

import java.util.*;

public class CommonElements {
    public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-->0) {
		    int n1= sc.nextInt();
		    int n2= sc.nextInt();
		    int n3= sc.nextInt();
		    
		    int a1[] = new int[n1];
		    int a2[] = new int[n2];
		    int a3[] = new int[n3];
		    
		    
		    for (int i=0; i<n1; i++) {
		        a1[i] = sc.nextInt();
		    
		    }
		    
		    for (int i=0; i<n2; i++) {
		        a2[i] = sc.nextInt();
		    }
		    
		    for (int i=0; i<n3; i++) {
		        a3[i] = sc.nextInt();
		    }
		    
		    LinkedHashSet<Integer> list = findCommon(a1, a2, a3, n1, n2, n3);
		    
		    if (list.size() > 0) {
		    Iterator<Integer> it = list.iterator();
		    
		    while(it.hasNext()) {
		        System.out.print(it.next() + " ");
		    }
		        
		    } else {
		        System.out.print(-1);
		    }
		    
		    System.out.println();
        }
        sc.close();
	}
	
	static LinkedHashSet<Integer> findCommon(int a1[], int a2[], int a3[], int n1, int n2, int n3)
	{
	    int i=0, j=0, k=0;
	    LinkedHashSet<Integer> list = new LinkedHashSet<Integer>();
	    while (i<n1 && j<n2 && k<n3) {
	        if (a1[i] == a2[j] && a2[j] == a3[k]) {
	            list.add(a1[i]);
	            i++; j++; k++;
	        } else if (a1[i] < a2[j]) {
	            i++;
	        } else if (a2[j] < a3[k]) {
	            j++;
	        } else {
	            k++;
	        }
	    }
	    return list;
	}
}