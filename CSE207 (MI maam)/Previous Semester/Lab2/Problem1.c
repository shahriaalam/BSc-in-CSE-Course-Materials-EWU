#include <stdio.h>
#include <stdlib.h>

struct node
{
    int data;
    struct node *next;
}*head;

void createNodeList(int n);
void displayList();

int main()
{
    int n,y;
      struct node *ND, *tmp;
    int data, i,j,p;
start:
    {


		printf("\n\t(1) Create A NODELIST \n\t(2) Display NODELIST\n\t(3) Insert at the begening NODELIST\n\t(4) Insert at any position NODELIST\n\t(5)Exit");
		printf("\n enter Your choice : ");
		scanf("%d",&y);
    }
    switch(y)
    {
    case 1:
        {

        }
            system("cls");
    printf(" Input the number of nodes : ");
    scanf("%d", &n);
    head = (struct node *)malloc(sizeof(struct node));

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
            ND = (struct node *)malloc(sizeof(struct node));
            if(ND == NULL)
            {
                printf(" Memory can not be allocated.");
                break;
            }
            else
            {
                printf(" Input data for node %d : ", i);
                scanf(" %d", &data);

                ND->data = data;
                ND->next = NULL;

                tmp->next = ND;
                tmp = tmp->next;
            }
        }
    }
    printf("\n\t..::Enter any key to go Menu::..\n");
        getch();
    system("cls");
        goto start;
    case 2:
            system("cls");
        {
           struct node *tmp;
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
        }
        printf("\n\t..::Enter any key to go Menu::..\n");
        getch();
            system("cls");

    case 3:
        {
             ND = (struct node*)malloc(sizeof(struct node));
printf("Enter the data");
scanf("%d",&j);
    if(ND == NULL)
    {
        printf("Unable to allocate memory.");
    }
    else
    {

        ND->data = j;
        ND->next = head;

        head = ND;

        printf("\nDATA INSERTED SUCCESSFULLY\n");
    }
    goto start;
        }

    case 4:
        {
printf("enter the value :");
scanf("%d",&data);
printf("enter the value :");
scanf("%d",&p);
struct node *ptr = (struct node*)malloc(sizeof(struct node));
    	ptr->data=data;

    	int i;
    	struct node *tmp=head;
    	if(p==1)
    {

        		ptr->next=tmp;
            head=ptr;
        		return;
    	}

    	for(i=1;i<p-1;i++)
    	{
        		tmp=tmp->next;
    	}

    	ptr->next=tmp->next;


    	tmp->next=ptr;
        }
         goto start;
    case 5:
        {
            exit;
        }
    }


}


