#include <stdio.h>

#include<stdlib.h>
int main()
{
    int n, i, *p;

    printf("Input size of array: ");
    scanf("%d", &n);

    p = (int*) malloc(n * sizeof(int));

    printf("Array elements: \n");
    for(i = 0; i < n; ++i)
    {

        scanf("%d", p + i);
    }
    for(i = 1; i < n; ++i) {
        if (*(p+0) <  *(p+i))
            *(p+0) = *(p+i);
    }

    printf("Largest Number = %d", *p+0);

}
