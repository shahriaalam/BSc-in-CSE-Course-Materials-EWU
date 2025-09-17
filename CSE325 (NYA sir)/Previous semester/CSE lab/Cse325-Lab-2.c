#include<pthread.h>
#include<stdio.h>
#define a 5
void *oddmultiple(void *id)
{
    int i, s=0, s1=0,s2=0,s3=0,s4=0;
    if(id == 0)
    {

        for(i=1; i<=200; i++)
        {
            if(i%3==0 && i%2!=0)
            {
                printf("%d ", i);
                    s++;
            }
        }
        printf("\n Total number of Odd multiples in Thread 1 is %d\n", s);
    }
    else if( id == 1)
    {
        for(i=201; i<=400; i++)
        {
            if(i%3==0 && i%2!=0)
            {
                printf("%d ", i);
                s1++;
            }
        }

        printf("\n Total number of Odd multiples in Thread 2 is %d\n",s1);
    }
    else if(id == 2)
    {
        for(i=401; i<=600; i++)
        {
            if(i%3==0 && i%2!=0)
            {
                printf("%d ", i);
                  s2++;
            }
        }

        printf(" \n Total number of Odd multiples in Thread 3 is %d\n",s2);
    }
    else if( id == 3)
    {
        for(i=601; i<=800; i++)
        {
            if(i%3==0 && i%2!=0)
            {
                printf("%d ", i);
                s3++;
            }
        }

        printf("\n Total number of Odd multiples in Thread 4 is %d\n",s3);
    }
    else if(id == 4)
    {
        for(i=801; i<=1000; i++)
        {
            if(i%3==0 && i%2!=0)
            {
                printf("%d ", i);
                s4++;
            }
        }

        printf("Total number of Odd multiples in Thread 5 is %d\n",s4);
    }
}

int main()
{


    pthread_t th[a];
    int i;
    for(i=0; i<a; i++)
    {
        pthread_create(&th[i],NULL,oddmultiple,(void *) i);
        pthread_join(th[i], NULL);
    }
}




























