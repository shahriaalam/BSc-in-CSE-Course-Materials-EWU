#include<bits/stdc++.h>
using namespace std;

int upperBound(int arr[], int key, int n){
    int low = 0;
    int high = n;
    while(low<=high){
        int mid = low + (high-low)/2;
        if(arr[mid]>key){
            if(mid==0){
                return mid;
            }
            else if(arr[mid-1]<=key){
                return mid;
            }
            else{
                high=mid;
            }
        }
        else{
            low=mid+1;
        }
    }
    
    return n+1;
}

int lowerBound(int arr[], int key, int n){
    int low=0;
    int high=n;
    while(low<=high){
        int mid = low+(high-low)/2;
        if(arr[mid]==key){
            return mid;
        }
        else if(arr[mid]<key){
            if(mid==n){
                return mid;
            }
            else if(arr[mid+1]>key){
                return mid;
            }
            else{
                high=mid;
            }
        }
        else{
            low=mid+1;
        }
    }
    return 0;
}

int main()
{
    int arr[100005];
    int n, k;
    cin>>n>>k;

    for(int i=0;i<n;i++){
        cin>>arr[i];
    }


    int up = upperBound(arr,k,n-1);
    //cout<<up<<endl;

    if(up==n)cout<<up<<" ";
    else{
        int i=up;
        while(i!=n){
            if(arr[i]==arr[i+1]){
                i++;
            }
            else{
                break;
            }
        }
        cout<<i<<" ";
    }

    int lo = lowerBound(arr,k,n-1);
    //cout<<lo<<endl;

    if(lo==0)cout<<lo<<endl;
    else{
        int i=lo;
        while(lo!=0){
            if(arr[i]==arr[i-1]){
                i--;
            }
            else{
                break;
            }
        }
        cout<<i<<endl;
    }
    return 0;
}