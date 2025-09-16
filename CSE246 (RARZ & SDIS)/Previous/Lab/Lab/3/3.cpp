//Calculate Prefix Function of a String
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

int main()
{
    string s;
    cin>>s;
    vector<int>prefix = prefix_function(s);
    for(auto i: prefix){
        cout<<i<<" ";
    }
    cout<<endl;
    return 0;
}