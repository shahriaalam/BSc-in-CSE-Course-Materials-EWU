#include<bits/stdc++.h>
using namespace std;

int a[35];
int DP[31][1001];

int fun(int i, int k)
{
    if(i==0)
    {
        if(k % a[0] == 0)
        {
            return k/a[0];
        }
        return 1e5;
    }
    if(DP[i][k]!=-1)
    {
        return DP[i][k];
    }

    int r1 = fun(i-1, k);
    int r2 = INT_MAX;

    if(a[i] <= k)
    {
        r2 = fun(i, k-a[i]) + 1;
    }

    DP[i][k]=min(r1,r2);
    
    return DP[i][k];
}
int main()
{
    int n,k;
    cin>>n>>k;

    for(int i=0;i<31;i++)
    {
        for(int j=0;j<1001;j++)
        {
            DP[i][j]=-1;
        }
    }

    for(int i=0;i<n;i++)
    {
        cin>>a[i];
    }

    cout<<fun(n-1,k)<<endl;
    return 0;
}