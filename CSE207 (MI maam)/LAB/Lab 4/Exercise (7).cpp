#include<bits/stdc++.h>
using namespace std;
#include<stdlib.h>
#define MAX 100
int Queue[MAX],Front=0, Rare=-1,Total=0;

int Full()
{
    if(Total==MAX) {return 1;}
    return 0;
}

int Empty()
{
    if(Total==0) {return 1;}
    return 0;
}



void enqueue(char val)
{
    if(Full())cout<<"Queue is full"<<endl;
    else
    {
        Rare=(Rare+1)%MAX;
        Queue[Rare]=val;
        Total++;
    }
}



void dequeue(int n)
{
    int val;
    if(Empty())cout<<"No input here"<<endl;
    else
    {
        for(int i=0; i<n; i++)
        {
            val = Queue[Front];
            cout<<val<<" ";
            Front++;
        }
    }
}


int main()
{
    int n;
    cout<<"Enter the number of total inputs: ";
    cin>>n;
    cout<<endl;
    cout<<"Enter the values in the queue one by one:"<<endl;
    int a[n],x=0;
    for(int i=0; i<n; i++)
    {
        cin>>a[i];
        if(a[i]>=0)
        {
            enqueue(a[i]);
            x++;
        }
    }
    cout<<endl;
    cout<<"After removing the values from the queue:"<<endl;
    dequeue(x);
    return 0;
}
