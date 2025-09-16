#include<bits/stdc++.h>
using namespace std;
#define INF INT_MAX
struct Edge {
    int u, v, weight;
};


vector<int> BellmanFord(int V, int src, vector<Edge>& edges) {
    vector<int> dist(V, INF);
    dist[src] = 0;
    for (int i = 0; i < V - 1; i++) {
        for (Edge& edge : edges) {
            int u = edge.u;
            int v = edge.v;
            int weight = edge.weight;
            if (dist[u] != INF && dist[u] + weight < dist[v]) {
                dist[v] = dist[u] + weight;
            }
        }
    }
    for (Edge& edge : edges) {
        int u = edge.u;
        int v = edge.v;
        int weight = edge.weight;
        if (dist[u] != INF && dist[u] + weight < dist[v]) {
            cout << "Negative cycle exists" << endl;
            exit(0);
        }
    }
    return dist;
}


void Dijkstra(int V, vector<pair<int, int>> adj[], int src, vector<int>& dist) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0, src});
    dist[src] = 0;
    while (!pq.empty()) {
        int u = pq.top().second;
        pq.pop();
        for (auto& i : adj[u]) {
            int v = i.first;
            int weight = i.second;
            if (dist[v] > dist[u] + weight) {
                dist[v] = dist[u] + weight;
                pq.push({dist[v], v});
            }
        }
    }
}


void Johnson(int V, vector<Edge>& edges) {
    vector<Edge> new_edges;
    for (int i = 0; i < V; i++) {
        new_edges.push_back({V, i, 0});
    }
    new_edges.insert(new_edges.end(), edges.begin(), edges.end());
    vector<int> p = BellmanFord(V + 1, V, new_edges);
    vector<pair<int, int>> adj[V];
    for (Edge& edge : edges) {
        adj[edge.u].push_back({edge.v, edge.weight + p[edge.u] - p[edge.v]});
    }
    for (int i = 0; i < V; i++) {
        vector<int> dist(V, INF);
        Dijkstra(V, adj, i, dist);
        for (int j = 0; j < V; j++) {
            if (dist[j] != INF) {
                dist[j] += p[j] - p[i];
            }
        }
        for (int j = 0; j < V; j++) {
            if (dist[j] != INF) {
                cout << i <<" " << j << " "<<  dist[j] << endl;
            }
        }
    }
}


int main() {
    int V,E;
    cin>>V>>E;
    vector<Edge> edges(E);
    for (int i = 0; i < E; i++) {
        cin >> edges[i].u >> edges[i].v >> edges[i].weight;
    }
    Johnson(V, edges);
    return 0;
}
