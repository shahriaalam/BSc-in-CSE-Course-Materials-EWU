#include<bits/stdc++.h>
using namespace std;

void merge(int arr[], int b, int mid, int e){
    int aa = mid - b + 1;
    int bb = e-mid;

    int sub1[aa];
    int sub2[bb];

    for(int i=0;i<aa;i++) sub1[i]=arr[b+i];
    for(int i=0;i<bb;i++) sub2[i]=arr[mid+1+i];

    int i=0;
    int j=0;
    int k=b;

    while(i<aa && j<bb){
        if(sub1[i]<=sub2[j]){
            arr[k]=sub1[i];
            k++;
            i++;
        }
        else{
            arr[k]=sub2[j];
            k++;
            j++;
        }
    }

    while(i<aa){
        arr[k]=sub1[i];
        k++;
        i++;
    }

    while(j<bb){
        arr[k]=sub2[j];
        k++;
        j++;
    }
}

void mergeSort(int arr[], int b, int e){
    if(b<e){
        int mid = b+(e-b)/2;
        mergeSort(arr,b,mid);
        mergeSort(arr,mid+1,e);

        merge(arr,b,mid,e);
    }
}

int main()
{
    int n;
    cin>>n;
    int arr[100005];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }

    mergeSort(arr,0,n-1);

    int min = INT_MAX,ans;

    for(int i=1;i<n;i++){
        ans = abs(arr[i-1]-arr[i]);
        if(ans<min){
            min = ans;
        }
    }

    cout<<min<<endl;

    return 0;
}