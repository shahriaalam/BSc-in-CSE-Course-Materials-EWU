//CSE246(4) project,fall23,group_no:06
//Problem:  Project: Graph Coloring Problem
//tag: Backtracking/Graph(Easy)


#include<bits/stdc++.h>
using namespace std;

bool isSafe(int node, vector<int>& color, vector<vector<int>>& adj, int n, int col) {
    for (int k = 0; k < n; k++) {
        if (k != node && adj[k][node] == 1 && color[k] == col) {
            return false;
        }
    }
    return true;
}

bool solve(int node, vector<int>& color, int m, int N, vector<vector<int>>& adj) {
    if (node == N) {
        return true;
    }
    for (int i = 0; i < m; i++) {
        if (isSafe(node, color, adj, N, i)) {
            color[node] = i;
            if (solve(node + 1, color, m, N, adj)) return true;
            color[node] = -1;
        }
    }
    return false;
}

int main() {
    int N, E, m;
    cin >> N >> E >> m;

    vector<vector<int>> adj(N + 1, vector<int>(N + 1, 0));
    for (int i = 0; i < E; i++) {
        int u, v;
        cin >> u >> v;
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

    vector<int> color(N + 1, -1);

    if (solve(0, color, m, N, adj)) {
        cout << "YES" << endl;
    } else {
        cout << "NO" << endl;
    }

    return 0;
}
