#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    int keys[n], freq[n];
    for (int i = 0; i < n; i++) {
        cin >> keys[i];
    }
    for (int i = 0; i < n; i++) {
        cin >> freq[i];
    }
    int dp[n][n];
    memset(dp, 0, sizeof(dp));
    for (int i = 0; i < n; i++) {
        dp[i][i] = freq[i];
    }
    for (int len = 2; len <= n; len++) {
        for (int i = 0; i <= n - len; i++) {
            int j = i + len - 1;
            dp[i][j] = INT_MAX;
            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum += freq[k];
            }
            for (int k = i; k <= j; k++) {
                int val = sum + (k > i ? dp[i][k - 1] : 0) + (k < j ? dp[k + 1][j] : 0);
                dp[i][j] = min(dp[i][j], val);
            }
        }
    }
    cout << dp[0][n - 1] << endl;
    return 0;
}

