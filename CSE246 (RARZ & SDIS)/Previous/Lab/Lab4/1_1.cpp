#include <bits/stdc++.h>
using namespace std;
int memory[31][100];

int min_coins(int arr[], int i, int k, int n)
{
    
    if (i > n || k == 0)
    {
        return 0;
    }
    int res = INT16_MAX;
    if (memory[i][k] != -1)
    {
        return memory[i][k];
    }
    if (arr[i] <= k)
    {
        int res1, res2;
        res1 = 1 + min_coins(arr, i, k - arr[i], n);
        res2 = min_coins(arr, i + 1, k, n);
        res = min(res1, res2);
        memory[i][k] = res;
        return res;
    }
    return -1;
}

int main()
{
    // while (1)
    {
        for (int i = 0; i < 31; i++)
        {
            for (int j = 0; j < 100; j++)
            {
                memory[i][j] = -1;
            }
            
        }

        int n, k;
        cin >> n >> k;
        int arr[n];
        for (int i = 0; i < n; i++)
        {
            cin >> arr[i];
        }
        int res = min_coins(arr, 0, k, n);
        cout << res << endl;
        // for (int i = 0; i < 50; i++)
        // {
        //     cout << used[i].coin << " " << used[i].times << endl;
        // }
    }
}