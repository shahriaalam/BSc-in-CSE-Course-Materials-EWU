#include <bits/stdc++.h>
using namespace std;
const int N = 100007;

vector<int> graph[N];
vector<int> cycles[N];
int color[N];
int par[N];
int mark[N];
int flag = 0;

void dfs_cycle(int u, int p, int &cyclenumber)
{
    if (color[u] == 2)
    {
        return;
    }

    if (color[u] == 1)
    {
        cyclenumber++;
        int cur = p;
        mark[cur] = cyclenumber;

        while (cur != u)
        {
            cur = par[cur];
            mark[cur] = cyclenumber;
        }
        return;
    }

    par[u] = p;
    color[u] = 1;

    for (int v : graph[u])
    {
        if (v == par[u])
        {
            continue;
        }
        dfs_cycle(v, u, cyclenumber);
    }

    color[u] = 2;
}

void printCycles(int edges, int &cyclenumber)
{
    for (int i = 1; i <= edges; i++)
    {
        if (mark[i] != 0)
        {
            cycles[mark[i]].push_back(i);
        }         
    }

    for (int i = 1; i <= cyclenumber; i++)
    {
        cout << "YES" << endl;
        flag = 1;
        for (int x : cycles[i])
        {
            cout << x << " ";
        }
        cout << endl;
    }
}

int main()
{
    int vertices, edges;
    cin >> vertices >> edges;

    for (int i = 0; i < edges; i++)
    {
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    int cyclenumber = 0;

    dfs_cycle(1, 0, cyclenumber);
    printCycles(edges, cyclenumber);

    if(!flag)
    {
        cout<<"NO"<<endl;
    }
}
