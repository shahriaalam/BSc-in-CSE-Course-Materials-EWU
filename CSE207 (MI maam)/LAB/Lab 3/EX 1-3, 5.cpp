#include<bits/stdc++.h>
using namespace std;
#include <stdlib.h>
#include <conio.h>
#define MAX 1000

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

    cout<<"\nInsertion is Success!!!\n"<<endl;
    cout<<"\t\tEnter any key to go to menu"<<endl;
    getch();
    system("cls");
}



void pop()
{
    if(top == NULL) cout<<"\nStack is Empty!!!"<<endl;
    else
    {
        struct Node *t = top;
        cout<<t->data;
        top = t->next;
        free(t);
    }
    cout<<"\n\t\tEnter any key to go to menu"<<endl;
    getch();
    system("cls");
}



typedef struct Stack
{
    int data[MAX];
    int top;
};

int empty(Stack *s)
{
    if(s->top == -1) {return(1);}
    return(0);
}

int full(Stack *s)
{
    if(s->top == MAX -1) {return(1);}
    return(0);
}
void pushh(Stack *s, int x)
{
    s->top = s->top+1;
    s->data[s->top] = x;
}

int popp(Stack *s)
{
    int x;
    x = s->data[s->top];
    s->top = s->top -1;
    return(x);
}



void rev()
{
    Stack s;
    int num;
    s.top = -1;
    cout<<"Enter a decimal number: ";
    cin>>num;

    if(num!=0)
    {
        while((num!=0))
        {
            if(!full(&s))
            {
                pushh(&s, num%2);
                num=num/2;
            }
        }
    }

    else
    {
        cout<<"Empty !!! ";
        exit(0);
    }

    cout<<"\nBinary number is= ";

    while(!empty(&s))
    {
        num = popp(&s);
        cout<<num;
    }
    cout<<endl;
     cout<<"\n\t\tEnter any key to go to menu"<<endl;
    getch();
    system("cls");
}


void display()
{
    if(top == NULL) cout<<"\Empty!!!\n";
    else
    {
        struct Node *t = top;
        while(t->next != NULL)
        {
           cout<<t->data<<endl;
            t=t->next;
        }
        cout<<t->data<<endl;
    }
    cout<<"\n\t\tEnter any key to go to menu"<<endl;
    getch();
    system("cls");
}



int main()
{
    int x,y;
    cout<<"\n******* Stack using Linked List *******"<<endl;
    while(1)
    {
        cout<<"\n\t  MENU "<<endl;
        cout<<"\t--------"<<endl;
        cout<<"\t1. Push\n\t2. Pop\n\t3. Print\n\t4. Reversing Data\n\t5. Exit"<<endl;
        cout<<"\nEnter your choice: ";
        cin>>x;
        system("cls");
        switch(x)
        {
        case 1:
            cout<<"Enter the value to be insert: ";
            cin>>y;
            push(y);
            break;
        case 2:
            pop();
            break;
        case 3:
            display();
            break;
        case 4:
            rev();
            break;
        case 5:
            exit(0);
        default:
            cout<<"\nWrong selection!!! Please try again!!!"<<endl;
        }
    }
}
