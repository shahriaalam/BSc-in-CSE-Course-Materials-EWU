#include <bits/stdc++.h>
using namespace std;
vector<int> graph[100000];
int pre[100000];
int dis[100000];

void edge(int s, int d)
{
    graph[s].push_back(d);
    graph[d].push_back(s);
}

bool BFS(int s, int d, int v)
{
    list<int> queue;
    bool visit[v];
    for (int i=0; i<v; i++)
    {
        visit[i] = false;
        dis[i] = INT_MAX;
        pre[i] = -1;
    }

    visit[s] = true;
    dis[s] = 0;
    queue.push_back(s);
    while (!queue.empty())
    {
        int u = queue.front();
        queue.pop_front();
        for (int i = 0; i < graph[u].size(); i++)
        {
            if (visit[graph[u][i]] == false)
            {
                visit[graph[u][i]] = true;
                dis[graph[u][i]] = dis[u] + 1;
                pre[graph[u][i]] = u;
                queue.push_back(graph[u][i]);
                if (graph[u][i] == d)
                    return true;
            }
        }
    }
    return false;
}

void shortestPath(int s, int d, int v)
{
    if(BFS(s, d, v)==false)
    {
        cout<<"No path";
        return;
    }
    vector<int> path;
    int temp2 = d;
    path.push_back(temp2);
    while(pre[temp2] != -1)
    {
        path.push_back(pre[temp2]);
        temp2 = pre[temp2];
    }
    cout<<dis[d];
}


int main()
{
    int v,e,x,y,s,d;
    cin>>v>>e;
    v+=1;
    while(e--)
    {
        cin>>x>>y;
        edge(x,y);
    }
    cin>>s>>d;
    shortestPath(s,d,v);
    cout<<endl;
    return 0;
}

