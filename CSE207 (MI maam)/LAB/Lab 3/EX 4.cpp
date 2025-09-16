#include<bits/stdc++.h>
using namespace std;
#include <stdlib.h>



int top=0;
char s[1000];

void push(char a)
{
    s[top] = a;
    top++;
}

void pop()
{
    if (top==0)
    {
        cout<<"\nClosing parentheses not matched."<<endl;
        exit(0);
    }
    else {top--;}
}


void PRINT()
{
    if (top==0)
        cout<<"\nValid."<<endl;
    else
        cout<<"\nOpening parentheses not end."<<endl;
}


int main()
{
    string a;
    cout<<"Please enter the input:"<<endl;
    cin>>a;
    for(int i=0; i<a.length();i++)
    {
        if(a[i]=='(')
        { push(a[i]); }

        else if(a[i]==')')
            {pop();}
    }
     PRINT();
}
