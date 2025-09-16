#include<stdlib.h>
#include<stdio.h>
#include<conio.h>



struct Node
{
    int data;
    struct Node *next;
}*head = NULL;

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


        printf(" Input data for Node 1 : ");
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
                printf(" Input data for Node %d : ", i);
                scanf(" %d", &data);

                fnNode->data = data;
                fnNode->next = NULL;

                tmp->next = fnNode;
                tmp = tmp->next;
            }
        }
    }
    printf("Creation Done\n\n");

}
void reverse(struct Node* p){

    if(p->next == NULL){

        head = p;
        return;
    }

    /* Calling reverse method recursively */

    reverse(p->next);

    struct Node* rev = p->next;
    rev->next = p;
    p->next = NULL;
}

void print(){

    struct Node* p;
    p = head;

    while(p!=NULL){
        printf("%d ",p->data);
        p=p->next;
    }
    printf("\n");
}

void main()
{
    int choice1, choice2, value, location,num;

    createNodeList();
    printf("Before Reverse :");
    print();
  reverse(head);
  printf("\n\nAfter Reverse :");
  print();
}
