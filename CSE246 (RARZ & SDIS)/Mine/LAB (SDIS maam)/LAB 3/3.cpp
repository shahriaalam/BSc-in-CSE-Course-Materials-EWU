#include<bits/stdc++.h>
using namespace std;

vector<int> prefix_pattern(string P)
{
    int n = P.length();
    vector<int> pi(n);
    for (int i=1; i<n; i++)
    {
        int j = pi[i-1];
        while (j>0 && P[i]!=P[j])
        {
            j= pi[j-1];
        }
        if (P[i]==P[j])
        {
            j++;
        }
        pi[i]=j;
    }
    return pi;
}


int main()
{
    string P;
    getline(cin, P);
    vector<int> pi = prefix_pattern(P);

    for (int i = 0; i < pi.size(); i++)
    {
        cout << pi[i] << " ";
    }
    return 0;
}


