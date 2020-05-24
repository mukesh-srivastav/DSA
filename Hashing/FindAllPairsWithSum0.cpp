#include <iostream>
#include<bits/stdc++.h>
using namespace std;

/**
 * Given two unsorted arrays A of size N and B of size M of distinct elements, the task is to find all pairs from both arrays whose sum is equal to X.
 * Example:
Input:
2
5 5 9
1 2 4 5 7
5 6 3 4 8
2 2 3
0 2
1 3
Output:
1 8, 4 5, 5 4
0 3, 2 1
*/
int main() {
	//code
	int test;
    cin>>test;
    while(test-- > 0){
        int m,n,x;
        cin>>m>>n>>x;
        int a[m],b[n];
        for(int i=0;i<m;i++)
            cin>>a[i];
        for(int i=0;i<n;i++)
            cin>>b[i];
        sort(a,a+m);
        unordered_set<int>st;
        for(int i=0;i<n;i++){
            st.insert(b[i]);
        }
        
        int flag=0;
        for(int i=0;i<m;i++){
            
            int dif=x-a[i];
            if (st.find(dif)!=st.end()) {
                if(flag==1) cout<<", ";
                cout<<a[i]<<" "<<dif;
                flag=1;
            }
        }
        
        if(flag==0) cout<<-1;
        cout<<endl;
    }
	return 0;
}