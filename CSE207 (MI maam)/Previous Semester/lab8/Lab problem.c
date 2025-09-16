#include<stdio.h>
#include<stdlib.h>
struct vrtx
{
        int info;
        struct vrtx *NV;
        struct Edge *firstEdge;
}*start = NULL;

struct Edge
{
        struct vrtx *destvrtx;
        struct Edge *nextEdge;
};

struct vrtx *findvrtx(int u);
void insertvrtx(int u);
void insertEdge(int u,int v);
void deleteEdge(int u,int v);
void deleteIncomingEdges(int u);
void deletevrtx(int u);
void display();

int main()
{
        int choice,u,origin,destin,nu;

        while(1)
        {
                printf("\n1.Insert a vrtx\n");
                printf("2.Insert an Edge\n");
                printf("3.Delete a vrtx\n");
                printf("4.Delete an Edge\n");
                printf("5.Display\n");
                printf("6.Exit\n");
                printf("\nEnter your choice : ");
                scanf("%d",&choice);

                switch(choice)
                {
                 case 1:
                        printf("\nEnter a vrtx to be inserted : ");
                        scanf("%d",&u);
                        insertvrtx(u);
                        break;
                 case 2:
                        printf("\nEnter an Edge to be inserted : ");
                        scanf("%d %d",&origin,&destin);
                        insertEdge(origin,destin);
                        break;
                 case 3:
                        printf("\nEnter a vrtx to be deleted : ");
                        scanf("%d",&u);

                        deleteIncomingEdges(u);

                        deletevrtx(u);
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
void insertvrtx(int u)
{
        struct vrtx *tmp,*ptr;
        tmp = malloc(sizeof(struct vrtx));
        tmp->info = u;
        tmp->NV = NULL;
        tmp->firstEdge = NULL;

        if(start == NULL)
        {
                start = tmp;
                return;
        }
        ptr = start;
        while(ptr->NV!=NULL)
                ptr = ptr->NV;
        ptr->NV = tmp;
}








void deletevrtx(int u)
{
        struct vrtx *tmp,*q;
        struct Edge *p,*temporary;
        if(start == NULL)
        {
                printf("\nNo vertices to be deleted\n");
                return;
        }
        if(start->info == u)
        {
                tmp = start;
                start = start->NV;
        }
        else
        {
        q = start;
                while(q->NV != NULL)
                {
                        if(q->NV->info == u)
                                break;
                        q = q->NV;
                }
                if(q->NV==NULL)
                {
                        printf("vrtx not found\n");
                        return;
                }
                else
                {
                        tmp = q->NV;
                        q->NV = tmp->NV;
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
}
void deleteIncomingEdges(int u)
{
        struct vrtx *ptr;
        struct Edge *q,*tmp;

        ptr = start;
        while(ptr!=NULL)
        {
                if(ptr->firstEdge == NULL)
                {
                        ptr = ptr->NV;
                        continue;
                }

                if(ptr->firstEdge->destvrtx->info == u)
                {
                        tmp = ptr->firstEdge;
                        ptr->firstEdge = ptr->firstEdge->nextEdge;
                        free(tmp);
                        continue;
                }
                q = ptr->firstEdge;
                while(q->nextEdge!= NULL)
                {
                        if(q->nextEdge->destvrtx->info == u)
                        {
                                tmp = q->nextEdge;
                                q->nextEdge = tmp->nextEdge;
                                free(tmp);
                                continue;
                        }
                        q = q->nextEdge;
                }
                ptr = ptr->NV;
        }

}


struct vrtx *findvrtx(int u)
{
        struct vrtx *ptr,*loc;
        ptr = start;
        while(ptr!=NULL)
        {
                if(ptr->info == u )
                {
                        loc = ptr;
                        return loc;
                }
                else
                        ptr = ptr->NV;
        }
        loc = NULL;
        return loc;
}

void insertEdge(int u,int v)
{
        struct vrtx *locu,*locv;
        struct Edge *ptr,*tmp;

        locu = findvrtx(u);
        locv = findvrtx(v);

        if(locu == NULL )
        {
                printf("\nStart vrtx not present, first insert vrtx %d\n",u);
                return;
        }
        if(locv == NULL )
        {
                printf("\nEnd vrtx not present, first insert vrtx %d\n",v);
                return;
        }
        tmp = malloc(sizeof(struct Edge));
        tmp->destvrtx = locv;
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

}

void deleteEdge(int u,int v)
{
        struct vrtx *locu;
        struct Edge *tmp,*q;

        locu = findvrtx(u);

        if(locu == NULL )
        {
                printf("\nStart vrtx not present\n");
                return;
        }
        if(locu->firstEdge == NULL)
        {
                printf("\nEdge not present\n");
                return;
        }

        if(locu->firstEdge->destvrtx->info == v)
        {
                tmp = locu->firstEdge;
                locu->firstEdge = locu->firstEdge->nextEdge;
                free(tmp);
                return;
        }
        q = locu->firstEdge;
        while(q->nextEdge != NULL)
        {
                if(q->nextEdge->destvrtx->info == v)
                {
                        tmp = q->nextEdge;
                        q->nextEdge = tmp->nextEdge;
                        free(tmp);
                        return;
                }
                q = q->nextEdge;
        }
        printf("\nThis Edge not present in the graph\n");
}

void display()
{
        struct vrtx *ptr;
        struct Edge *q;

        ptr = start;
        while(ptr!=NULL)
        {
                printf("%d ->",ptr->info);
                q = ptr->firstEdge;
                while(q!=NULL)
                {
                        printf(" %d",q->destvrtx->info);
                        q = q->nextEdge;
                }
                printf("\n");
                ptr = ptr->NV;
         }
}
