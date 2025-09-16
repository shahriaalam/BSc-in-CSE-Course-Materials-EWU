//Basic Prime Checking
#include<bits/stdc++.h>
using namespace std;

bool isPrime(long long n){
    for(int i=2;i<=sqrt(n);i++){
        if(n%i==0)return false;
    }
    return true;
}

int main()
{
    int t;
    cin>>t;
    while(t--){
        long long n;
        cin>>n;
        if(isPrime(n))cout<<"PRIME"<<endl;
        else cout<<"NOT PRIME"<<endl;
    }
    return 0;
}