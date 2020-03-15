/**
 * Given an array arr[] of positive integers of size N. Reverse every sub-array of K group elements.
 */

#include <iostream>
#include <algorithm> 
using namespace std;

int main() {
	int t;
	cin>>t;
		while(t-- > 0) {
		    int n;
		    cin>>n;
		    int a[n]; 
		    int k;
		    cin>>k;
		    for(int i =0; i <n ; i++)
		        cin>>a[i];
		    
		    for(int i =0; i<n ; i=i+k) {
		        int right = std::min(i+k-1, n-1);
		        int left  = i;
		        while(left<right){
		            int temp = a[left];
		            a[left] = a[right];
		            a[right] = temp;
		            left++;
		            right--;
		        }
		    }
		    
		    for(int i =0; i <n ; i++)
		    {
		        cout<<a[i]<<" ";
		    }
		    cout<<endl;
		}
	return 0;
}