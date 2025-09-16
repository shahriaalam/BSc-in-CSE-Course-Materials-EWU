#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n;
    cin>>n;
    vector<int> arr(10e5+7);

    for(int i=0;i<n;i++){
        int a;
        cin>>a;
        arr[a]++;
    }
    
    int max = 0;
    int index = 0;
    for(int i=0;i<arr.size();i++){
        if(arr[i]>=max){
            max = arr[i];
            index = i;
        }
    }
    cout<<index<<endl;
    return 0;
}