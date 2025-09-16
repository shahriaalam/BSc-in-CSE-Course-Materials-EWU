#include<stdio.h>
#include<stdlib.h>

struct ListNode
{
        struct ListNode *lchidl;
        int info;
        struct ListNode *rchidl;
};

struct ListNode *insert(struct ListNode *ptr, int ikey);
struct ListNode *Min(struct ListNode *ptr);
struct ListNode *Max(struct ListNode *ptr);
void display(struct ListNode *ptr,int level);
struct ListNode* deleteElement(struct ListNode* node,int data)
{
    struct ListNode* temp;
    if(node==NULL)
        printf("Element not found!");
    else if(node->info>data)
        node->lchidl=deleteElement(node->lchidl,data);
    else if(node->info<data)
        node->rchidl=deleteElement(node->rchidl,data);
    else
    {
        if(node->lchidl!=NULL && node->rchidl!=NULL)
        {
            temp=findMin(node->rchidl);
            node->info=temp->info;
            node->rchidl=deleteElement(node->rchidl,temp->info);
        }
        else
        {
            temp=node;
            if(node->lchidl==NULL)
                node=node->rchidl;
            else if(node->rchidl==NULL)
                node=node->rchidl;
            else
            {
                temp=node;
                if(node->lchidl==NULL)
                    node=node->rchidl;
                else if(node->rchidl==NULL)
                    node=node->lchidl;
                free(temp);
            }

        }

    }
    return node;
}

struct LNode* findMin(struct LNode* ListNode)
{
    if(ListNode==NULL)
        return NULL;
    if(ListNode->lchidl!=NULL)
        return findMin(ListNode->lchidl);
    else
        return ListNode;
        printf("%d",ListNode->lchidl);
}

struct ListNode *insert(struct ListNode *ptr, int ikey )
{
        if(ptr==NULL)
        {
                ptr = (struct ListNode *) malloc(sizeof(struct ListNode));
                ptr->info = ikey;
                ptr->lchidl = NULL;
                ptr->rchidl = NULL;
        }
        else if(ikey < ptr->info) /*Insertion in left subtree*/
                ptr->lchidl = insert(ptr->lchidl, ikey);
        else if(ikey > ptr->info) /*Insertion in right subtree */
                ptr->rchidl = insert(ptr->rchidl, ikey);
        else
                printf("\nDuplicate key\n");
        return ptr;
}/*End of insert( )*/


struct ListNode *Min(struct ListNode *ptr)
{
        if(ptr==NULL)
                return NULL;
        else if(ptr->lchidl==NULL)
        return ptr;
        else
                return Min(ptr->lchidl);
}/*End of min()*/

struct ListNode *Max(struct ListNode *ptr)
{
        if(ptr==NULL)
                return NULL;
        else if(ptr->rchidl==NULL)
        return ptr;
        else
                return Max(ptr->rchidl);
}/*End of max()*/


void display(struct ListNode *ptr,int level)
{
        int i;
        if(ptr == NULL )/*Base Case*/
                return;
        else
    {
                display(ptr->rchidl, level+1);
                printf("\n");
                for (i=0; i<level; i++)
                        printf("    ");
                printf("%d", ptr->info);
                display(ptr->lchidl, level+1);
        }
}
int main( )
{
        struct ListNode *root=NULL,*ptr;
        int choice,k;

        while(1)
        {
                printf("\n");
                printf("1.Insert\n");
                printf("2.Display\n");
                printf("3.Find minimum and maximum\n");
                printf("4.Quit\n");
                printf("\nEnter your choice : ");
                scanf("%d",&choice);

                switch(choice)
                {
                case 1:
                        printf("\nEnter the key to be inserted : ");
                        scanf("%d",&k);
                        root = insert(root, k);
                        break;

        case 2:
            printf("\n");
            display(root,0);
            printf("\n");
            break;

                 case 3:
                        ptr = Min(root);
                        if(ptr!=NULL)
                                printf("\nMinimum key is %d\n", ptr->info );
                        ptr = Max(root);
                        if(ptr!=NULL)
                                printf("\nMaximum key is %d\n", ptr->info );
                        break;

                 case 4:
                        exit(1);

                 default:
                        printf("\nWrong choice\n");
                }/*End of switch */
        }/*End of while */

        return 0;

}/*End of main( )*/

