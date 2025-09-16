#include<bits/stdc++.h>
using namespace std;
#include <stdlib.h>

int Factorial(int n)
{
    if (n==0 || n==1)return 1;
    else
    return n*Factorial(n-1);
}
int main()
{
    int n;
    cout<<"Enter the number:"<<endl;
    cin>>n;
    cout<<n<<"! Factorial is: "<<Factorial(n)<<endl;
   return 0;
}

