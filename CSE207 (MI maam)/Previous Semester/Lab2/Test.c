#include<stdlib.h>
#include<stdio.h>
#include<conio.h>
void createNodeList();
void insertAtBeginning(int);
void insertAtEnd(int);
void insertAtAfter(int,int);
void deleteBeginning();
void deleteEnd();
void deleteSpecific(int);
void display();

struct Node
{
    int data;
    struct Node *next;
}*head = NULL;

void main()
{
    int choice1, choice2, value, location,num;

    while(1)
    {
start:
        {
            printf("\n\t\t Linked List\n");
            printf("\t\t=============\n");
            printf("\t1. Creating\n\t2. Insert at begging \n\t3. Insert at End\n\t4. Insert at Any position\n\t5. Delete at begening\n\t6. Delete at End\n\t5. Delete at Any positiob\n\t8. Display\n\t9. Exit\nEnter your choice: ");
            scanf("%d",&choice1);
            system("cls");
        }
        switch(choice1)
        {
        case 1:
            createNodeList();
            break;
        case 2:
            printf("Enter the value to be inserted: ");
            scanf("%d",&value);
            insertAtBeginning(value);
            break;
        case 3:
            printf("Enter the value to be inserted: ");
            scanf("%d",&value);
            insertAtEnd(value);
            break;
        case 4:
            printf("Enter the value to be inserted: ");
            scanf("%d",&value);
            printf("Enter the location after which you want to insert: ");
            scanf("%d",&location);
            insertAfter(value,location);
            break;

        case 5:
            deleteBeginning();
            break;
        case 6:
            deleteEnd();
            break;
        case 7:
            printf("Enter the Node value to be deleted: ");
            scanf("%d",&location);
            deleteSpecific(location);
            break;



        case 8:
            display();
            break;
        case 9:
            exit(0);
        default:
            printf("\nPlease select correct option!!!");
        }
    }
}
void createNodeList()
{

    struct Node *fnNode, *tmp;
    int data, i,n;
    printf("How many Data you entered?? ::");
    scanf("%d",&n);
    head = (struct Node *)malloc(sizeof(struct Node));

    if(head == NULL)
    {
        printf(" Memory can not be allocated.");
    }
    else
    {


        printf(" Input data for node 1 : ");
        scanf("%d", &data);
        head->data = data;
        head->next = NULL;
        tmp = head;
        for(i=2; i<=n; i++)
        {
            fnNode = (struct Node *)malloc(sizeof(struct Node));
            if(fnNode == NULL)
            {
                printf(" Memory can not be allocated.");
                break;
            }
            else
            {
                printf(" Input data for node %d : ", i);
                scanf(" %d", &data);

                fnNode->data = data;
                fnNode->next = NULL;

                tmp->next = fnNode;
                tmp = tmp->next;
            }
        }
    }
    printf("Creation Done");
    printf("Enter any key to go to menu");
    getch();
    system("cls");
}

void insertAtBeginning(int value)
{
    struct Node *newNode;
    newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode -> data = value;
    if(head == NULL)
    {
        head = newNode;
        newNode -> next = head;
    }
    else
    {
        struct Node *temp = head;
        while(temp -> next != head)
            temp = temp -> next;
        newNode -> next = head;
        head = newNode;
        temp -> next = head;
    }
    printf("\nInsertion success!!!");

    printf("Enter any key to go to menu");
    getch();
    system("cls");
}
void insertAtEnd(int value)
{
    struct Node *newNode;
    newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode -> data = value;
    if(head == NULL)
    {
        head = newNode;
        newNode -> next = head;
    }
    else
    {
        struct Node *temp = head;
        while(temp -> next != head)
            temp = temp -> next;
        temp -> next = newNode;
        newNode -> next = head;
    }
    printf("\nInsertion success!!!");
    printf("Enter any key to go to menu");
    getch();
    system("cls");

}
void insertAfter(int value, int location)
{
    struct Node *newNode;
    newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode -> data = value;
    if(head == NULL)
    {
        head = newNode;
        newNode -> next = head;
    }
    else
    {
        struct Node *temp = head;
        while(temp -> data != location)
        {
            if(temp -> next == head)
            {
                printf("Given node is not found in the list!!!");

            }
            else
            {
                temp = temp -> next;
            }
        }
        newNode -> next = temp -> next;
        temp -> next = newNode;
        printf("\nInsertion success!!!");
    }
    printf("Enter any key to go to menu");
    getch();
    system("cls");

}
void deleteBeginning()
{
    if(head == NULL)
        printf("List is Empty!!! Deletion not possible!!!");
    else
    {
        struct Node *temp = head;
        if(temp -> next == head)
        {
            head = NULL;
            free(temp);
        }
        else
        {
            head = head -> next;
            free(temp);
        }
        printf("\nDeletion success!!!");
    }
    printf("Enter any key to go to menu");
    getch();
    system("cls");
}
void deleteEnd()
{
    struct Node *temp1,*temp2;
    if(head == NULL)
        printf("List is Empty!!! Deletion not possible!!!");
    else
    {
        temp1= head;
        temp2=head;
        while(temp1 -> next != NULL)
        {
            temp2=temp1;
            temp1=temp1->next;
        }
        if(temp1==head)
        {
            head=NULL;
        }
        else
            temp2->next=NULL;
    }
    free(temp1);
    printf("\nDeletion success!!!");
    printf("Enter any key to go to menu");
    getch();
    system("cls");
}
void deleteSpecific(int delValue)
{
    if(head == NULL)
        printf("List is Empty!!! Deletion not possible!!!");
    else
    {
        struct Node *temp1 = head, *temp2;
        while(temp1 -> data != delValue)
        {
            if(temp1 -> next == head)
            {
                printf("\nGiven node is not found in the list!!!");
            }
            else
            {
                temp2 = temp1;
                temp1 = temp1 -> next;
            }
        }
        if(temp1 -> next == head)
        {
            head = NULL;
            free(temp1);
        }
        else
        {
            if(temp1 == head)
            {
                temp2 = head;
                while(temp2 -> next != head)
                    temp2 = temp2 -> next;
                head = head -> next;
                temp2 -> next = head;
                free(temp1);
            }
            else
            {
                if(temp1 -> next == head)
                {
                    temp2 -> next = head;
                }
                else
                {
                    temp2 -> next = temp1 -> next;
                }
                free(temp1);
            }
        }
        printf("\nDeletion success!!!");
    }
    printf("Enter any key to go to menu");
    getch();
    system("cls");

}
void display()
{
    struct Node *tmp;
    if(head == NULL)
    {
        printf(" List is empty.");
    }
    else
    {
        tmp = head;
        while(tmp != NULL)
        {
            printf(" Data = %d\n", tmp->data);
            tmp = tmp->next;
        }
    }
    printf("Enter any key to go to menu");
    getch();
    system("cls");

}

