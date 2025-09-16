#include <stdio.h>
#include <stdlib.h>
int size = 0;
void insert(int ar[], int newNum)
{


{
    if (size == 0)
    {
        ar[0] = newNum;
        size ++;
    }
    else
    {
        ar[size] = newNum;
        size ++;
        for (int i = size / 2 - 1; i >= 0; i--)
        {
            heapify(ar, size, i);
        }
    }

}
  printf("Enter any key to goto menu:\n");
    getch();
    system("cls");
}
void swap(int *a, int *b)
{
    int temp = *b;
    *b = *a;
    *a = temp;
}
void heapify(int ar[], int size, int i)
{
    if (size == 1)
    {
        printf("Single element in the heap");
    }
    else
    {
        int lrg = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < size && ar[l] > ar[lrg])
            lrg = l;
        if (r < size && ar[r] > ar[lrg])
            lrg = r;
        if (lrg != i)
        {
           swap(&ar[i], &ar[lrg]);
            heapify(ar, size, lrg);
        }
    }
}

void DltIndex(int ar[], int num)
{
    {

        int i;
        for (i = 0; i < size; i++)
        {
            if (num == i)
                break;
        }

        swap(&ar[i], &ar[size - 1]);
        size -= 1;
        for (int i = size / 2 - 1; i >= 0; i--)
        {
            heapify(ar, size, i);
        }
    }
    printf("Delete Success\n");
     printf("Enter any key to goto menu:\n");
    getch();
    system("cls");
}
void DltData(int ar[], int num)
{
    int i;
    {

        for (i = 0; i < size; i++)
        {
            if (num == ar[i])
                break;
        }

        swap(&ar[i], &ar[size - 1]);
        size -= 1;
        for (int i = size / 2 - 1; i >= 0; i--)
        {
            heapify(ar, size, i);
        }
    }
    printf("Delete Success\n");
      printf("Enter any key to goto menu:\n");
    getch();
    system("cls");
}
void max(int ar[])
{

  printf("largest element in heap = %d", ar[0]);
    printf("Enter any key to goto menu:\n");
    getch();
    system("cls");

}

void printar(int ar[], int size)
{
    for (int i = 0; i < size; ++i)
        printf("%d ", ar[i]);
    printf("\n");
    printf("Enter any key to goto menu:\n");
    getch();
    system("cls");
}
int main()
{
    int ar[15];
    int i,j,k,l,m,n,no,c;
printf("\n1.insert\n2.Print heap\n3.Delete\n4.max value in heap\n");
    while(1)
    {
        printf("\nEnter Your choice:");
        scanf("%d",&m);
        switch (m)
        {
        case 1:
        {
            printf("\nHow many Data you enter (max 1-15 !!):");
            scanf("%d",&l);
            for(int x=0; x<l; x++)
            {
                scanf("%d",&ar[x]);
                insert(ar,ar[x]);
            }
            break;
        }
        case 2:
        {

            printf("Print Heap: ");
            printar(ar, size);
            break;
        }


        case 3:
        {
            printf("Which item you Input??\n1.Data value\n2.Index value\n5.Exit");
            scanf("%d",&c);
            switch (c)
            {
            case 1:

                printf("Input which Data you delete?\n");
                scanf("%d",&no);
                DltData(ar, no);
                break;
            case 2:

                printf("Input index you delete?\n");
                scanf("%d",&n);
                DltIndex(ar, n);
                break;
            }
        }
        break;
            case 4:
                {
                    max(ar);
                    break;
                }

        }
    }

}
