#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n;
    cin>>n;
    double arr[100005];
    for(int i=0;i<n;i++)cin>>arr[i];

    int k;
    cin>>k;

    double arrr[100005];
    for(int i=0;i<n;i++)arrr[i]=arr[i];

    sort(arrr,arrr+n);

    double d = arrr[k-1];
    int ans=0;

    for(int i=0;i<n;i++){
        if(d==arr[i]){
            ans=i;
            break;
        }
    }

    cout<<ans+1<<endl;
    return 0;
}