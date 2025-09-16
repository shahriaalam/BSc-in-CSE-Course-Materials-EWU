#include<stdio.h>
#include<stdlib.h>
struct Vertex
{
    int info;
    struct Vertex *nextVertex;
    struct Edge *firstEdge;
}*start = NULL;

struct Edge
{
    struct Vertex *destVertex;
    struct Edge *nextEdge;
};

void create(int u)
{
    struct Vertex *tmp,*ptr;
    tmp = malloc(sizeof(struct Vertex));
    tmp->info = u;
    tmp->nextVertex = NULL;
    tmp->firstEdge = NULL;

    if(start == NULL)
    {
        start = tmp;
        return;
    }
    ptr = start;
    while(ptr->nextVertex!=NULL)
        ptr = ptr->nextVertex;
    ptr->nextVertex = tmp;
}

void deleteVertex(int u)
{
    struct Vertex *tmp,*q;
    struct Edge *p,*temporary;
    if(start == NULL)
    {
        printf("\nNo vertices to be deleted\n");
        return;
    }
    if(start->info == u)
    {
        tmp = start;
        start = start->nextVertex;
    }
    else
    {
        q = start;
        while(q->nextVertex != NULL)
        {
            if(q->nextVertex->info == u)
                break;
            q = q->nextVertex;
        }
        if(q->nextVertex==NULL)
        {
            printf("Vertex not found\n");
            return;
        }
        else
        {
            tmp = q->nextVertex;
            q->nextVertex = tmp->nextVertex;
        }
    }
    p = tmp->firstEdge;
    while(p!=NULL)
    {
        temporary = p;
        p = p->nextEdge;
        free(temporary);
    }
    free(tmp);
    printf("enter any key to go to menu\n");
    getch();
    system("cls");
}
void deleteIncomingEdges(int u)
{
    struct Vertex *ptr;
    struct Edge *q,*tmp;

    ptr = start;
    while(ptr!=NULL)
    {
        if(ptr->firstEdge == NULL)
        {
            ptr = ptr->nextVertex;
            continue;
        }

        if(ptr->firstEdge->destVertex->info == u)
        {
            tmp = ptr->firstEdge;
            ptr->firstEdge = ptr->firstEdge->nextEdge;
            free(tmp);
            continue;
        }
        q = ptr->firstEdge;
        while(q->nextEdge!= NULL)
        {
            if(q->nextEdge->destVertex->info == u)
            {
                tmp = q->nextEdge;
                q->nextEdge = tmp->nextEdge;
                free(tmp);
                continue;
            }
            q = q->nextEdge;
        }
        ptr = ptr->nextVertex;
    }
    printf("enter any key to go to menu\n");
    getch();
    system("cls");
}


struct Vertex *findVertex(int u)
{
    struct Vertex *ptr,*loc;
    ptr = start;
    while(ptr!=NULL)
    {
        if(ptr->info == u )
        {
            loc = ptr;
            return loc;
        }
        else
            ptr = ptr->nextVertex;
    }
    loc = NULL;
    return loc;
}

void insertEdge(int u,int v)
{
    struct Vertex *locu,*locv;
    struct Edge *ptr,*tmp;

    locu = findVertex(u);
    locv = findVertex(v);

    if(locu == NULL )
    {
        printf("\nStart vertex not present, first insert vertex %d\n",u);
        return;
    }
    if(locv == NULL )
    {
        printf("\nEnd vertex not present, first insert vertex %d\n",v);
        return;
    }
    tmp = malloc(sizeof(struct Edge));
    tmp->destVertex = locv;
    tmp->nextEdge = NULL;

    if(locu->firstEdge == NULL)
    {
        locu->firstEdge = tmp;
        return;
    }
    ptr = locu->firstEdge;
    while(ptr->nextEdge!=NULL)
        ptr = ptr->nextEdge;
    ptr->nextEdge = tmp;
    printf("enter any key to go to menu\n");
    getch();
    system("cls");

}

void deleteEdge(int u,int v)
{
    struct Vertex *locu;
    struct Edge *tmp,*q;

    locu = findVertex(u);

    if(locu == NULL )
    {
        printf("\nStart vertex not present\n");
        return;
    }
    if(locu->firstEdge == NULL)
    {
        printf("\nEdge not present\n");
        return;
    }

    if(locu->firstEdge->destVertex->info == v)
    {
        tmp = locu->firstEdge;
        locu->firstEdge = locu->firstEdge->nextEdge;
        free(tmp);
        return;
    }
    q = locu->firstEdge;
    while(q->nextEdge != NULL)
    {
        if(q->nextEdge->destVertex->info == v)
        {
            tmp = q->nextEdge;
            q->nextEdge = tmp->nextEdge;
            free(tmp);
            return;
        }
        q = q->nextEdge;
    }
    printf("\nThis Edge not present in the graph\n");
    printf("enter any key to go to menu\n");
    getch();
    system("cls");
}

void display()
{
    struct Vertex *ptr;
    struct Edge *q;

    ptr = start;
    while(ptr!=NULL)
    {
        printf("%d ->",ptr->info);
        q = ptr->firstEdge;
        while(q!=NULL)
        {
            printf(" %d",q->destVertex->info);
            q = q->nextEdge;
        }
        printf("\n");
        ptr = ptr->nextVertex;
    }
    printf("enter any key to go to menu\n");
    getch();
    system("cls");
}
int main()
{
    int choice,u,origin,destin,nu;

    while(1)
    {
        printf("\n\t1.Insert Vertex\n");
        printf("\t2.Insert an Edge\n");
        printf("\t3.Delete a Vertex\n");
        printf("\t4.Delete an Edge\n");
        printf("\t5.Display\n");
        printf("\t6.Exit\n");
        printf("\n\t\tEnter your choice : ");
        scanf("%d",&choice);

        switch(choice)
        {
        case 1:
            printf("\nHow much data you enter?? : ");
            scanf("%d",&nu);
            for( int i =0; i<nu; i++)
            {
                printf("enter number of data [%d]",i+1);
                scanf("%d",&u);
                create(u);
            }
            break;
        case 2:
            printf("\nEnter an Edge to be inserted : ");
            scanf("%d %d",&origin,&destin);
            insertEdge(origin,destin);
            break;
        case 3:
            printf("\nEnter a vertex to be deleted : ");
            scanf("%d",&u);

            deleteIncomingEdges(u);

            deleteVertex(u);
            break;
        case 4:
            printf("\nEnter an edge to be deleted : ");
            scanf("%d %d",&origin,&destin);
            deleteEdge(origin,destin);
            break;
        case 5:
            display();
            break;
        case 6:
            exit(1);
        default:
            printf("\nWrong choice\n");
            break;
        }
    }

}
