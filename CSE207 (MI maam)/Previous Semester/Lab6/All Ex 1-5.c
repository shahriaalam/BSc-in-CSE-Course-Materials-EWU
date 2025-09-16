#include<stdio.h>
#include<stdlib.h>
struct L_Node
{
    int info;
    struct L_Node *LC;
    struct L_Node *RC;
};
struct L_Node* insert(struct L_Node* node,int data)
{
    if(node==NULL)
    {
        struct L_Node* temp=(struct L_Node*)malloc(sizeof(struct L_Node));
        temp->info=data;
        temp->LC=NULL;
        temp->RC=NULL;
        return temp;
    }
    else if(node->info>=data)
        node->LC=insert(node->LC,data);
    else
        node->RC=insert(node->RC,data);
    return node;
}
struct L_Node* findMin(struct L_Node* node)
{
    if(node==NULL)
        return NULL;
    if(node->LC!=NULL)
        return findMin(node->LC);
    else
        return node;
    printf("%d",node->LC);
}
struct L_Node* delete(struct L_Node* node,int data)
{
    struct L_Node* temp;
    if(node==NULL)
        printf("Element not found!");
    else if(node->info>data)
        node->LC=delete(node->LC,data);
    else if(node->info<data)
        node->RC=delete(node->RC,data);
    else
    {
        if(node->LC!=NULL && node->RC!=NULL)
        {
            temp=findMin(node->RC);
            node->info=temp->info;
            node->RC=delete(node->RC,temp->info);
        }
        else
        {
            temp=node;
            if(node->LC==NULL)
                node=node->RC;
            else if(node->RC==NULL)
                node=node->RC;
            else
            {
                temp=node;
                if(node->LC==NULL)
                    node=node->RC;
                else if(node->RC==NULL)
                    node=node->LC;
                free(temp);
            }

        }

    }
    return node;
}

int search(struct L_Node* node,int data)
{
    if(node==NULL)
        return 0;
    else if(node->info<data)
        return search(node->RC,data);
    else if(node->info>data)
        return search(node->LC,data);
    else
        return 1;
}

void printInorder(struct L_Node *node)
{
    if(node==NULL)
    {
        return;
    }
    printInorder(node->LC);
    printf("%d ",node->info);
    printInorder(node->RC);
}
void preorder(struct L_Node *ptr)
{
    if(ptr !=NULL)
    {
        printf("%d ",ptr->info);
        preorder(ptr->LC);
        preorder(ptr->RC);
    }
}
void postorder(struct L_Node *ptr)
{
    if(ptr !=NULL)
    {
        postorder(ptr->LC);
        postorder(ptr->RC);
        printf("%d ",ptr->info);
    }
}
struct L_Node *Min(struct L_Node *ptr)
{
    if(ptr==NULL)
        return NULL;
    else if(ptr->LC==NULL)
        return ptr;
    else
        return Min(ptr->LC);
}

struct L_Node *Max(struct L_Node *ptr)
{
    if(ptr==NULL)
        return NULL;
    else if(ptr->RC==NULL)
        return ptr;
    else
        return Max(ptr->RC);
}


void main()
{
    struct L_Node* root=NULL,*ptr;
    int data,choice,c,n;

    while(1)
    {
        printf("\n1. Insert \n2. Delete \n3. Search \n4. Inorder \n5. Preorder \n6. Postorder \n7. Maximum. \n8. Minimum.\n9. Exit. ");
        scanf("%d",&choice);
        switch(choice)
        {
        case 1:

            printf("\nEnter the value of tree node  :");
            scanf("%d",&data);
            root=insert(root,data);
            break;
        case 2:
            scanf("%d",&data);
            if(root==NULL)
                printf("\nNo node to delete");
            root=delete(root,data);
            break;
        case 3:
            scanf("%d",&c);
            if(search(root,c))
                printf("\nThe element is present in the Tree");

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

