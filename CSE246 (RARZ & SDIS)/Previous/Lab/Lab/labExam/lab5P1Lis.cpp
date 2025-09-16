#include<bits/stdc++.h>
using namespace std;
int dp[31];
int arr[31];

int lis(int i)
{
    if(dp[i] != -1) return dp[i];
    int answer = 1;
    for(int j=0; j<i; j++){
        if(arr[i] > arr[j]){
            answer = max(answer, lis(j) + 1);
        }
    }
    return dp[i] = answer;
}

int main()
{
    memset(dp, -1, sizeof(dp));
    int n;
    cin>>n;
    for(int i=0;i<n;i++)cin>>arr[i];

    int answer = 0;

    for(int i=0; i<n; i++) answer = max(answer, lis(i));

    cout<<answer<<endl;
    return 0;
}