#include <iostream>
#include<stdlib.h>
using namespace std;
int main()
{
    int n,*p,k;
    cout<<"Input size of array:\n";
    cin>>n;
    cout<< "Enter array element one by one:\n";
    p=(int*)malloc(n*sizeof(int));

    for(int i=0; i<n; i++)
    {
        cin>>*(p+i);
    }

    cout<<"\nAfter deletion:"<<endl;
    for(int i=0; i<n; i++)
    {
        if(*(p+i)<0)
        {
            for(int j=i; j<n-1; j++)
            {
                k=j+1;
              *(p+i)=*(p+k);
            }
            i--;
            n--;
        }
    }

    for(int i=0;i<n;i++)
        {
          cout<<(*(p+i))<<" ";
        }
    return 0;
}
