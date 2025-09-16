#include<bits/stdc++.h>
using namespace std;
#include <stdlib.h>
int i=2;
int Prime(int n)
{
    if (n<=2)return 0;
    if(n%i==0) return false;
    if(i*i>n) return true;
    i++;
    return Prime(n);
}
int main()
{
    int n;
    cout<<"Enter the number:"<<endl;
    cin>>n;
    if(Prime(n))cout<<n<<" is a prime number."<<endl;
    else cout<<n<<" is not a prime number."<<endl;
   return 0;
}



