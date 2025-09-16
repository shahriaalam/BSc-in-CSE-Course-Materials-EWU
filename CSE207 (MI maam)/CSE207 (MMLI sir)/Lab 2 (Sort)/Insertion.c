#include<stdio.h>
int main(){
    int n=5, temp=0, j;
    int arr[n];

    printf("Enter values:\n");
    for(int i=0; i<n; i++)
    {
        scanf("%d", &arr[i]);
    }

    //insertion start

    for(int i=1; i<n; i++)
    {
        temp = arr[i];

        for(j=i-1; j>=0 && arr[j]>temp; j--)
        {
            arr[j+1]= arr[j];
        }
        arr[j+1]= temp;
    }

    printf("Sorted Array: ");
    for(int i=0; i<n; i++)
    {
        printf("%d ",arr[i]);
    }
    return 0;
}
