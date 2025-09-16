#include <stdio.h>
#include<stdlib.h>
int sort(int *P,int n)
{
    int i,j,temp;
    for(i=0; i<n; i++)
        for(j=i+1; j<n; j++)
        {
            if(*(P+i)>*(P+j))
            {
                temp=*(P+i);
                *(P+i)=*(P+j);
                *(P+j)=temp;
            }
        }
}
int main()
{
    int n, i, *pt;
    printf("Input size of Array: ");
    scanf("%d", &n);
    pt = (int*) malloc(n * sizeof(int));
    printf("Array elements:");
    for(i = 0; i < n; ++i)
    {
        scanf("%d", pt + i);
    }
    sort(pt,n);
    printf(" Sort: \n");
    for(i=0; i<n; i++)
        printf("%d\n",*(pt+i));
}
