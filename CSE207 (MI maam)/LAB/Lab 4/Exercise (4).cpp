#include<bits/stdc++.h>
using namespace std;
#include<stdlib.h>
#include <conio.h>
#define MAX 10
int Queue1[MAX],Queue2[MAX];
int Front=0, Rare=-1,Total=0;

int Full()
{
    if(Total==MAX){return 1;}
    return 0;
}


void enqueue(int Queue[],int x)
{
    if(Full()){cout<<"Queue is full"<<endl;}
    else
    {
        Rare=(Rare+1)%MAX;
        Queue[Rare]=x;
        Total++;
    }
}



void PRINT(int Queue[],int n)
{
    for(int i=0;i<n;i++)
    {
        cout<<Queue[i]<<" ";
    }
    cout<<endl;
}

int main()
{
    int n,value;
    cout<<"Enter the number of total inputs: ";
    cin>>n;
    cout<<"Enter the values one by one:"<<endl;
    for(int i=0;i<n;i++)
    {
        cin>>value;
        enqueue(Queue1,value);
    }
     cout<<"\nThe 1st Queue is:"<<endl;
     PRINT(Queue1,n);
     Front=0, Rare=-1,Total=0;
     for(int i=0;i<n;i++)
    {
        enqueue(Queue2,Queue1[i]);
    }
    cout<<"\nThe 2nd Queue is:"<<endl;
    PRINT(Queue2,n);
    return 0;
}
