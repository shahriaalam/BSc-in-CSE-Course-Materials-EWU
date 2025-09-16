#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    int arrr[n];
    for(int i=0;i<n;i++){
        arrr[i]=0;
    }
    for(int i=0;i<n;i++){
        arrr[arr[i]]++;
    }
    
    int max=0,index=0;
    for (int i = 0; i < n; i++)
    {
        if(arrr[i]>=max){
            max=arrr[i];
            index = i;
        }
    }
    cout<<index<<endl;
    return 0;
}