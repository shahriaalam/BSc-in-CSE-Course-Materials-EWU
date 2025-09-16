#include<bits/stdc++.h>
using namespace std;


struct knapsack
{
    int value;
    int weight;
};


void merge(knapsack arr[], int b, int mid, int e)
{
    int n=mid-b+1;
    int m=e-mid;

    knapsack a[n];
    knapsack bb[m];

    for(int i=0; i<n; i++) a[i]=arr[b+i];
    for(int i=0; i<m; i++) bb[i]=arr[mid+1+i];

    int i=0;
    int j=0;
    int k=b;

    while(i<n && j<m)
    {
        if(a[i].value<=bb[j].value)
        {
            arr[k]=a[i];
            k++;
            i++;
        }
        else
        {
            arr[k]=bb[j];
            k++;
            j++;
        }
    }

    while(i<n)
    {
        arr[k]=a[i];
        k++;
        i++;
    }

    while(j<m)
    {
        arr[k]=bb[j];
        k++;
        j++;
    }
}

void mergeSort(knapsack arr[], int b, int e)
{
    if(b<e)
    {
        int mid = b+(e-b)/2;
        mergeSort(arr,b,mid);
        mergeSort(arr, mid+1, e);
        merge(arr, b, mid, e);
    }
}


int main()
{
    int n;
    cin>>n;
    double w;
    cin>>w;
    knapsack a[100005];

    for(int i=0; i<n; i++)
    {
        int x;
        cin>>x;
        a[i].value=x;
    }

    for(int i=0; i<n; i++)
    {
        int x;
        cin>>x;
        a[i].weight=x;
    }

    mergeSort(a,0,n-1);

    int ans=0;
    int i=n-1;

    while(w!=0)
    {
        double min;
        if(a[i].weight<w)min=a[i].weight;
        else min=w;

        w=w-min;
        ans=ans+(min*a[i].value);
        i--;
    }
    cout<<ans<<endl;
    return 0;
}
