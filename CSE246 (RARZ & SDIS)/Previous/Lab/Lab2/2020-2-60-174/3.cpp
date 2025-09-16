#include<bits/stdc++.h>
using namespace std;

struct work
{
    int start;
    int end;
};

void merge(work arr[], int b, int mid, int e){
    int n = mid-b+1;
    int m = e-mid;

    work a[n];
    work bb[m];

    for(int i=0;i<n;i++) a[i]=arr[b+i];
    for(int i=0;i<m;i++) bb[i]=arr[mid+1+i];

    int i=0;
    int j=0;
    int k=b;

    while(i<n && j<m){
        if(a[i].end<=bb[j].end){
            arr[k]=a[i];
            k++;
            i++;
        }
        else{
            arr[k]=bb[j];
            k++;
            j++;
        }
    }

    while(i<n){
        arr[k]=a[i];
        k++;
        i++;
    }

    while(j<m){
        arr[k]=bb[j];
        k++;
        j++;
    }
}

void mergeSort(work arr[], int b, int e){
    if(b<e){
        int mid = b+(e-b)/2;
        mergeSort(arr,b,mid);
        mergeSort(arr, mid+1, e);

        merge(arr, b, mid, e);
    }
}

int main()
{
    work a[100005];
    int n;
    cin>>n;
    for(int i=0;i<n;i++){
        int n,m;
        cin>>n>>m;
        a[i].start=n;
        a[i].end=m;
    }
    mergeSort(a,0,n-1);
    int ans=1;

    work b[100005];

    b[0].start=a[0].start;
    b[0].end=a[0].end;

    for(int i=0;i<n-1;i++){
        if(b[i].end<=a[i+1].start){
            ans++;
            b[i+1].start=a[i+1].start;
            b[i+1].end=a[i+1].end;
        }
    }
    cout<<ans<<endl;
    return 0;
}