//Tree Diameter for an Undirected tree graph
#include<bits/stdc++.h>
using namespace std;
vector <int> graph[1000005];
bool visited[1000005];
int distances[1000005];
vector <int> vectorSource;
int mx = -1, node;
void dfs(int source,int dis){
    vectorSource.push_back(source);
    visited[source] = 1;
    distances[source] = dis;
    if(distances[source] > mx){
        mx = distances[source];
        node = source;
    }

    for(int i = 0; i < graph[source].size(); i++){
        int next = graph[source][i];
        if(visited[next] == 0){
            dfs(next, distances[source]+1);
        }
    }
}

int main()
{
    int nodes, edges;
    cin >> nodes >> edges;
    for (int i = 0; i < edges; i++){
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    dfs(1,0);
    for(int i=1;i<=nodes;i++){
        visited[i]=0;
    }
    dfs(node,0);

    cout<<mx<<endl;
    return 0;
}
