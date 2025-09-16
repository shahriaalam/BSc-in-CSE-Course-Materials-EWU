#include <bits/stdc++.h>
using namespace std;

bool hamiltonianCycle(vector<vector<int>>& adj, vector<bool> visited, vector<int>& path, int v,int V)
{
    if (path.size() == V)
        return true;
    for (auto adjnode : adj[v])
    {   //check adjnodes are already visited or not
        if (visited[adjnode] == 0)
        {
            visited[adjnode] = 1;
            path.push_back(adjnode);
            //recursive call
            if (hamiltonianCycle(adj, visited, path, adjnode,V))
                return true;
            //backtrack
            visited[adjnode] = 0;
            path.pop_back();
        }
    }
    return false;
}


int main()
{
    int V,E;
    cin>>V>>E;
    vector<vector<int>> adj(V+1,vector<int>(V+1,0));
    //adj list
    for(int i=0;i<E;i++){
        int u,v;cin>>u>>v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    vector<bool> visited(V+1, 0);
    vector<int> path;
    path.push_back(0);
    visited[0] = 1;

    if (hamiltonianCycle(adj, visited, path, 0,V))
    {
        int last = path.back();
        vector<int>& v = adj[path[0]];
        // check if first and last vertex are connected
        if (find(v.begin(), v.end(), last) == v.end())
            cout << "NO" << endl;
        else
        {    cout<<"YES"<<endl;
             cout << "Hamiltonian Cycle: ";

            for (int i : path)
                cout << i << "  ";
            cout << path[0] << endl;
        }
    }
    else
        cout << "NO" << endl;
    return 0;
}
