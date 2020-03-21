/**
 * Given a string s, recursively remove adjacent duplicate characters from the string s. The output string should not have any adjacent duplicates.
 * 2 geeksforgeek => gksforgk. acaaabbbacdddd => acac. 
 */

#include <bits/stdc++.h>
using namespace std;
 
vector<char> removeDup(vector<char> arr)
{
    vector<char> new_arr;
    int i=1;
    if(arr[0]!=arr[1])
    new_arr.push_back(arr[0]);
    while(i<arr.size())
    {
    if(arr[i]==arr[i-1])
    ;
    else if(i!=arr.size()-1&&arr[i]==arr[i+1])
    ;
    else
    new_arr.push_back(arr[i]);
    i++;
    }
    if(new_arr.size()==0)
    return new_arr;
    //for(int i=0;i<new_arr.size();i++)
    //cout<<new_arr[i]<<" ";
    if(new_arr.size()!=arr.size())
    return removeDup(new_arr);
    return new_arr;
}
 
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
    string arr;
    cin>>arr;
    vector<char>v;
    for(int i=0;i<arr.length();i++)
    v.push_back(arr[i]);
    vector<char> ans=removeDup(v);
    for(int i=0;i<ans.size();i++)
    cout<<ans[i];
    cout<<endl;
    }
}