//Hill Climbing
#include<bits/stdc++.h>
using namespace std;
int arr[45][45];
vector<vector<int>>dp(45,vector<int>(45));

int main()
{
    int n,m;
    cin>>n>>m;
    for(int i=0;i<n;i++){
        for(int j=0; j<m; j++){
            cin>>arr[i][j];
        }
    }
    for(int j=1;j<=m;j++){
        dp[0][j]=arr[0][j-1];
    }
    for(int i=0; i<=n; i++){
        dp[i][0]=INT_MAX;
        dp[i][m+1]=INT_MAX;
    }
    for(int i=1; i<n; i++){
        for(int j=1; j<=m; j++){
            dp[i][j]=arr[i-1][j-1]+min(dp[i-1][j-1], min(dp[i-1][j], dp[i-1][j+1]));
        }
    }
    vector<pair<int, int>> index;
    int mi = INT_MAX;
    int indi , indj;
    for(int i=0;i<n;i++){
        for(int j=1;j<=m; j++){
            if(dp[i][j]<mi){
                mi = min(mi, dp[i][j]);
                indi = i;
                indj = j;
            }
        }
        mi = INT_MAX;
        index.push_back({indi, indj});
    }
    int ans = 0;
    for(auto i : index){
        ans+=arr[i.first][i.second-1];
    }
    cout<<ans<<endl;
    return 0;
}