#include<stdio.h>
#include<stdlib.h>

#define size 20

int a[10][10],vertex[10],n,e;

/*STACK FUNCTIONS*/
#define bottom -1

int stack[size],top=bottom;
int stackempty()
{
    return(top=bottom) ? 1:0;
}
int stackfull()
{
    return(top==size-1) ? 1:0;
}

void push(int item)
{
    if(stackfull())
        printf("7STACK IS FULL");
               else
                   stack[++top]=item;
        }

int pop()
{
    if(stackempty())
    {
        printf("7STACK IS EMPTY");
               return -1;
    }
    else
        return stack[top--];
}

int peep()
{
    if(stackempty())
    {
        printf("7STACK IS EMPTY");
               return -1;
    }
    else
        return stack[top];
}

/* QUEUE FUNCTIONS */
#define start -1

int q[size];
int f=start,r=start;

int qempty()
{
    return(f==r)?1:0;
}
int qfull()
{
    return(r==size-1)?1:0;
}

void addq(int c)
{
    if(qfull())
        printf("7QUEUE IS FULL");
               else
                   q[++r]=c;
        }

int delq()
{
    if(qempty())
    {
        printf("7 QUEUE IS EMPTY");
               return -1;
    }
    else
        return q[++f];
}
// j is unvisited adjecent vertex to i
int adjvertex(int i)
{
    int j;
    for(j=0; j if(a[i][j]==1&&vertex[j]==0)
                return j;
                return n;
    }

int visitall()
{
    int i;
    for(i=0; i if(vertex[i]==0)
                return 0;
                return 1;
    }

/*FUNCTION FOR BFS*/
void bfs()
{
    int i,j,k,cur=0;//current vertex is startting vertex
    for(i=0; i vertex[i]=0; //not visited
            printf("

                   BFS path => V%d ",cur+1);
                   addq(cur);
                   vertex[cur]=1;//marking visited vertex
                   while(!visitall())
    {
        if(qempty())
            {
                printf("GRAPH IS DISCONNECTED");
                       break;
            }
            cur=delq();
//visit all vertices which are adjecent to current vertex
            for(j=0; j
        {
//adjecent are not visited
            if(a[cur][j]==1&&vertex[j]==0)
                {
                    printf("V%d ",j+1);
                    addq(j);
//marking visited vertex
                    vertex[j]=1;
                }
            }
        }
}

/*FUNCTION FOR DFS*/
void dfs()
{
    int i,j,k,cur=0;//current vertex is startting vertex
    for(i=0; i vertex[i]=0; //not visited
            printf("DFS path => V%d ",cur+1);
                   push(cur);
                   vertex[cur]=1;//marking visited vertex
                   while(!visitall())
    {
        do
        {
            cur=adjvertex(peep());
                if(cur==n)
                    pop();
            }
            while(cur==n&&!stackempty());
            if(stackempty())
            {
                printf("7 GRAPH IS DISCONNECTED");
                       break;
            }
            if(cur!=n)
            {
                printf(" V%d ",cur+1);
                push(cur);
                vertex[cur]=1;//marking visited vertex
            }
        }
}

/*MAIN PROGRAM*/
void main()
{
    int i,j,k;
    clrscr();
    for(i=0; i<10; i++)
        for(j=0; j<10; j++)
            a[i][j]=0;

    printf("ENTER NO OF VERTICES & EDGES OF UNDIRECTED GRAPH : ");
           scanf("%d%d",&n,&e);

           printf(" ENTER EDGES AS PAIR OF VERTICES

                  ");
                  for(k=1; k<=e; k++)
{
    printf("EDGE %d =>",k);
        scanf("%d%d",&i,&j);
//for undirected graph
        a[i-1][j-1]=1;
    }

    dfs();
    bfs();
    getch();
}
