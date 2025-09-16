#include<bits/stdc++.h>
using namespace std;
#include <stdlib.h>

int Fibonacci(int n)
{
    if (n==0 || n==1)return n;
    else
    return Fibonacci(n-1)+Fibonacci(n-2);
}
int main()
{
    int n;
    cout<<"Enter the number:"<<endl;
    cin>>n;
    cout<<"Fibonacci Series:"<<endl;
    for(int i=0; i<n;i++)
    {
      cout << Fibonacci(i)<<" ";
    }
   return 0;
}
