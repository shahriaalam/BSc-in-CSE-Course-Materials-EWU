#include<bits/stdc++.h>
#include<vector>
using namespace std;
vector<int> graph[100000];
int main() {
    int v,e;
    cin >> v;
    cin >> e;
    vector<int>color;
    bool visit[100000];
    int x,y,i;

    memset(visit, 0, sizeof(visit));

    for(int i=0; i<e; i++) {
        cin >> x;
        cin >> y;
        graph[x].push_back(y);
        graph[y].push_back(x);
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
