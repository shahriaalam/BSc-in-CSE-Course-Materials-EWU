#include <stdio.h>
int Lcm(int a, int b);

int main()
{
    int n1, n2, l;
    printf(" 1st no for LCM : ");
    scanf("%d", &n1);
    printf(" 2nd no for LCM : ");
    scanf("%d", &n2);
    if(n1 >  n2)
        l = Lcm(n2, n1);
    else
        l = Lcm(n1, n2);
    printf(" The LCM of %d and %d :  %d\n\n", n1, n2, l);

}
int Lcm(int a, int b)
{
    static int m = 0;

    m += b;

    if((m % a == 0) && (m % b == 0))
    {
        return m;
    }
    else
    {
        Lcm(a, b);
    }
}
