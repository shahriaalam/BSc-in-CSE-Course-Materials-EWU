#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n,w;
    vector<pair<int,int>>v(n);
    cin>>n;
    for(int i=0;i<n;i++){
        int a;
        cin>>a;
        v[i].first=a;
    }
    for(int i=0;i<n;i++){
        int a;
        cin>>a;
        v[i].second=a;
    }

    sort(v.begin(),v.end());
    int ans=0;
    while(w>=0){
        n--;
        w=w-v[n].second;
        ans=ans+v[n].first;
    }
    cout<<ans<<endl;
    return 0;
}