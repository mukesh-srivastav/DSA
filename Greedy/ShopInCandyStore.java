package Greedy;
import java.util.*;

/**
 * In a candy store there are N different types of candies available  and the prices of all the N different types of candies are provided to you.
You are now provided with an attractive offer.
You can buy a single candy from the store and get atmost K other candies ( all are different types ) for free.
Now you have to answer two questions. Firstly, you have to tell what is the minimum amount of money you have to spend to buy all the N different candies. Secondly, you have to tell what is the maximum amount of money you have to spend to buy all the N different candies.
In both the cases you must utilize the offer i.e. you buy one candy and get K other candies for free.
Example:
Input    
 1
 4  2
 3 2 1 4

Output
 3 7

Explanation
As according to the offer if you but one candy you can take atmost two more for free.
So in the first case you buy the candy which costs 1 and take candies worth 3 and 4 for free, also you buy candy worth 2 as well.
So min cost = 1+2 =3.
In the second case I buy the candy which costs 4 and take candies worth 1 and 2 for free, also I  buy candy worth 3 as well.
So max cost = 3+4 =7. 
*/
public class ShopInCandyStore {
    public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t-- > 0) {
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    int a[] = new int[n];
		    
		    for (int i=0; i<n; i++) {
		        a[i] = sc.nextInt();
		    }
		    
		    System.out.println(shopInCandyStore(a, n, k));
		}
		sc.close();
	}
    
    // Returns string answer in form of "min max".  
	static String shopInCandyStore(int a[], int n, int k)
	{
	    Arrays.sort(a);
        
        // No of items to purchase actually. if there is K items free, that means we need to purchase n/k+1 items to get all items.
	    int count = n/(k+1);
        
	    if (n%(k+1) != 0)
            count++;
            
        // min cost to purchase all items.
	    String res = "";
	    int cost = 0;
	    for (int i=0; i<count; i++)
	        cost += a[i];
	        
	    res += cost;
	    cost = 0;
	    // Max cost to purchase all items.
	    for (int i=n-1; i > n-count - 1; i--) {
	        cost += a[i];
	    }
	    
	    res += " " + cost;
	    return res;
	}    
}