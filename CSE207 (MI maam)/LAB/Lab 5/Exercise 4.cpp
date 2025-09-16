#include<bits/stdc++.h>
using namespace std;
#include <stdlib.h>
int n=0;
int Palindrome(string a)
{
    int length= a.length()-(n+1);

    if (a[n]==a[length])
    {
        if (n+1==length||n==length)
        {
           cout<<"Its palindrome."<<endl;
           exit(0);
        }
        n=n+1;
        Palindrome(a);
    }
    else
    cout<<"It's not a palindrome."<<endl;
}

int main()
{
    string x;
    cout<<"Enter the number:"<<endl;
    cin>>x;
    Palindrome(x);
}
