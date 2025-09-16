
#include <stdio.h>
#include <stdlib.h>
#define MAX 10
int queue[MAX],f=-1,r=-1;

void enq()
{
    printf("enter the data :");
    int val;
    if(r==MAX-1)
    {
        printf("Queue full");
        return;
    }

    else if(f == -1 && r == -1)
        f=r=0;
    else
        r=r+1;
    scanf("%d",&val);
    queue[r]=val;
}
void deq()
{
    if(f==-1)
    {
        printf("underflow");
        return;
    }
    if(f ==r)
        f=r=-1;
    else
        f=f+1;
}

void display()
{
    int i;
    if(f ==-1)
        printf("queue empty\n");
    else
    {
        for(i=f; i<=r; i++)
            printf("%d\t",queue[i]);
    }
}
void move(int i)
{
    for( ; i<r; i++)
        queue[i]=queue[i+1];

}
void deletenegative()
{
    int i;
    if(f ==-1)
        printf("queue empty\n");
    else
    {
        for(i=f; i<=r;)
        {
            if(queue[i] <0)
            {
                if(i==f)
                {
                    deq();
                    i=i+1;
                }
                else
                {
                    move(i);
                    r=r-1;
                    i=i-1;
                }
            }
            else
                i=i+1;
        }
    }
}

main()
{
    int n,i;
    printf("enter the number of elements:: ");
    scanf("%d",&n);
    for(i=1; i<=n; i++)
        enq();
    display();
    printf("\nAfter deleting negative values\n");
    deletenegative();
    display();
}
