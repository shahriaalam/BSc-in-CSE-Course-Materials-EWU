#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int top = -1;
char stack[100];

void push(char a)
{
    stack[top] = a;
    top++;
}


void pop()
{
    if (top == -1)
    {
        printf("\nClosing parentheses not matched.\n");
        exit(0);
    }
    else
    {
        top--;
    }
}

void FTop()
{
    if (top == -1)
        printf("\n Valid\n");
    else
        printf("\nOpening parentheses not end.\n");
}

void main()
{
    int i;
    char a[100];
    printf("enter any expression: ");
    scanf("%s", &a);
    for (i = 0; a[i] != '\0'; i++)
    {
        if (a[i] == '(')
        {
            push(a[i]);
        }
        else if (a[i] == ')')
        {
            pop();
        }
    }
    FTop();
}

