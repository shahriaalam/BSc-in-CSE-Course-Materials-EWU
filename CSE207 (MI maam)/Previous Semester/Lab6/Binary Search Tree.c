#include<stdio.h>
#include<stdlib.h>
struct ListNode
{
    int info;
    struct ListNode *lChild;
    struct ListNode *rChild;
};
struct ListNode* insertElement(struct ListNode* node,int data)
{
    if(node==NULL)
    {
        struct ListNode* temp=(struct ListNode*)malloc(sizeof(struct ListNode));
        temp->info=data;
        temp->lChild=NULL;
        temp->rChild=NULL;
        return temp;
    }
    else if(node->info>=data)
        node->lChild=insertElement(node->lChild,data);
    else
        node->rChild=insertElement(node->rChild,data);
    return node;
}
struct ListNode* findMin(struct ListNode* node)
{
    if(node==NULL)
        return NULL;
    if(node->lChild!=NULL)
        return findMin(node->lChild);
    else
        return node;
    printf("%d",node->lChild);
}
struct ListNode* deleteElement(struct ListNode* node,int data)
{
    struct ListNode* temp;
    if(node==NULL)
        printf("Element not found!");
    else if(node->info>data)
        node->lChild=deleteElement(node->lChild,data);
    else if(node->info<data)
        node->rChild=deleteElement(node->rChild,data);
    else
    {
        if(node->lChild!=NULL && node->rChild!=NULL)
        {
            temp=findMin(node->rChild);
            node->info=temp->info;
            node->rChild=deleteElement(node->rChild,temp->info);
        }
        else
        {
            temp=node;
            if(node->lChild==NULL)
                node=node->rChild;
            else if(node->rChild==NULL)
                node=node->rChild;
            else
            {
                temp=node;
                if(node->lChild==NULL)
                    node=node->rChild;
                else if(node->rChild==NULL)
                    node=node->lChild;
                free(temp);
            }

        }

    }
    return node;
}

int search(struct ListNode* node,int data)
{
    if(node==NULL)
        return 0;
    else if(node->info<data)
        return search(node->rChild,data);
    else if(node->info>data)
        return search(node->lChild,data);
    else
        return 1;
}

void printInorder(struct ListNode *node)
{
    if(node==NULL)
    {
        return;
    }
    printInorder(node->lChild);
    printf("%d ",node->info);
    printInorder(node->rChild);
}
void preorder(struct ListNode *ptr)
{
    if(ptr !=NULL)
    {
        printf("%d ",ptr->info);
        preorder(ptr->lChild);
        preorder(ptr->rChild);
    }
}
void postorder(struct ListNode *ptr)
{
    if(ptr !=NULL)
    {
        postorder(ptr->lChild);
        postorder(ptr->rChild);
        printf("%d ",ptr->info);
    }
}
struct ListNode *Min(struct ListNode *ptr)
{
    if(ptr==NULL)
        return NULL;
    else if(ptr->lChild==NULL)
        return ptr;
    else
        return Min(ptr->lChild);
}

struct ListNode *Max(struct ListNode *ptr)
{
    if(ptr==NULL)
        return NULL;
    else if(ptr->rChild==NULL)
        return ptr;
    else
        return Max(ptr->rChild);
}


void main()
{
    struct ListNode* root=NULL,*ptr;
    int data,choice,c,n;

    while(1)
    {
        printf("\n\t1. Insert element\n\t2. Delete element\n\t3. Search element\n\t4. Inorder Traversal\n\t5. Preorder Traversal\n\t6. Postorder Traversal\n\t7. Maximum. \n\t8. Minimum.\n\t9. Exit. ");
        printf("\n\nEnter your choice >>>");
        scanf("%d",&choice);
        system("cls");
        switch(choice)
        {
        case 1:
            printf("How much data you enter ??");
            scanf("%d",&n);
            for(int j=0; j<n; j++)
            {
                printf("\nEnter the value of tree node [%d] :",j+1);
                scanf("%d",&data);
                root=insertElement(root,data);
            }
            printf("\n\nsuccessful Insertion.\nEnter any key to go to menu.");
            getch();
            system("cls");
            break;
        case 2:
            scanf("%d",&data);
            if(root==NULL)
                printf("\nNo node to delete");
            root=deleteElement(root,data);
            printf("\n\nsuccessful Deletetion.\nEnter any key to go to menu.");
            getch();
            system("cls");
            break;
        case 3:
            scanf("%d",&c);
            if(search(root,c))
                printf("\nThe element is present in the Tree");
            else
                printf("Sorry!!\nThe element is present in the Tree");
            break;
        case 4:
            printf("\n");
            printInorder(root);
            break;
        case 5:
            preorder(root);

        case 6:
            postorder(root);
            break;
        case 7:
            ptr = Min(root);
            if(ptr!=NULL)
                printf("\nMinimum key is %d\n", ptr->info );

            break;
        case 8:
            ptr = Max(root);
            if(ptr!=NULL)
                printf("\nMaximum key is %d\n", ptr->info );
            break;
        }
    }
}
