#include<bits/stdc++.h>
using namespace std;

int arr[31];
int dp[31][31];

int lcs(int index, int pre_index, int n)
{
    if(index == n)
    {
        return 0;
    }
    if(dp[index][pre_index+1] != -1)
    {
        return dp[index][pre_index + 1];
    }
    int length = lcs(index+1, pre_index, n);

    if(pre_index == -1 || arr[index] > arr[pre_index])
    {
        int r1 = length;
        int r2 = 1 + lcs(index+1, index, n);
        length = max(r1, r2);
    }

    return dp[index][pre_index+1] = length;
}

int main()
{
    int n;
    cin>>n;
    for(int i=0;i<n;i++)
    {
        cin>>arr[i];
    }

    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            dp[i][j]=-1;
        }
    }

    cout<<lcs(0,-1,n)<<endl;
    return 0;
}