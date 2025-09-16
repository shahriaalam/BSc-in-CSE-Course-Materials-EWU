//MCM Calculation
#include<bits/stdc++.h>
using namespace std;

int mcm(int i, int j, vector<int> &arr, vector<vector<int>> &dp){
    if(i == j) return 0;
    if(dp[i][j] != -1) return dp[i][j];
    int minimum = 100000;
    for(int k = i; k < j; k++){
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
    vector<int>arr(n+1);
    int a,b;
    cin >> a >> b;
    arr[0] = a;
    for(int i=1;i<n;i++){
        cin>> a >> b;
        arr[i] = a;
    }
    arr[n] = b;
    vector<vector<int>>dp(n+1, vector<int>(n+1, -1));
    cout<<mcm(1,n,arr,dp)<<endl;
    return 0;
}