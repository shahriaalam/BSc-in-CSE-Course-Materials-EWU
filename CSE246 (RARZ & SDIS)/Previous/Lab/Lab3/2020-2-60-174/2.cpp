#include<bits/stdc++.h>
using namespace std;

vector<int> prefix_function(string st){
    int n = st.size();
    vector<int>pi(n,0);
    for(int i=1;i<n;i++){
        int j=pi[i-1];
        while(j>0 && st[i]!=st[j]){
            j=pi[j-1];
        }
        if(st[i]==st[j]){
            j++;
            pi[i]=j;
        }
    }
    return pi;
}

void KMP(string t, string s){
    int m = s.size();
    int n = t.size();

    vector<int> prefix = prefix_function(s);

    int i=0;
    int j=0;

    while(i<n){
        if(s[j]==t[i]){
            j++;
            i++;
        }
        if(j==m){
            cout<<i-j<<" "<<i-j+m-1<<endl;
            j=prefix[j-1];
        }
        else if(i<n && s[j]!=t[i]){
            if(j!=0){
                j=prefix[j-1];
            }
            else{
                i++;
            }
        }
    }
}

int main()
{
    string t;
    cin>>t;
    string s;
    cin>>s;
    KMP(t,s);
    cout<<endl;
    return 0;
}