#include<stdio.h>
#include<conio.h>

struct Node
{
    int data;
    struct Node *next;
}*top = NULL;

void push(int);
void pop();
void display();

void main()
{
    int choice, value;
    printf("\n\t Stack using Linked List \n");
    while(1)
    {
        printf("\n\t\t MENU \n");
        printf("\t\t--------\n");
        printf("\t\t1. Push\n\t\t2. Pop\n\t\t3. Print\n\t\t4. Exit\n");
        printf("\n\n\tEnter your choice: ");
        scanf("%d",&choice);
        system("cls");
        switch(choice)

        {
        case 1:
            printf("Enter the value to be insert: ");
            scanf("%d", &value);
            push(value);
            break;
        case 2:
            pop();
            break;
        case 3:
            display();
            break;
        case 4:
            exit(0);
        default:
            printf("\nWrong selection!!! Please try again!!!\n");
        }
    }
}
void push(int value)
{

    struct Node *newNode;
    newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;
    if(top == NULL)
        newNode->next = NULL;
    else
        newNode->next = top;
    top = newNode;
    printf("\nInsertion is Success!!!\n\n");
    printf("\t\tEnter any key to go to menu");
    getch();
    system("cls");
}
void pop()
{

    if(top == NULL)
        printf("\nStack is Empty!!!\n");
    else
    {
        struct Node *t = top;
        printf("\nDeleted element: %d", t->data);
        top = t->next;
        free(t);
    }
    printf("\n\t\tEnter any key to go to menu");
    getch();
    system("cls");
}
void display()
{

    if(top == NULL)
        printf("\Empty!!!\n");
    else
    {
        struct Node *t = top;
        while(t->next != NULL)
        {
            printf("%d ",t->data);
            t = t -> next;
        }
        printf("%d ->",t->data);
    }
    printf("\n\t\tEnter any key to go to menu");
    getch();
    system("cls");
}
