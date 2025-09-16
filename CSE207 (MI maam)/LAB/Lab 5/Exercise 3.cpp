#include<bits/stdc++.h>
using namespace std;
#include <stdlib.h>
int m=0;
int LCM(int a, int b)
{
    m+=b;
    if((m%a==0) && (m%b==0))
    return m;

    else
    LCM(a,b);
}

int main()
{
    int x,y,a=0;
    cout<<"Enter the first number:"<<endl;
    cin>>x;
    cout<<"Enter the second number:"<<endl;
    cin>>y;
    a=LCM(x,y);
    cout<<"Output LCM:"<<endl;
    cout<<a<<endl;
}
