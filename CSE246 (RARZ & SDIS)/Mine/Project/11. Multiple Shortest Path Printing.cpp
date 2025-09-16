#include<bits/stdc++.h>
using namespace std;
#define MAX 100005
#define INF 1e9
vector<pair<int,int>> adj[MAX];
int n,m,s,t;
int dist[MAX],cnt[MAX];
bool vis[MAX];
vector<int> path[MAX];
void dijkstra(){
    priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
    pq.push({0,s});
    dist[s]=0;
    cnt[s]=1;
    while(!pq.empty()){
        int u=pq.top().second;
        pq.pop();
        if(vis[u]) continue;
        vis[u]=true;
        for(auto v:adj[u]){
            if(dist[v.first]>dist[u]+v.second){
                dist[v.first]=dist[u]+v.second;
                cnt[v.first]=cnt[u];
                pq.push({dist[v.first],v.first});
                path[v.first].clear();
                path[v.first].push_back(u);
            }
            else if(dist[v.first]==dist[u]+v.second){
                cnt[v.first]+=cnt[u];
                path[v.first].push_back(u);
            }
        }
    }
}
int main(){
    cin>>n>>m;
    for(int i=1;i<=m;i++){
        int u,v,w;
        cin>>u>>v>>w;
        adj[u].push_back({v,w});
    }
    cin>>s>>t;
    memset(dist,0x3f,sizeof(dist));
    dijkstra();
    // Output the minimum distance
    cout<<"The minimum distance between "<<s<<" and "<<t<<" is "<<dist[t]<<endl;
    // Output the number of shortest paths
    cout<<"The number of shortest paths between "<<s<<" and "<<t<<" is "<<cnt[t]<<endl;
    // Output the intermediate nodes
    cout<<"The intermediate nodes to reach "<<t<<" from "<<s<<" are: ";
    queue<vector<int>> q;
    q.push({t});
    while(!q.empty()){
        vector<int> cur=q.front();
        q.pop();
        int last=cur[0];
        if(last==s){
            for(int i=cur.size()-1;i>=0;i--){
                cout<<cur[i]<<" ";
            }
            cout<<endl;
        }
        else{
            for(auto i:path[last]){
                vector<int> tmp=cur;
                tmp.insert(tmp.begin(),i);
                q.push(tmp);
            }
        }
    }
    return 0;
}


