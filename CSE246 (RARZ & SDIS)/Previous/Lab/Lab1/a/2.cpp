#include<bits/stdc++.h>
using namespace std;

void merge(vector<pair<double,int>>&v, int b, int mid, int e){
    int n = mid-b+1;
    int m = e-mid;

    vector<pair<double, int>> s1(n+1);
    vector<pair<double, int>> s2(m+1);

    for(int i=1;i<=n;i++){
        double a = v[b+i].first;
        s1.push_back({a,i});
    }
    
    for(int i=1;i<=m;i++){
        double a = v[mid+1+i].first;
        s2.push_back({a,i});
    }

    int i=1;
    int j=1;
    int k=b;

    while(i<=n && j<=m){
        if(s1[i].first <= s2[j].first){
            v[k].first = s1[i].first;
            v[k].second = i;
            k++;
            i++;
        }
        else{
            v[k].first = s2[j].first;
            v[k].second = j;
            k++;
            j++;
        }
    }

    while(i<=n){
        v[k].first=s1[i].first;
        v[k].second=i;
        k++;
        i++;
    }
    
    while(j<=m){
        v[k].first=s2[j].first;
        v[k].second=j;
        k++;
        j++;
    }
}

void mergeSort(vector<pair<double,int>>&v, int b, int e){
    if(b<e){
        int mid = b+(e-b)/2;
        mergeSort(v,b,mid);
        mergeSort(v,mid+1,e);

        merge(v,b,mid,e);
    }
}

int main()
{
    int n;
    cin>>n;
    double arr[100005];
    arr[0]=0;
    for(int i=1;i<=n;i++){
        cin>>arr[i];
    }

    vector<pair<double,int>>v;

    for(int i=1;i<=n;i++){
        double a = arr[i];
        v.push_back({a,i});
    }

    for(int i=0;i<v.size();i++){
        cout<<v[i].first<<" "<<v[i].second<<endl;
    }

    mergeSort(v,0,v.size()-1);

    cout<<"After sort: "<<endl;
    for(int i=0;i<v.size();i++){
        cout<<v[i].first<<" "<<v[i].second<<endl;
    }

    return 0;
}