#include <bits/stdc++.h>
using namespace std;


// Function to perform depth-first search
void dfs(int node, vector<int>& vis, vector<int>& store, vector<vector<int>>& adj) {
    vis[node] = 1;
    for(auto& i : adj[node]) {
        if(!vis[i]) {
            dfs(i, vis, store, adj);
        }
    }
    store.push_back(node);
}


int main() {
    int n, e;
    cin >> n >> e;


    // Create adjacency lists for the graph and its transpose
    vector<vector<int>> adj(n+1), tadj(n+1);


    // Read the edges
    for(int i = 0; i < e; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        tadj[v].push_back(u);  // Transpose of the graph
    }


    vector<int> vis(n+1, 0), order, SCC;


    // Perform DFS on the original graph to get the vertices in topological order
    for(int i = 1; i <= n; i++) {
        if(!vis[i]) {
            dfs(i, vis, order, adj);
        }
    }


    // Reset the visited array for the second DFS
    vis.assign(n+1, 0);


    // Perform DFS on the transposed graph in the order given by the first DFS
    reverse(order.begin(), order.end());
    int k=1;
    for(auto& node : order) {
        if(!vis[node]) {

            SCC.clear();
            dfs(node, vis, SCC, tadj);
             cout<<k<<" : ";
            for(auto& vertex : SCC) {

                cout << vertex << " ";
            }
            cout << "\n";
            k++;
        }


    }

    return 0;
}
