#include <iostream>
#include <bits/stdc++.h> 
using namespace std;
        
void lps_func(string txt, vector<int>&Lps){
    Lps[0] = 0;                   
    int len = 0;
    int i=1;
    while (i<txt.length()){
        if(txt[i]==txt[len]){   
            len++;
            Lps[i] = len;
            i++;
            continue;
        }
        else{                   
            if(len==0){         
                Lps[i] = 0;
                i++;
                continue;
            }
            else{              
                len = Lps[len-1];
                continue;
            }
        }
    }
}

int main()
{
    string s;
    cin>>s;
    int n=s.size();
    vector<int>v(n);
    lps_func(s,v);
    for(int i=0;i<n;i++)cout<<v[i]<<" ";
    cout<<endl;
}