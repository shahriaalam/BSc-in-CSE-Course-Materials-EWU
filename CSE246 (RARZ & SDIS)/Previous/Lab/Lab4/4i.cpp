#include<bits/stdc++.h>
using namespace std;

string s1,s2;
vector<vector<int>>DP(41, vector<int>(41, -1));
vector<int>ind;

int fun(int i, int j)
{
    if(i<0 || j<0)
    {
        return 0;
    }

    if(DP[i][j]!=-1)
    {
        return DP[i][j];
    }

    if(s1[i]==s2[j])
    {
        
        //cout<<s1[i];
        DP[i][j] = 1 + fun(i-1, j-1);
        ind.push_back(i);
        return DP[i][j];
    }

    DP[i][j] = max(fun(i-1, j), fun(i, j-1));

    return DP[i][j];
}

int main()
{

    cin>>s1>>s2;

    int i = s1.size();
    int j = s2.size();

    int r = fun(i-1, j-1);

    cout<<r<<endl;

    for(auto i: ind)cout<<s1[i];

    cout<<endl;

    return 0;
}