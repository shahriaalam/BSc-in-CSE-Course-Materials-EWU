#include<bits/stdc++.h>
using namespace std;
vector<vector<int>> dp(1000+1, vector<int>(1000+1, 0));
pair<string, string> sequence_alignment(string X, string Y, int p_gap, int p_xy) {
    int m = X.size();
    int n = Y.size();
   // Initialize the first row and column of the matrix
    for(int i=0; i<=m; i++) {
        for(int j=0; j<=n; j++) {
            if(i == 0) dp[i][j] = j * p_gap;
            else if(j == 0) dp[i][j] = i * p_gap;
            else if(X[i-1] == Y[j-1]) dp[i][j] = dp[i-1][j-1];
            else dp[i][j] = min({dp[i-1][j-1] + p_xy, dp[i-1][j] + p_gap, dp[i][j-1] + p_gap});
        }
    }
    // Backtrack through the matrix to find the aligned strings
    string align_X = "", align_Y = "";
    int i = m, j = n;
    while(i > 0 && j > 0) {
        if(X[i-1] == Y[j-1]) {
            align_X = X[i-1] + align_X;
            align_Y = Y[j-1] + align_Y;
            i--; j--;
        } else if(dp[i][j] == dp[i-1][j-1] + p_xy) {
            align_X = X[i-1] + align_X;
            align_Y = Y[j-1] + align_Y;
            i--; j--;
        } else if(dp[i][j] == dp[i-1][j] + p_gap) {
            align_X = X[i-1] + align_X;
            align_Y = "_" + align_Y;
            i--;
        } else {
            align_X = "_" + align_X;
            align_Y = Y[j-1] + align_Y;
            j--;
        }
    }
    while(i > 0) {
        align_X = X[i-1] + align_X;
        align_Y = "_" + align_Y;
        i--;
    }
    while(j > 0) {
        align_X = "_" + align_X;
        align_Y = Y[j-1] + align_Y;
        j--;
    }
    return {align_X, align_Y};
}

int main() {
    string X,Y ;
    cin>>X>>Y;
    int p_gap, p_xy;
    cin>>p_gap>>p_xy;
    pair<string, string> result = sequence_alignment(X, Y, p_gap, p_xy);
       // Output the result
    cout << "Minimum penalty aligning two problem is: " << dp[X.size()][Y.size()] << endl;
    cout << "Aligned as: " << endl;
    cout << result.first << endl;
    cout << result.second << endl;
    return 0;
}
