#include<bits/stdc++.h>
using namespace std;
#include<stdlib.h>
#define MAX 100
int Queue[MAX],Front=0, Rare=-1,Total=0;


struct Node
{
    int data;
    struct Node*next;
}*top=NULL;


void push(int value)
{
    struct Node *p;
    p=(struct Node*)malloc(sizeof(struct Node));
    p->data = value;

    if(top==NULL)
        {p->next = NULL;}

    else
        {p->next = top;}
        top=p;
}

void enqueue(int x)
{
        Rare=(Rare+1);
        Queue[Rare]=x;
        Total++;
}

void pop()
{
    if(top == NULL) cout<<"\nStack is Empty!!!"<<endl;
    else
    {
        struct Node *t = top;
        enqueue(t->data);
        top = t->next;
        free(t);
    }
}




void PRINT(int n)
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
    cout<<"Enter the values in the stack one by one:"<<endl;
    for(int i=0;i<n;i++)
    {
        cin>>value;
        push(value);
    }

    for(int i=0;i<n;i++)
    {
        pop();
    }
    cout<<endl;
    cout<<"The stored values in the Queue:"<<endl;
    PRINT(n);
    return 0;
}

