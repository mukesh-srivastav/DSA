#include <bits/stdc++.h>
using namespace std;

int firstElement(int arr[],int n,int k){
    
    unordered_map<int ,int >map;
    for(int i=0;i<n;i++){
        map[arr[i]]++;
    }
    
    for (int i=0;i<n;i++){
        if (map[arr[i]]==k)
        return arr[i];
    }
    return -1;
}


int main() {
	int t;
	cin>>t;
	while(t--){
	    int n,k;
	    cin>>n>>k;
	    int a[n];
	    for(int i=0;i<n;i++){
	        cin>>a[i];
	    }
	    
	    cout << firstElement(a, n, k)<<endl; 

	}
	return 0;
}