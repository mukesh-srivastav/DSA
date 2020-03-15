/**
 * Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on...
 * Note: O(1) extra space is allowed. Also, try to modify the input array as required.
 * 
 */

#include <iostream>
using namespace std;

// Prints max at first position, min at second position 
// second max at third position, second min at fourth 
// position and so on. 
void rearrange(int *arr, int n) 
{ 
    // initialize index of first minimum and first 
    // maximum element 
    int max_idx = n - 1, min_idx = 0; 
  
    // store maximum element of array 
    int max_elem = arr[n - 1] + 1; 
  
    // traverse array elements 
    for (int i = 0; i < n; i++) { 
        // at even index : we have to put maximum element 
        if (i % 2 == 0) { 
            arr[i] += (arr[max_idx] % max_elem) * max_elem; 
            max_idx--; 
        } 
  
        // at odd index : we have to put minimum element 
        else { 
            arr[i] += (arr[min_idx] % max_elem) * max_elem; 
            min_idx++; 
        } 
    }
/**
    How does expression “arr[i] += arr[max_index] % max_element * max_element” work ?
The purpose of this expression is to store two elements at index arr[i]. arr[max_index] is stored as multiplier and “arr[i]” is stored as remainder. 
For example in {1 2 3 4 5 6 7 8 9}, max_element is 10 and we store 91 at index 0. With 91, we can get original element as 91%10 and new element as 91/10.
  */
    // array elements back to it's original form 
    for (int i = 0; i < n; i++) 
        arr[i] = arr[i] / max_elem; 
}

int main() {
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
	    
	    rearrange(a,n);
	    
	    for(int i=0; i<n; i++) {
	        cout<<a[i]<< " ";
	    }
	    cout<<endl;
	}
	return 0;
}