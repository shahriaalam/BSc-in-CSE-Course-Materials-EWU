#include <stdio.h>
int main()
{
    int array[100], i,j=0,n;

    printf("Enter number of elements in array\n");
    scanf("%d", &n);

    printf("Enter %d elements\n", n);

    for (i = 0; i< n; i++)
        scanf("%d", &array[i]);
    {

    for(i=0; array[i] ;i++){

        if(array[i] >0){
            array[j] = array[i];
            j++;
        }
    }
    array[j] = '\0';

        printf("After Dlt:\n");

        for (i = 0; i < n - 1; i++)
            printf("%d\n", array[i]);
    }

}
