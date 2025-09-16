#include<stdlib.h>
#include<stdio.h>
#include<conio.h>
void createNodeList();
void insertAtBeginning(int);
void insertAtEnd(int);
void insertAtAfter(int,int);
void deleteBeginning();
void deleteEnd();
void deletepos(int);
void reverseList();
void display();
void dltdu();
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
            printf("\t1. Creating\n\t2. Insert(Beginning,end,At any position)\n\t3. Delete(Beginning,end,At any position)\n\t4. Display\n\t5. Reverse\n\t6. Remove Duplicates\n\t7. Exit\nEnter your choice: ");
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
            while(1)
            {
                printf("\nSelect from the following Inserting options\n");
                printf("1. At Beginning\n2. At End\n3. After a Node\n4. Cancel\nEnter your choice: ");
                scanf("%d",&choice2);
                switch(choice2)
                {
                case 1:
                    insertAtBeginning(value);
                    break;
                case 2:
                    insertAtEnd(value);
                    break;
                case 3:
                    printf("where u enter value/:: ");
                    scanf("%d",&location);
                    insertAfter(value,location);
                    break;

                }
            }
        case 3:
            while(1)
            {
                printf("\nEnter Your choice ::: \n");
                printf("1. At Beginning\n2. At End\n3. Specific Node\n4. Cancel\nEnter your choice: ");
                scanf("%d",&choice2);
                switch(choice2)
                {
                case 1:
                    deleteBeginning();
                    break;
                case 2:
                    deleteEnd();
                    break;
                case 3:
                    printf("Enter the location : ");
                    scanf("%d",&location);
                    deletepos(location);
                    break;

                }
            }

        case 4:
            display();
            break;
        case 5:
            reverseList();
            break;
        case 6:
            dltdu();
            break;
        case 7:
            exit(0);
        default:
            printf("\nPlease select correct digit !!!");
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
        printf(" Sorry!!!.");
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
    printf("Creation Done\n\n");
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
void deletepos(int delValue)
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
void reverseList()
{
    struct Node *prevNode, *curNode;

    if(head != NULL)
    {
        prevNode = head;
        curNode = head->next;
        head = head->next;

        prevNode->next = NULL;

        while(head != NULL)
        {
            head = head->next;
            curNode->next = prevNode;

            prevNode = curNode;
            curNode = head;
        }

        head = prevNode;

        printf("SUCCESSFULLY REVERSED LIST\n");
         printf("\nEnter any key to go to menu");
    getch();
    system("cls");
    }
}
void dltdu()
{
    struct Node *p, *q, *prev, *temp;

    p = q = prev = head;
    q = q->next;
    while (p != NULL)
    {
        while (q != NULL && q->data != p->data)
        {
            prev = q;
            q = q->next;
        }
        if (q == NULL)
        {
            p = p->next;
            if (p != NULL)
            {
                q = p->next;
            }
        }
        else if (q->data == p->data)
        {
            prev->next = q->next;
            temp = q;
            q = q->next;
            free(temp);
        }
    }
    printf("Duplicate Number delete done \n\n");
     printf("Enter any key to go to menu");
    getch();
    system("cls");
}

