/**
 * Given an array of positive integers. The task is to find inversion count of array.
 * Inversion Count : For an array, inversion count indicates how far (or close) the array is from being sorted.
 * If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. 
 * Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 * https://www.geeksforgeeks.org/counting-inversions/
 */

#include <iostream>
using namespace std;

long _mergeSort (long a[], long temp[], long left, long right);
long _mergeSortAndCount(long a[], long temp[], long left, long mid, long right);

long NoOfInversions(long a[], long n) {
    long temp[n];
    return _mergeSort(a, temp, 0, n-1);
}

long _mergeSort (long a[], long temp[], long left, long right) {
    long count = 0; long mid;
    if (right > left) {
        mid = (right + left)/2;
        count += _mergeSort(a, temp, left, mid);
        count += _mergeSort(a, temp, mid+1, right);
        count += _mergeSortAndCount(a, temp, left, mid+1, right);
    }
    
    return count;
}

long _mergeSortAndCount(long a[], long temp[], long left, long mid, long right) {
    long i, j, k;
    long count =0;
    i = left, j = mid, k = left;
    
    while((i<=mid-1) && (j<=right)) {
        if (a[i] <= a[j]) 
            temp[k++] = a[i++];
        else {
            temp[k++] = a[j++];
            count += (mid - i);
        }
    }
    
    while(i<=mid-1) {
        temp[k++] = a[i++];
    }
    
    while(j<=right) {
        temp[k++] = a[j++];
    }
    
    for ( i=left; i<=right; i++)
        a[i] = temp[i];
        
    return count;
}
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
		    cout<<NoOfInversions(a,n)<<endl;
		}
		
	return 0;
}
 