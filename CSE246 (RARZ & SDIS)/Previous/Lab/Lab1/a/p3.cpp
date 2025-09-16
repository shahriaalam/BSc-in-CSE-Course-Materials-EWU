#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++)cin>>arr[i];
    sort(arr,arr+n);
    int min=1212,sum=0;
    for(int i=0;i<n;i++){
        sum =abs( arr[i+1]-arr[i] );
        if(sum<min) min=sum;
    }
    cout<<min<<endl;
    return 0;
}