#include<bits/stdc++.h>
using namespace std;
#include<stdlib.h>
#include <conio.h>

struct Node
{
    int data;
    struct Node*next;
} *Front=NULL,*Rare=NULL;


void enqueue(int x)
{
    struct Node*P;
    P=(struct Node*)malloc(sizeof(struct Node));
    P->data=x;
    P->next=NULL;
    if(Front==NULL && Rare==NULL)
    {
        Front=Rare=P;
    }
    else
    {
        Rare->next=P;
        Rare=P;
    }
     cout<<"\nInsertion is Success!!!\n"<<endl;
    cout<<"\n\t\tEnter any key to go to menu"<<endl;
    getch();
    system("cls");
}



void dequeue()
{
    struct Node* temp;
    if(Front==NULL){cout<<"The Queue is empty."<<endl;}
    else
    {
        temp=Front;
        Front=Front->next;
        if(Front == NULL){Rare = NULL;}
        free(temp);
    }
     cout<<"\nDelete is Success!!!\n"<<endl;
    cout<<"\n\t\tEnter any key to go to menu"<<endl;
    getch();
    system("cls");
}


void PRINT()
{
    struct Node *temp = Front;
    cout<<"The Queue is:"<<endl;
    while(temp)
    {
        cout<<temp->data<<endl;
        temp=temp->next;
    }
    cout<<"\n\t\tEnter any key to go to menu"<<endl;
    getch();
    system("cls");
}


int main()
{
    int x,y;
    while(1)
    {
    cout<<"****** Queue ******"<<endl;
    cout<<"\n_____MENU_____ "<<endl;
    cout<<"1. Create Queue\n2. Delete node from Queue\n3. Print Queue\n4. Exit"<<endl;
    cout<<"Enter your choice: ";
    cin>>x;
    system("cls");
    switch(x)
        {
        case 1:
            cout<<"Enter the value to be insert: ";
            cin>>y;
            enqueue(y);
            break;
        case 2:
            dequeue();
            break;
        case 3:
            PRINT();
            break;
        case 4:
            exit(0);
            default:
            cout<<"\nWrong selection!!! Please try again!!!"<<endl;
        }
    }
    return 0;
}

