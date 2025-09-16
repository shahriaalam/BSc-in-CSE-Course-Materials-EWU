#include<bits/stdc++.h>
using namespace std;
string s1,s2;
vector<vector<int>>DP(41, vector<int>(41, -1));

string lcs(int n, int m)
{
    for (int j = 0; j <= m; j++)
    {
        DP[0][j] = 0;
    }
    for (int i = 0; i <= n; i++)
    {
        DP[i][0] = 0;
    }

    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=m;j++)
        {
            if(s1[i-1] == s2[j-1])
            {
                DP[i][j] = 1+DP[i-1][j-1];
            }
            else
            {
                DP[i][j] = max(DP[i-1][j], DP[i][j-1]);
            }
        }
    }

    int len = DP[n][m];

    string ans = "";

    for(int i=0; i<len; i++)
    {
        ans+='@';
    }

    int i=n, j=m;
    int index = len-1;
    while(i>0 && j>0)
    {
        if(s1[i-1] == s2[j-1])
        {
            ans[index] = s1[i-1];
            index--;
            i--;
            j--;
        }
        else if(DP[i-1][j] > DP[i][j-1])
        {
            i--;
        }
        else
        {
            j--;
        }
    }
    return ans;
}

int main()
{
    cin>>s1>>s2;

    int n = s1.size();
    int m = s2.size();

    string s = lcs(n,m);
    cout<<s.size()<<endl;
    cout<<s<<endl;
    return 0;
}
