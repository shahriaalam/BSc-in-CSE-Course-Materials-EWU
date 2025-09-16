#include <stdio.h>
#define MAX 5
int Queue1[MAX],Queue2[MAX];
int j=-1,k=-1,x=-1,y=-1;

void display(int Queue[],int *f, int *r)
{
    int i;
    if(*f == -1)
        printf("queue is empty ");
    else
    {
        for(i=*f; i<=*r; i++)
            printf("%d\t",Queue[i]);
    }
}
void enq(int Queue[],int *f,int *r,int val)
{
    if(*r == MAX-1)
        printf("Queue is Full");
    else if(*f == -1 && *r == -1)
        *f=*r=0;
    else
        *r=*r+1;
    Queue[*r]=val;
}
main()
{
    int i,val;
     printf("\nenter value :\n");
    for(i=0; i<MAX; i++)
    {

        scanf("%d",&val);
        enq(Queue1,&j,&k,val);
    }
    printf("\n1st queue  :");
    display(Queue1,&j,&k);

    for(i=j; i<=k; i++)
        enq(Queue2,&x,&y,Queue1[i]);
    printf("\2nd queue :");
    display(Queue2,&x,&y);

}

