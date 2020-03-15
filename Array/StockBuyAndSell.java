/**
 * The cost of stock on each day is given in an array A[] of size N. 
 * Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.
 */

 /*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Interval {
    int buy; int sell;
}
class StockBuyAndSell {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
		    int n = sc.nextInt();
		    int a[] = new int[n];
		    for(int i=0; i<n;i++) 
		        a[i] = sc.nextInt();
		    ArrayList<Interval> sol = new ArrayList<Interval>();
		    int count =0;
		    int i=0;
		    while(i<n) {
                //Do not buy while it's decreasing. Buy just before it starts to increase.
		        while (i<n-1 && a[i+1]<=a[i])
                    i++;
                    
		        if (i==n-1) {
		            break;
                }
                
		        Interval e = new Interval(); 
                
                e.buy = i++;
                
                // Do not sell while it's increasing. Sell just before the day it starts decreasing. 
		        while(i<n && a[i]>=a[i-1])
		            i++;
		        
		        e.sell = i-1;
		        sol.add(e);
		        count++;
		    }
		    
		    if (i==n-1 && count==0)
		        System.out.println("No Profit");
            else {
    		    for (i=0; i<count; i++) {
    		        System.out.print("(" + sol.get(i).buy + " " + sol.get(i).sell + ") ");
    		    }
    		    System.out.println();
            }
		}
	}
}