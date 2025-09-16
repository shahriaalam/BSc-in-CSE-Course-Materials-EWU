//Topological Sorting in Ascending order
#include<bits/stdc++.h>
using namespace std;
vector<int>graph[100005];
stack<int> st;
vector<int>visited(100005,0);

void dfs(int node){
    visited[node]=1;
    for(auto i: graph[node]){
        if(!visited[i])
            dfs(i);
    }
    st.push(node);
}
void topologicalSort(int v){
    for(int i=1; i<=v; i++){
        if(!visited[i]){
            dfs(i);
        }
    }
    while(!st.empty()){
        cout<<st.top()<<" ";
        st.pop();
    }
    cout<<endl;
}
int main()
{
    int v,e,U,V;
    cin>>v>>e;
    while(e--){
        cin>>U>>V;
        graph[U].push_back(V);
    }
    topologicalSort(v);
    return 0;
}