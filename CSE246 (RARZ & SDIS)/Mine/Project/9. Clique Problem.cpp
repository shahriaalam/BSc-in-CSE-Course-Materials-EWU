#include<bits/stdc++.h>
using namespace std;


void extend(vector<vector<int>>& cliques, vector<int>& R, vector<int>& P, vector<int>& X, const vector<vector<int>>& graph, int size) {
    if (P.empty() && X.empty() && R.size() == size) {
        cliques.push_back(R);
        return;
    }
    while (!P.empty()) {
        int v = P.back();
        P.pop_back();
        R.push_back(v);
        vector<int> P_new, X_new;
        for (int u : P)
            if (graph[v][u])
                P_new.push_back(u);
        for (int u : X)
            if (graph[v][u])
                X_new.push_back(u);
        extend(cliques, R, P_new, X_new, graph, size);
        R.pop_back();
        X.push_back(v);
    }
}


int main() {
    int N, E, K;
    cin >> N >> E;
    vector<vector<int>> graph(N, vector<int>(N, 0));
    for (int i = 0; i < E; i++) {
        int u, v;
        cin >> u >> v;
        graph[u][v] = graph[v][u] = 1;
    }
    cin >> K;
    vector<vector<int>> cliques;
    vector<int> R, P(N), X;
    for (int i = 0; i < N; i++)
        P[i] = i;
    extend(cliques, R, P, X, graph, K);
    for (auto& clique : cliques) {
        sort(clique.begin(), clique.end());
        for (int v : clique)
            cout << v << ' ';
        cout << '\n';
    }
    return 0;
}
