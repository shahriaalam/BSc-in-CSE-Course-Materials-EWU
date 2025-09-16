
#include <stdio.h>
#include <stdio.h>
#include <windows.h>

int q[20], top = -1, front = -1, rear = -1, a[20][20], vis[20], stack[20];
int dequeue();
void enqueue(int item);
void bfs(int s, int n);
void dfs(int s, int n);
void push(int item);
int pop();
int isCyclicUtil(int v, int n, int parent);
int isCyclic(int n);

int main() {
    int n, i, s, ch, j;
    char c, dummy;
    printf("ENTER THE NUMBER VERTICES ");
    scanf("%d", & n);

    FILE *fileptr;
    fileptr = fopen("adjmat2.csv", "r");
    for (i = 1; i <= n; i++) {
        for (j = 1; j <= n; j++) {
            char ch = fgetc(fileptr);
            if(ch != ',' && ch !='\n')
                a[i][j] = ch-48;
        }
    }

    printf("THE ADJACENCY MATRIX IS\n");
    for (i = 1; i <= n; i++) {
        for (j = 1; j <= n; j++) {
            printf("%d ", a[i][j]);
        }
        printf("\n");
    }

    do {
        for (i = 1; i <= n; i++)
            vis[i] = 0;
        printf("\nMENU");
        printf("\n1. B.F.S");
        printf("\n2. D.F.S");
        printf("\n3. Check Cycle");
        printf("\nENTER YOUR CHOICE: ");
        scanf("%d", & ch);

        switch (ch) {
        case 1:
            printf("\nENTER THE SOURCE VERTEX :");
            scanf("%d", & s);
            printf("\nBFS\n");
            bfs(s, n);
            break;
        case 2:
            printf("\nENTER THE SOURCE VERTEX :");
            scanf("%d", & s);
            printf("\nDFS\n");
            dfs(s, n);
            break;
        case 3:
            if(isCyclic(n) == 1)
                printf("This Graph has a cycle");
            else
                printf("This graph doesn't have a cycle");
            break;
        }
        printf("\n\nDO U WANT TO CONTINUE(Y/N)? ");
        scanf("%c", & dummy);
        scanf("%c", & c);
    } while ((c == 'y') || (c == 'Y'));

    return 0;
}

//**************BFS(breadth-first search) code**************//
void bfs(int s, int n) {
    int p, i;
    enqueue(s);
    vis[s] = 1;
    p = dequeue();
    if (p != 0)
        printf("%d ", p);
    while (p != 0) {
        for (i = 1; i <= n; i++)
            if ((a[p][i] != 0) && (vis[i] == 0)) {
                enqueue(i);
                vis[i] = 1;
            }
        p = dequeue();
        if (p != 0)
            printf("%d ", p);
    }
    for (i = 1; i <= n; i++)
        if (vis[i] == 0)
            bfs(i, n);
}

void enqueue(int item) {
    if (rear == 19)
        printf("QUEUE FULL");
    else {
        if (rear == -1) {
            q[++rear] = item;
            front++;
        } else
            q[++rear] = item;
    }
}








int dequeue() {
    int k;
    if ((front > rear) || (front == -1))
        return (0);
    else {
        k = q[front++];
        return (k);
    }
}

//***************DFS(depth-first search) code******************//
void dfs(int s, int n) {
    int i, k;
    push(s);
    vis[s] = 1;
    k = pop();
    if (k != 0)
        printf("%d ", k);
    while (k != 0) {
        for (i = 1; i <= n; i++)
            if ((a[k][i] != 0) && (vis[i] == 0)) {
                push(i);
                vis[i] = 1;
            }
        k = pop();
        if (k != 0)
            printf("%d ", k);
    }
    for (i = 1; i <= n; i++)
        if (vis[i] == 0)
            dfs(i, n);
}

void push(int item) {
    if (top == 19)
        printf("Stack overflow ");
    else
        stack[++top] = item;
}

int pop() {
    int k;
    if (top == -1)
        return (0);
    else {
        k = stack[top--];
        return (k);
    }
}


int isCyclicUtil(int v, int n, int parent)
{
    // Mark the current node as visited
    vis[v] = 1;

    // Recur for all the vertices adjacent to this vertex
    for (int i = 1; i <=n; ++i)
    {
        // If an adjacent is not visited, then recur for that adjacent
        if(a[v][i] == 0)
            continue;
        if (a[v][i] != 0 && vis[i] == 0)
        {
           if (isCyclicUtil(i, n, v))
              return 1;
        }

        // If an adjacent is visited and not parent of current vertex,
        // then there is a cycle.
        else if (i != parent)
           return 1;
    }
    return 0;
}

// Returns true if the graph contains a cycle, else false.
int isCyclic(int n)
{
    // Mark all the vertices as not visited and not part of recursion
    // stack
    for (int i = 1; i <= n; i++)
        vis[i] = 0;

    // Call the recursive helper function to detect cycle in different
    // DFS trees
    for (int u = 1; u <= n; u++)
        if (vis[u] == 0) // Don't recur for u if it is already visited
          if (isCyclicUtil(u, n, -1))
             return 1;

    return 0;
}
