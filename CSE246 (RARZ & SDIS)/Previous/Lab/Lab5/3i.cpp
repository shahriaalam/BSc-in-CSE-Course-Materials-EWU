#include<bits/stdc++.h>
using namespace std;

int mcm(int i, int j, vector<int> &arr, vector<vector<int>> &dp)
{
    if(i == j) return 0;
    if(dp[i][j] != -1) return dp[i][j];

    int minimum = 100000;

    for(int k = i; k < j; k++) 
    {
        int r1 =  arr[i-1] * arr[k] * arr[j] + mcm(i, k, arr, dp) + mcm(k+1, j, arr, dp);
        minimum = min(r1, minimum);
    }

    dp[i][j] = minimum;

    return dp[i][j];
}

int main()
{
    int n;
    cin>>n;
    n=2*n;
    vector<int>arr(n+1);
    set<int>temp;
    for(int i=0;i<n;i++)
    {
        int a;
        cin>>a;
        temp.insert(a);
    }

    n = temp.size();

    int j=0;

    for(auto i: temp){
        arr[j++]=i;
    }

    vector<vector<int>>dp(n, vector<int>(n, -1));

    cout<<mcm(1,n-1,arr,dp)<<endl;
    return 0;
}