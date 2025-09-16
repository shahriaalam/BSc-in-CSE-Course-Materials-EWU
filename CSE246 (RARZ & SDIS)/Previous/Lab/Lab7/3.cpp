#include <bits/stdc++.h>
using namespace std;

vector<int> graph[1000000];
int visited[1000000];
vector<int> storing;

void dfs(int key)
{
    visited[key] = 1;

    vector<int> current = graph[key];

    sort(current.begin(), current.end(), greater<int>());

    for (int i = 0; i < current.size(); i++)
    {
        int next = current[i];
        if (visited[next] == 0)
        {
            dfs(next);
        }
    }
    storing.push_back(key);
}

int main()
{
    int vertices, edges;
    cin >> vertices >> edges;
    
    for (int i = 0; i < edges; i++)
    {
        int u, vertices;
        cin >> u >> vertices;
        graph[u].push_back(vertices);
    }

    for (int i = vertices; i >= 1; i--)
    {
        if (visited[i] == 0)
        {
            dfs(i);
        }
    }

    reverse(storing.begin(), storing.end());

    for (int i = 0; i < storing.size(); i++)
    {
        cout << storing[i] << endl;
    }

    return 0;
}
