#include<bits/stdc++.h>
using namespace std;


void dfs(int u, int p, vector<int>& disc, vector<int>& low, vector<int>& ap, vector<array<int, 2>>& br, vector<vector<int>>& adj, int& Time) {
    int children = 0;
    low[u] = disc[u] = ++Time;
    for (auto v : adj[u]) {
        if (v == p) continue;
        if (!disc[v]) {
            children++;
            dfs(v, u, disc, low, ap, br, adj, Time);
            if(disc[u] < low[v]) br.push_back({u, v});
            if (disc[u] <= low[v]) ap[u] = 1;
            low[u] = min(low[u], low[v]);
        }
        else low[u] = min(low[u], disc[v]);
    }
    if(p == u && children > 1) ap[u] = 1;
}


int main() {
    int n, e;
    cin >> n >> e;
    vector<vector<int>> adj(n+1);
    for(int i = 1; i <= e; i++) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    vector<int> disc(n+1, 0), ap(n+1, 0), low(n+1, INT_MAX);
    vector<array<int, 2>> br;
    int Time = 0;
    for (int u = 1; u <= n; u++)
        if (!disc[u])
            dfs(u, u, disc, low, ap, br, adj, Time);
    cout << accumulate(ap.begin(), ap.end(), 0ll) << "\n";
    cout << br.size() << "\n";
    return 0;
}
