#include <bits/stdc++.h>
using namespace std;

void printParenthesis(int i, int j, int n, int* s, char& name)
{
    if (i == j) {
        cout << name++;
        return;
    }
    cout << "(";
    printParenthesis(i, *((s + i * n) + j), n, s, name);
    printParenthesis(*((s + i * n) + j) + 1, j, n, s, name);
    cout << ")";
}

void matrixChainOrder(int p[], int n)
{
    int m[n][n];
    int s[n][n];

    for (int i = 1; i < n; i++)
        m[i][i] = 0;

    for (int L = 2; L < n; L++) {
        for (int i = 1; i < n - L + 1; i++) {
            int j = i + L - 1;
            m[i][j] = INT_MAX;
            for (int k = i; k <= j - 1; k++) {
                int q = m[i][k] + m[k + 1][j]
                        + p[i - 1] * p[k] * p[j];
                if (q < m[i][j]) {
                    m[i][j] = q;
                    s[i][j] = k;
                }
            }
        }
    }

    char name = 'A';
    cout << "The optimal parenthesization is : ";
    printParenthesis(1, n - 1, n, (int*)s, name);
    cout << "\nMinimum number of multiplications is : " << m[1][n - 1];
}

int main()
{
    int n;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++)cin>>arr[i];
    matrixChainOrder(arr, n);
    return 0;
}
