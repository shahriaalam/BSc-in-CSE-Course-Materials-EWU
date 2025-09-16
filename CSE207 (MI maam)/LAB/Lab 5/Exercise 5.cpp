#include<bits/stdc++.h>
using namespace std;
#include <stdlib.h>

struct Node
{
    int data;
    struct Node*next;
}*head =NULL;

void CreateNodeList()
{
    struct Node *p, *temp;
    int data,n;
    cout<<"Input total number of data:"<<endl;
    cin>>n;
    head=(struct Node*)malloc(sizeof(struct Node));

    if(head==NULL)
    {cout<<"There is no data!!!!";}

    else
    {
        cout<<"Input data for Node 1 :"<<endl;
        cin>>data;
        head->data=data;
        head->next=NULL;
        temp=head;
        for(int i=2;i<=n;i++)
        {
            p =(struct Node*)malloc(sizeof(struct Node));
                cout<<"Input data for Node "<<i<<" :"<<endl;
                cin>>data;
                p->data=data;
                p->next=NULL;
                temp->next=p;
                temp=temp->next;
        }
    }
    cout<<endl;
}


void reverse(struct Node* p)
{
    if(p->next==NULL)
    {
        head=p;
        return;
    }
    reverse(p->next);
    struct Node* rev=p->next;
    rev->next =p;
    p->next =NULL;
}


void PRINT()
{
    struct Node* p;
    p=head;
    while(p!=NULL)
    {
        cout<<p->data<<" ";
        p=p->next;
    }
    cout<<endl;
}

int main()
{
    CreateNodeList();
    cout<<"Before Reverse:"<<endl;
    PRINT();
    reverse(head);
    cout<<"\n\nAfter Reverse:"<<endl;
    PRINT();
}
