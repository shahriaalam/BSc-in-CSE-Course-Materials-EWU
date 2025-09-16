#include <iostream>
#include<stdlib.h>
using namespace std;
int main()
{
    int n,*p;
    cout<<"Input size of array:\n";
    cin>>n;
    cout<< "Enter array element one by one:\n";
    p=(int*)malloc(n*sizeof(int));

    for(int i=0; i<n; i++)
    {
        cin>>*(p+i);
    }
    for(int i=1; i<n; i++)
    {
       if(*(p+0)<*(p+i)){*(p+0)=*(p+i);}
    }
    cout<<"Expected Output: "<<*p+0<<endl;
    return 0;
}
