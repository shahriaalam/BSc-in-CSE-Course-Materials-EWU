#include <bits/stdc++.h>
using namespace std;
int graph[10000][10000];          // adjacency list representation
vector<vector<int>> store_clique; // vector to store clique
int degree[100000];
int keep[100000];
int v, e;
int cnt = 0;

void clique(int start, int value, int clique_size) // clique checking function
{
    int limit = v - (clique_size - value); // find minimum number of nodes for
                                           //which we need to check clique
    for (int i = start+1; i <= limit; i++)
    {
        if (degree[i] >= clique_size - 1)// checking degree size
        {
            keep[value] = i;
            bool connected_node = true;

            for (int j = 1; j < value + 1; j++)
            {
                for (int k = j + 1; k < value + 1; k++)
                {
                    if (graph[keep[j]][keep[k]] == 0)// checking if its a click
                    {
                        connected_node = false;
                        break;
                    }
                }
            }

            if (connected_node)// if number of nodes is greater than or equal clique_size
            {
                if (value < clique_size)
                {
                    int xy = value + 1;
                    clique(i, xy, clique_size);
                }
                else
                {
                    vector<int> tmp; // a temporary vector to store cliques
                    cnt++;
                    for (int l = 1; l < value + 1; l++)
                    {
                        tmp.push_back(keep[l]);
                    }
                    store_clique.push_back(tmp);
                    tmp.clear();
                }
            }
        }
    }
}

int main()
{
    cin >> v >> e;
    int k;
    for (int start = 0; start < e; start++)
    {
        int x, y;
        cin >> x >> y;
        degree[x]++;
        degree[y]++;
        graph[x][y] = 1;
        graph[y][x] = 1;
    }
    cin >> k;

    clique(0, 1, k);
 /*   // corner case
    if (v == 3 && e != 3)
    {
        cout << 0 << endl;
    }
    else
    {
        clique(0, 1, k);
        cout << cnt << endl;
    }
*/
    if(cnt!=0)
    for (int start = 0; start < cnt; start++) // printing cliques
    {
        for (int i = 0; i < store_clique[start].size(); i++)
        {
            cout << store_clique[start][i] << " ";
        }
        cout << endl;
    }
    else cout<<cnt<<endl;
}
