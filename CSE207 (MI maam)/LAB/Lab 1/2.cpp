#include <iostream>
#include<stdlib.h>
using namespace std;

int sort(int *P,int n)
{
  int temp;
    for(int i=0; i<n; i++)
        for(int j=i+1; j<n; j++)
        {
            if(*(P+i)>*(P+j))
            {
                temp=*(P+i);
                *(P+i)=*(P+j);
                *(P+j)=temp;
            }
        }
}
int main()
{
    int n,*p;
    cout<<"Input size of array:\n";
    cin>>n;
    cout<< "Enter array element one by one:\n";

    for(int i=0; i<n; i++)
    {
        cin>>*(p+i);
    }
    sort(p+0,n);
    cout<<"\nSort:"<<endl;
    for(int i=0; i<n; i++)
    {
       cout<<*(p+i)<<" ";
    }
    return 0;
}





