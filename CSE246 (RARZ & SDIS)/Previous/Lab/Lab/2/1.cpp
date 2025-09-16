//Simple Coin Change
#include<bits/stdc++.h>
using namespace std;
int a[100005];

int lowerBound(int key, int n){
    int l = 0, r = n-1, ans = 0;
    while(l <= r){
        int mid = (l+r)/2;
        if(a[mid] <= key){
            l = mid + 1;
            ans = mid;
        }
        else r = mid - 1;
    }
    return ans;
}

int main()
{
    int n;
    cin>>n;
    int k;
    cin>>k;
    for(int i=0;i<n;i++)cin>>a[i];
    int ans=0;
    while(k!=0){
        int lower = lowerBound(k,n);
        ans = ans+(k/a[lower]);
        k = k%a[lower];
    }
    cout<<ans<<endl;
    return 0;
}