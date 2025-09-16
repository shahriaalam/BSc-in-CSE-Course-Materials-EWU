#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n,m;
    cin >> n >> m;
    vector< vector<long long> >dp(n,vector<long long>(m,1e12)),a(n,vector<long long>(m));

    for(int i=0; i<n; i++)
        for(int j=0; j<m; j++)
            cin >> a[i][j];

    for(int j=0; j<m; j++) dp[n-1][j] = a[n-1][j];
    for(int i=n-1; i>=1; i--)
    {
        for(int j=0; j<m; j++)
        {
            if(j-1 >= 0)
            dp[i-1][j-1] = min(dp[i][j] + a[i-1][j-1], dp[i-1][j-1]);
            dp[i-1][j] = min(dp[i][j] + a[i-1][j], dp[i-1][j]);
            if(j+1 < m)
            dp[i-1][j+1] = min(dp[i][j] + a[i-1][j+1], dp[i-1][j+1]);
        }
    }
    cout << *min_element(dp[0].begin(),dp[0].end());
    cout<<endl;

    return 0;
}