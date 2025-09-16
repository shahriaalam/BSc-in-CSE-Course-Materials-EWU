#include<stdio.h>
int main()
{
    int n=5, find=0, flag=0;
    int arr[n];

    printf("Enter values:\n");
    for(int i=0; i<n; i++)
    {
        scanf("%d", &arr[i]);
    }

     printf("Input Search Number:\n");
     scanf("%d", &find);

    //Linear search start
    for(int i=0; i<n ; i++ )
    {
        if(arr[i]== find)
        {
            printf("Element found at index %d: ",i);
            flag=1;
            break;
        }
    }

    if(flag!=1)  printf("Element not found");
    return 0;
}

