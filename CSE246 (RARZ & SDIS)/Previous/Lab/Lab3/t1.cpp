#include<bits/stdc++.h>
using namespace std;
const int N = 1e7+10;
vector<int>isPrime(N,1);
int main()
{
    isPrime[0]=0, isPrime[1]=0;
    for(int i=2;i<N;i++){
        if(isPrime[i]==1){
            for(int j=2*i;j<N;j+=i){
                isPrime[j]=0;
            }
        }
    }
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        if(isPrime[n]==1){
            cout<<"PRIME"<<endl;
        }
        else{
            cout<<"NOT PRIME"<<endl;
        }
    }
    return 0;
}