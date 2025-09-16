#include<stdio.h>
int main()
{
    int n=5, find=0;
    int arr[n];
    int left=0, right=n-1, flag=0;

    printf("Enter values:\n");
    for(int i=0; i<n; i++)
    {
        scanf("%d", &arr[i]);
    }

     printf("Input Search Number:\n");
     scanf("%d", &find);

    //Binary search star
    for( ; left<=right ; )
    {
        int mid= (left+right)/2;

        if(arr[mid]== find)
        {
            printf("Element found at index %d: ", mid);
            flag=1;
            break;
        }
        else if(arr[mid]< find)
        {
            left= mid+1;
        }
        else
        {
            right= mid-1;
        }

    }

    if(flag!=1)  printf("Element not found");
    return 0;
}
