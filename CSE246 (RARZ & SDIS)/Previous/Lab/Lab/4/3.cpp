//0/1 Knapsack
#include<bits/stdc++.h>
using namespace std;
int weight[31];
int value[31];

int knapsack(int i, int w){
    if(i==0){
        if(weight[0] <= w) return value[0];
        return 0;
    }

    int r1 = knapsack(i-1, w);
    int r2 = INT_MIN;

    if(weight[i] <= w){
        r2 = value[i] + knapsack(i-1, w-weight[i]);
    }
    return max(r1, r2);
}

int main()
{
    int n,w;
    cin>>n>>w;

    for(int i=0;i<n;i++){
        cin>>value[i];
    }

    for(int i=0;i<n;i++){
        cin>>weight[i];
    }

    cout<<knapsack(n-1, w)<<endl;
    return 0;
}