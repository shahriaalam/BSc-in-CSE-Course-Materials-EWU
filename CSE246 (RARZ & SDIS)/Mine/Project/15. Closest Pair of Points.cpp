#include<bits/stdc++.h>
using namespace std;
#define MAX 100005
#define INF 1e9
vector<pair<int,int>> points;
int n;


struct Compare {
    bool operator()(pair<int,int> a, pair<int,int> b) {
        return a.second < b.second;
    }
};
float dist(pair<int,int> p1, pair<int,int> p2) {
    return sqrt((p1.first - p2.first)*(p1.first - p2.first) + (p1.second - p2.second)*(p1.second - p2.second));
}
float min_dp (int l, int r) {
    float min_dist = FLT_MAX;
    for (int i = l; i <= r; ++i)
        for (int j = i+1; j <= r; ++j)
            min_dist = min(min_dist, dist(points[i], points[j]));
    return min_dist;
}
float closestUtil (int l, int r) {
    if (r-l+1 <= 3)
        return min_dp(l, r);
    int mid = (l+r)/2;
    float dl = closestUtil(l, mid);
    float dr = closestUtil(mid+1, r);
    float d = min(dl, dr);
    vector<pair<int,int>> strip;
    for (int i = l; i <= r; ++i){
        if (abs(points[i].first - points[mid].first) < d)
           strip.push_back(points[i]);
    }
    //sort(strip.begin(), strip.end(),  { return a.second < b.second;});
    sort(strip.begin(), strip.end(), Compare());
    float min_strip = d;
    for (int i = 0; i < strip.size(); ++i)
        for (int j = i+1; j < strip.size() && (strip[j].second - strip[i].second) < min_strip; ++j)
            min_strip = min(min_strip, dist(strip[i], strip[j]));
    return min(d, min_strip);
}
float closestPair () {
    sort(points.begin(), points.end());
    return closestUtil(0, n-1);
}
int main(){
    cin>>n;
    for(int i=0;i<n;i++){
        int x,y;
        cin>>x>>y;
        points.push_back({x,y});
    }
    cout<<"The smallest distance found between any pair of points in the given array is "<<closestPair()<<endl;
    return 0;
}
