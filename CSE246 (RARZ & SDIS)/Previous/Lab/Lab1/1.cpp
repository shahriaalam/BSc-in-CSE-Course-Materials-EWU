#include<bits/stdc++.h>
using namespace std;

int a[100005];
int upperBound(int key, int n){
    int l = 0, r = n-1, ans = n;
    while(l <= r)
    {
        int mid = (l+r)/2;
        if(a[mid] > key)
        {
            r = mid - 1;
            ans = mid;
        }
        else l = mid + 1;
    }
    return ans;
}

int lowerBound(int key, int n){
    int l = 0, r = n-1, ans = 0;
    while(l <= r)
    {
        int mid = (l+r)/2;
        if(a[mid] <= key)
        {
            l = mid + 1;
            ans = mid;
        }
        else r = mid - 1;
    }
    return ans;
}


int main()
{
    int n, k;
    cin>>n>>k;

    for(int i=0;i<n;i++){
        cin>>a[i];
    }

    int u = upperBound(k,n);
    if(u != n)
    {
        int val = a[u],i = u;
        while(i < n)
        {
            if(a[i] == val) u = i;
            else break;
            i++;
        }
    }

    int l = lowerBound(k,n);
    if(l != 0)
    {
        int val = a[l],i = l;
        while(i >= 0)
        {
            if(a[i] == val) l = i;
            else break;
            i--;
        }
    }

    cout << u << ' ' << l << '\n';

    return 0;
}