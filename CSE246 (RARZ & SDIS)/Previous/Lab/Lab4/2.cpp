#include <bits/stdc++.h>
using namespace std;

int coinCount[10007];
int coins[31];

void fun(int n, int k)
{

    int temp1[n + 1];
    temp1[0] = 0;
    int temp2[n + 1];
    temp2[0] = 0;

    for (int j = 1; j <= n; j++)
    {
        int min = INT_MAX;
        int coin = 0;

        for (int i = 1; i <= k; i++)
        {
            if (j >= coins[i])
            {
                if ((1 + temp1[j - coins[i]]) < min)
                {
                    min = 1 + temp1[j - coins[i]];
                    coin = i;
                }
            }
        }
        temp1[j] = min;
        temp2[j] = coin;
    }

    int l = n;
    while (l > 0)
    {
        coinCount[coins[temp2[l]]]++;

        l = l - coins[temp2[l]];
    }

    for (int i = 1; i <= 10000; i++)
    {
        if (coinCount[i] > 0)
        {
            cout << i << " " << coinCount[i] << endl;
        }
    }
}

int main()
{
    int n, k;
    cin >> n >> k;

    for (int i = 1; i <= n; i++)
    {
        cin >> coins[i];
    }

    fun(k, n);
    
    return 0;
}