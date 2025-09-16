#include <stdio.h>
#include <string.h>

void Palindrome(char [], int);

int main()
{
    char P[25];
    printf("Input for palindrome :");
   scanf("%s", P);
    Palindrome(P, 0);

}

void Palindrome(char P[], int i)
{
    int len = strlen(P) - (i + 1);
    if (P[i] == P[len])
    {
        if (i + 1 == len || i == len)
        {
            printf(" Its palindrome.\n");
            return;
        }
        Palindrome(P, i + 1);
    }
    else
    {
        printf(" It's not a palindrome.\n");
    }
}
