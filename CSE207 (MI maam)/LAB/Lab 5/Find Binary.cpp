#include<bits/stdc++.h>
using namespace std;
#include <stdlib.h>

int Binary(int n)
{
    if (n==0)return 0;
    else return n%2+10* Binary(n/2);
}
int main()
{
    int n;
    cout<<"Enter the decimal number:"<<endl;
    cin>>n;
    cout<<"Binary is: "<<Binary(n)<<endl;
   return 0;
}


