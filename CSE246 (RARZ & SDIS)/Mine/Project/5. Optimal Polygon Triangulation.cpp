//CSE246(4) project,fall23,group_no:06
//Problem No-05
//tag: dp(Hard)

#include <bits/stdc++.h>
using namespace std;

// Function to calculate the distance between two points
double dist(pair<int, int> a, pair<int, int> b) {
    return sqrt(pow(a.first - b.first, 2) + pow(a.second - b.second, 2));
}

// Function to calculate the perimeter of a triangle formed by three points
double trianglePerimeter(pair<int, int> a, pair<int, int> b, pair<int, int> c) {
    return dist(a, b) + dist(b, c) + dist(c, a);
}

// Function to calculate the minimum cost of triangulation for a subpolygon
double cost(int i, int j, vector<pair<int, int>>& coordinates, vector<vector<double>>& dp) {
    if (j - i < 2) {
        return 0;
    }

    if (dp[i][j] != -1) {
        return dp[i][j];
    }

    double min_cost = 1e9;

    for (int k = i + 1; k < j; k++) {
        double triangle_cost = trianglePerimeter(coordinates[i], coordinates[k], coordinates[j]);
        double subpolygon_cost = cost(i, k, coordinates, dp) + cost(k, j, coordinates, dp);
        double total_cost = triangle_cost + subpolygon_cost;
        min_cost = min(min_cost, total_cost);
    }

    dp[i][j] = min_cost;
    return min_cost;
}



int main() {
    int N;
    cin >> N;
   // Function to find the optimal polygon triangulation

    vector<pair<int, int>> coordinates(N);
    for (int i = 0; i < N; i++) {
        cin >> coordinates[i].first >> coordinates[i].second;
    }
      vector<vector<double>> dp(N, vector<double>(N, -1));

    double min_cost =  cost(0, N - 1, coordinates, dp);

    cout << "Minimum Cost of Optimal Polygon Triangulation: " << min_cost << endl;

    return 0;
}

