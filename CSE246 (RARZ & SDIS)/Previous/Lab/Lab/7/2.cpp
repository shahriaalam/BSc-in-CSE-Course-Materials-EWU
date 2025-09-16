//Maximal Connected Component in an Undirected Graph
#include <bits/stdc++.h>
using namespace std;
vector<int> graph[1000000];
int visited[1000000];
vector<int> storing;
int cDFS = 0;

void dfs(int key){
    cDFS++;
    visited[key] = 1;
    for (int i = 0; i < graph[key].size(); i++){
        int next = graph[key][i];
        if (visited[next] == 0){
            dfs(next);
        }
    }
}

int main()
{
    int vertices, edges;
    cin >> vertices >> edges;

    for (int i = 0; i < edges; i++){
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    int maxValue = 0;
    for (int i = 1; i <= vertices; i++){ //bfs for every node
        for (int j = 1; j <= vertices; j++){
            visited[j] = 0;
        }   
        for (int k = 1; k <= edges; k++){
            cDFS = 0;
            if (visited[k] == 0){
                visited[k] = 1;
                dfs(k);
                maxValue = max(maxValue, cDFS);
            }
        }
    }
    cout << maxValue << endl;
    return 0;
}