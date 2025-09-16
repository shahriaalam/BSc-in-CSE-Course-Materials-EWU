#include<bits/stdc++.h>
#include<vector>
using namespace std;

int main() {
    int v,e;
    cin >> v;
    cin >> e;

    vector<vector<int>>graph;
    vector<int>color;

    bool visit[100000];
    int x,y,i;

    graph.resize(e);
    color.resize(e , -1);
    memset(visit, 0, sizeof(visit));

    for(int i=0; i<e; i++) {
        graph[i].resize(e);
    }

    for(int i=0; i<e; i++) {
        cin >> x;
        cin >> y;
        x--;
        y--;
        graph[x][y]=1;
        graph[y][x]=1;
    }

    bool res;
    color[0]=1;
    queue <int> q;
    q.push(0);
    while (!q.empty()) {
        int temp=q.front();
        q.pop();
        for (i=0; i<e; i++) {
            if (graph[temp][i] && color[i] == -1) {
                color[i]=1-color[temp];
                q.push(i);
                res=true;
            }
            else if (graph[temp][i] && color[i]==color[temp]) res=false;
        }
    }

    if(res) {
        cout<<"YES"<<endl;
    }
    else {
        cout<<"NO"<<endl;
    }

    return 0;
}
