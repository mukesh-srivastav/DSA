/**
 * Given an array of positive integers. Your task is to find the leaders in the array.
 * Note: An element of array is leader if it is greater than or equal to all the elements to its right side. Also, the rightmost element is always a leader.
 */

#include <iostream>
#include <vector>
using namespace std;

int main() {
	//code
	int t;
	cin>>t;
		
		while(t--) {
		    long n;
		    
		    cin>>n;
		    
		    long a[n];
		    
		    
		    for(long i=0; i<n; i++) {
		        cin>>a[i];
		    }
		    
            int max = a[n-1];
		    
            for(int i=n-2;i>=0;i--) {
	            if(a[i]>=max)
	                max=a[i];
	            else
	                a[i]=-1;
	        }

	        for(int i=0;i<n;i++)
	            if(a[i]!=-1)
	                cout<<a[i]<<" ";
	   
		    cout<<endl;
		}
		
	return 0;
}