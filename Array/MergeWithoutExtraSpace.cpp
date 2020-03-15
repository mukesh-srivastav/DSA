/*
    Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m. The task is to merge the two sorted arrays into one sorted array (in non-decreasing order).

    Note: Expected time complexity is O((n+m) log(n+m)). DO NOT use extra space.  We need to modify existing arrays as following.

    Input: arr1[] = {10};
        arr2[] = {2, 3};
    Output: arr1[] = {2}
            arr2[] = {3, 10}  

    Input: arr1[] = {1, 5, 9, 10, 15, 20};
        arr2[] = {2, 3, 8, 13};
    Output: arr1[] = {1, 2, 3, 5, 8, 9}
            arr2[] = {10, 13, 15, 20} 

        For each test case, print (X + Y) space separated integer representing the merged array.
*/

#include <iostream>
using namespace std;

int nextGap(int n) {
    if (n<=1)
        return 0;
    return n/2 + n%2;
}

void merge(int *arr1, int *arr2, int n, int m) 
{ 
    int i, j, gap = n + m; 
    for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) 
    { 
        // comparing elements in the first array. 
        for (i = 0; i + gap < n; i++) 
            if (arr1[i] > arr1[i + gap]) 
                swap(arr1[i], arr1[i + gap]); 
  
        //comparing elements in both arrays. 
        for (j = gap > n ? gap-n : 0 ; i < n&&j < m; i++, j++) 
            if (arr1[i] > arr2[j]) 
                swap(arr1[i], arr2[j]); 
  
        if (j < m) 
        { 
            //comparing elements in the second array. 
            for (j = 0; j + gap < m; j++) 
                if (arr2[j] > arr2[j + gap]) 
                    swap(arr2[j], arr2[j + gap]); 
        } 
    } 
} 

int main() {
	//code
	int t;
	cin>>t;
	
	while(t-->0) {
	    int n, m; 
	    cin>>n>>m;
	    
	    int a[n];
	    int b[m];
	    int k = n+m;
	    for (int i=0; i<n; i++)
	        cin>>a[i];
	       
	    for (int i=0; i<m; i++)
	        cin>>b[i];
	        
	    merge(a, b, n, m);
	    
	    for (int i = 0; i < n; i++) 
            printf("%d ", a[i]);
        for (int i = 0; i < m; i++) 
            printf("%d ", b[i]);
        
        printf("\n"); 
	}
	return 0;
}

