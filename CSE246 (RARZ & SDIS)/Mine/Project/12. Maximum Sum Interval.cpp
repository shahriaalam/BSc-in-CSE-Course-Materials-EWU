#include <bits/stdc++.h>
using namespace std;
int main()
{
    int n;
    cin>>n;
    vector<int> a(n);
    for(int i=0; i<n; i++)
    {
        cin>>a[i];
    }
    long long cur = 0, ans = 0, min=0;
    for(int i=0; i<n; i++)
    {
        cur += a[i];
        cur = max(cur, min);
        ans = max(ans, cur);
    }
    cout<<ans<<"\n";
    return 0;
}
