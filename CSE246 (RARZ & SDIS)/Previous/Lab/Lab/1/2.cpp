//Height of the Students
#include<bits/stdc++.h>
using namespace std;

struct student{
    int roll;
    double height;
};

void merge(student arr[], int b, int mid, int e){
    int n = mid-b+1;
    int m = e-mid;

    student a[n];
    student bb[m];

    for(int i=0;i<n;i++) a[i]=arr[b+i];
    for(int i=0;i<m;i++) bb[i]=arr[mid+1+i];

    int i=0;
    int j=0;
    int k=b;

    while(i<n && j<m){
        if(a[i].height<=bb[j].height){
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

void mergeSort(student arr[], int b, int e){
    if(b<e){
        int mid = b+(e-b)/2;
        mergeSort(arr,b,mid);
        mergeSort(arr, mid+1, e);

        merge(arr, b, mid, e);
    }
}

int main()
{
    student arr[100005];
    int n;
    cin>>n;
    for(int i=0;i<n;i++){
        double a;
        cin>>a;
        arr[i].height=a;
        arr[i].roll=i+1;
    }

    int k;
    cin>>k;

    mergeSort(arr,0,n-1);
/*
    for(int i=0;i<n;i++){
        cout<<arr[i].height<<" "<<arr[i].roll<<endl;
    }
*/    
   cout<<arr[k-1].roll<<endl;
    return 0;
}