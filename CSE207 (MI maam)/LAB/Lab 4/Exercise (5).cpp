#include<bits/stdc++.h>
using namespace std;
#include<stdlib.h>
#define MAX 100
int Queue[MAX],Front=0, Rare=-1,Total=0;

int Full()
{
    if(Total==MAX){return 1;}
    return 0;
}

int Empty()
{
    if(Total==0){return 1;}
    return 0;
}



void enqueue(char val)
{
    if(Full()){cout<<"Queue is full"<<endl;}

    else
    {
        Rare=(Rare+1)%MAX;
        Queue[Rare]=val;
        Total++;
    }
}



char dequeue()
{
    char val;
    if(Empty())cout<<"No input here"<<endl;
    else
    {
        val = Queue[Front];
        if(Front == Rare)
            Front=Rare=-1;
        else
            Front++;

    }
    return val;
}



int main()
{
    string line;
    cout<<"Enter the string: ";
    getline(cin,line);

    for(int i=0;i<line.length();i++)
    {
        if(line[i]!= ' ')
        {
            enqueue(line[i]);
        }
    }


     for(int i=Front;i<=Rare;i++)
    {
       line[i]=dequeue();
        cout<<line[i];
    }
    cout<<endl;
    return 0;
}
