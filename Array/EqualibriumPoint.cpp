/**
 * Given an array A of N positive numbers. The task is to find the position where equilibrium first occurs in the array. 
 * Equilibrium position in an array is a position such that the sum of elements before it is equal to the sum of elements after it.
 * 
 */

#include <iostream>
using namespace std;

 int equilibrium(int arr[], int n)  
{  
    int sum = 0; // initialize sum of whole array  
    int leftsum = 0; // initialize leftsum  
  
    /* Find sum of the whole array */
    for (int i = 0; i < n; ++i)  
        sum += arr[i];  
  
    for (int i = 0; i < n; ++i)  
    {  
        sum -= arr[i]; // sum is now right sum for index i  
  
        if (leftsum == sum)  
            return i+1;  
  
        leftsum += arr[i];  
    }  
  
    /* If no equilibrium index found, then return 0 */
    return -1;  
}  
  
int main() {
	//code
	//code
	int t;
	cin>>t;
		
		while(t--) {
		    int n;
		    
		    cin>>n;
		    
		    int a[n];
		    
		    
		    for(int i=0; i<n; i++) {
		        cin>>a[i];
		    }
		    
		   cout<<equilibrium(a, n)<<endl;
		}
	return 0;
    
}