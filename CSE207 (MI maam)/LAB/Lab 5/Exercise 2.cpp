#include<bits/stdc++.h>
using namespace std;
#include <stdlib.h>

int GCD(int x, int y)
{
    while(x!=y)
     {
          if(x>y) return GCD(x-y,y);
          else return GCD(x,y-x);
     }
     return x;
}


int main()
{
    int x,y,a=0;
    cout<<"Enter the first number:"<<endl;
    cin>>x;
    cout<<"Enter the second number:"<<endl;
    cin>>y;
    a=GCD(x,y);
    cout<<"Output GCD:"<<endl;
    cout<<a<<endl;
}
