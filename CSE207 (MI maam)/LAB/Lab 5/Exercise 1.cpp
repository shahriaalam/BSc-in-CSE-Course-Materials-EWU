#include<bits/stdc++.h>
using namespace std;
#include <stdlib.h>

int Power(int n, int p)
{
    if (p<=1)return n;
    else
    return n*Power(n, p-1);
}

int main()
{
    int n,p,a=0;
    cout<<"Enter the number:"<<endl;
    cin>>n;
    cout<<"Enter the power:"<<endl;
    cin>>p;
    a=Power(n,p);
    cout<<"Output:"<<endl;
    cout<<a<<endl;
}
