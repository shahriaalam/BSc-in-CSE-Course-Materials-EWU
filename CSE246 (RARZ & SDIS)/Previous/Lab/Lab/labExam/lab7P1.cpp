//Cycle Finding and Pringting
#include<bits/stdc++.h>
using namespace std;
vector<int> visited(100005,0);
vector<int>graph[1000005];
vector<int> cycle;

bool checkForCycle(int node, int parent){
    visited[node] = 1;
    for(auto i: graph[node]){
        if(visited[i] == 0){
            if(checkForCycle(i, node)){
                cycle.push_back(i);
                return true;
            }
        }
        else if(i != parent){//any node other than previous node if visited
            cycle.push_back(i);
            return true;
        }
    }
    return false;
}
bool isCycle(int v){
    for(int i=1; i<=v; i++){
        if(!visited[i]){
            if(checkForCycle(i,-1)) return true;
        }
    }
    return false;
}
int main()
{
    int v,e;
    cin>>v>>e;
    int U,V;
    while(e--){
        cin>>U>>V;
        graph[U].push_back(V);
        graph[V].push_back(U);
    }
    if(isCycle(v)){
        sort(cycle.begin(), cycle.end());
        cout<<"YES"<<endl;
        for(auto i: cycle) cout<<i<<" ";
        cout<<endl;
    }
    else cout<<"NO"<<endl;
    return 0;
}