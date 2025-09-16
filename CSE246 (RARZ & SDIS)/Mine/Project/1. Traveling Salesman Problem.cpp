#include <bits/stdc++.h>
using namespace std;
#define MAX 100
#define INF 1e9

int n, e, graph[MAX][MAX], path[MAX];
bool visited[MAX];
// Function to find the minimum cost using backtracking


void tsp(int curr_pos, int count, int cost, int& ans) {
       // Reached all cities, update the minimum cost and path


    if (count == n && graph[curr_pos][0]) {
        ans = min(ans, cost + graph[curr_pos][0]);
        return;
    }
    for (int i = 0; i < n; i++) {
        if (!visited[i] && graph[curr_pos][i]) {
            visited[i] = true;
            path[count] = i;
            tsp(i, count + 1, cost + graph[curr_pos][i], ans);
            visited[i] = false;
        }
    }
}


int main() {
    cin >> n >> e;
    memset(graph, INF, sizeof(graph));
    memset(visited, false, sizeof(visited));
        // Input the roads and their costs
    for (int i = 0; i < e; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        graph[u][v] = w;
        graph[v][u] = w;
    }
    visited[0] = true;
    path[0] = 0;
    int ans = INF;
    tsp(0, 1, 0, ans);
    cout << "Minimum cost: " << ans << endl;
    cout << "Path: ";
    for (int i = 0; i < n; i++) {
        cout << path[i] << " ";
    }
    cout << path[0] << " ";
    cout << endl;
    return 0;
}
