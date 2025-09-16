//Finding the Pattern's occurrences
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

void KMP(string mainString, string key){
    int m = key.size();
    int n = mainString.size();
    vector<int> prefix = prefix_function(key);

    int i=0;
    int j=0;

    while(i<n){
        if(key[j]==mainString[i]){
            j++;
            i++;
        }
        if(j==m){
            cout<<i-j<<" "<<i-1<<endl;
            j=prefix[j-1];
        }
        else if(i<n && key[j]!=mainString[i]){
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
    string mainString;
    cin>>mainString;
    string key;
    cin>>key;
    KMP(mainString,key);
    cout<<endl;
    return 0;
}