#include<bits/stdc++.h>
using namespace std;
const long long N = 1e9+5;

vector<long long>primeNumber(N,1);

void isPrime(){
    primeNumber[0]=0;
    primeNumber[1]=0;
    
    for(long long i=2;i<=N; i+=2){
        if(i==2)continue;
        primeNumber[i]=0;
    }
    for(long long i=3;i<=sqrt(N);i+=2){
        if(primeNumber[i]==1){
            for(long long j=i*i;j<=N;j+=2*i){
                primeNumber[j]=0;
            }
        }
    }
}

int main()
{
    isPrime();
    long long n;
    cin>>n;
    while(n--){
        long long k;
        cin>>k;
        if(primeNumber[k]==1)cout<<"PRIME"<<endl;
        else cout<<"NOT PRIME"<<endl;
    }
    return 0;
}