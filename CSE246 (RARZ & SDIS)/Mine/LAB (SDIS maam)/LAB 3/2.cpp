#include<bits/stdc++.h>
using namespace std;
#define d 26
#define q 101

void search( string pattern,  string text) {
    int M = pattern.length();
    int N = text.length();
    int p = 0;
    int t = 0;
    int h = 1;

    for (int i = 0; i < M - 1; i++)
        h = (h * d) ;




    for (int i = 0; i < M; i++) {
        p = (d * p + pattern[i]) %q;
        t = (d * t + text[i]) %q ;
    }


    for (int i = 0; i <= N - M; i++) {

        if (p == t) {
            int j;

            for (j = 0; j < M; j++) {
                if (text[i + j] != pattern[j])
                    break;
            }

            if (j == M) {
                cout << i << " " << i + M - 1 << endl;
            }
        }

        if (i < N - M) {
            t = (d * (t - text[i] * h) + text[i + M]) % q;


            if (t < 0)
                t = t + q;
        }
    }
}

int main()
{


    string T, P;
    cin >> T >> P;
    search(P, T);

    return 0;

}
