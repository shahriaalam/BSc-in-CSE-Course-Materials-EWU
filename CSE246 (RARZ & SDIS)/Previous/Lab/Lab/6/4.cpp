//Multiple shortest path existence
#include<bits/stdc++.h>
using namespace std;
const int N = 1e5 + 9;
vector<int>graph[N],dis,vis;
int n, m, s;
int main()
{
    cin >> n >> m;
    for(int i=1,a,b; i<=n; i++){
        cin >> a >> b;
        graph[a].push_back(b);
        graph[b].push_back(a);
    }
    dis = vector<int>(n+1,1e9);
    vis = vector<int>(n+1);
    cin >> s;
    dis[s] = 0;

    queue<int> q;
    q.push(s);
    vis[s] = 1;
    while(!q.empty()){
        int now = q.front();
        q.pop();
        for(auto x : graph[now]){
            if(vis[x]){
                if(dis[now] + 1 == dis[x]){
                    cout<<"YES"<<endl;
                    exit(0);
                }
            }
            else{
                vis[x] = 1;
                dis[x] = dis[now] + 1;
                q.push(x);
            }
        }
    }
    cout<<"NO"<<endl;
}
