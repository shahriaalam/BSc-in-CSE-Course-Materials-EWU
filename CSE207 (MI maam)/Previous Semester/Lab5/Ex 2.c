#include<stdio.h>

int Gcd(int n1,int n2);
int main()
{
  int n1,n2,gcd;

  printf("1st number: ");
  scanf("%d",&n1);
  printf("2nd number: ");
  scanf("%d",&n2);

  gcd = Gcd(n1,n2);
  printf("\n The GCD is: %d",gcd);
  return 0;
}

int Gcd(int a,int b)
{
     while(a!=b)
     {
          if(a>b)
              return Gcd(a-b,b);
          else
             return Gcd(a,b-a);
     }
     return a;
}
