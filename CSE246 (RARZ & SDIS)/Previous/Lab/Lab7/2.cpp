#include <bits/stdc++.h>
using namespace std;

vector<int> graph[1000000];
int visited[1000000];
vector<int> storing;
int count1 = 0;

void dfs(int key)
{
    count1++;
    visited[key] = 1;
    for (int i = 0; i < graph[key].size(); i++)
    {
        int next = graph[key][i];
        if (visited[next] == 0)
        {
            dfs(next);
        }
    }
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

        graph[vertices].push_back(u);
    }

    int count = 0;
    int maxValue = 0;

    for (int k = 1; k <= edges; k++)
    {
        for (int h = 1; h <= edges; h++)
        {
            visited[h] = 0;
        }
        
        for (int i = 1; i <= edges; i++)
        {
            count1 = 0;
            if (visited[i] == 0)
            {
                visited[i] = 1;
                dfs(i);
                count++;
                maxValue = max(maxValue, count1);
            }
        }
    }
    cout << maxValue << endl;
    return 0;
}