#include <stdio.h>

long int power(int x,int y)
{
    long int r=1;
    if(y == 0)
        return r;
    r=x*(power(x,y-1));
}
int main()
{
    int num,p;
    long int r;

    printf(" Enter base : ");
    scanf("%d",&num);

    printf(" Enter power : ");
    scanf("%d",&p);

    r=power(num,p);
    printf(" The result is =%d",r);


}
