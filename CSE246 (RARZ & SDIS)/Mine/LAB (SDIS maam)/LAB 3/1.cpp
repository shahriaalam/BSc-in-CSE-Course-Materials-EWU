#include<bits/stdc++.h>
using namespace std;
const long long N = 1e9+5;

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        if(n==1)
        {
            cout<<"NOT PRIME\n";
            continue;
        }
        int flag = 1;
        for(int i = 2; i*i<=n; i++)
        {
            if(n%i==0)
            {
                flag=0;
                break;
            }
        }
        if(flag==1|| n==2)cout<< "PRIME" <<endl;
        else cout<< "NOT PRIME" <<endl;
    }
    return 0;
}

