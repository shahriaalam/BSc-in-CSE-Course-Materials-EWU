#include <stdio.h>
#include <stdlib.h>

// FCFS SJF RR algorithms!

//FCFS waiting time
void fcfs_WT(int processes[], int n, int bt[], int wt[])
{
    wt[0] = 0;
    for (int i = 1; i < n; i++)
        wt[i] = bt[i - 1] + wt[i - 1];
}

//FCFS avarage time
void fcfs_avgTime(int processes[], int n, int bt[])
{
    int wt[n], total_wt = 0;
    fcfs_WT(processes, n, bt, wt);
    printf("Processes   Burst time   Waiting time \n");

    for (int i = 0; i < n; i++)
    {
        total_wt = total_wt + wt[i];
        printf("   %d ", (i + 1));
        printf("        %d ", bt[i]);
        printf("             %d", wt[i]);
        printf("\n");
    }

    float s = (float)total_wt / (float)n;
    printf("\nAverage waiting time = %f\n", s);
    printf("\n");
}

//RR waiting time
void rrWT(int processes[], int n, int bt[], int wt[], int quantum)
{
    int left_bt[n];
    for (int i = 0; i < n; i++)
        left_bt[i] = bt[i];
    int t = 0;
    while (1)
    {
        int flag = 1;
        for (int i = 0; i < n; i++)
        {
            if (left_bt[i] > 0)
            {
                flag = 0;
                if (left_bt[i] > quantum)
                {
                    t += quantum;
                    left_bt[i] -= quantum;
                }
                else
                {
                    t = t + left_bt[i];
                    wt[i] = t - bt[i];
                    left_bt[i] = 0;
                }
            }
        }
        if (flag == 1)
            break;
    }
}

//RR average time
void rr_avgTime(int processes[], int n, int bt[])
{
    int quantum;
    printf("\nEnter time quantum: ");
    scanf("%d", &quantum);
    int wt[n], total_wt = 0;
    rrWT(processes, n, bt, wt, quantum);
    printf("Processes   Burst time   Waiting time \n");

    for (int i = 0; i < n; i++)
    {
        total_wt = total_wt + wt[i];
        printf("   %d ", (i + 1));
        printf("        %d ", bt[i]);
        printf("          %d", wt[i]);
        printf("\n");
    }

    float awt = (float)total_wt / (float)n;

    printf("\nAverage waiting time = %f\n", awt);
}

//SJF algorithm
void sjf(int n, int processes[], int bt[])
{
    int total = 0, p, temp, wt[n];
    float avg_wt;

    for (int i = 0; i < n; i++)
    {
        p = i;
        for (int j = i + 1; j < n; j++)
        {
            if (bt[j] < bt[p])
                p = j;
        }
        temp = bt[i];
        bt[i] = bt[p];
        bt[p] = temp;

        temp = processes[i];
        processes[i] = processes[p];
        processes[p] = temp;
    }

    wt[0] = 0;

    for (int i = 1; i < n; i++)
    {
        wt[i] = 0;
        for (int j = 0; j < i; j++)
            wt[i] += bt[j];
        total += wt[i];
    }

    avg_wt = (float)total / (float)n;

    total = 0;
    printf("\nProcess    Burst Time    Waiting Time");

    for (int i = 0; i < n; i++)
    {
        printf("\n%d            %d              %d ", i + 1, bt[i], wt[i]);
    }

    printf("\nAverage Waiting Time=%f\n", avg_wt);
}


int main()
{
    int choice;

    printf("=== CPU SCHEDULING ALGORITHM PROJECT ===\n");
    while (1)
    {
        printf("\nChoose an algorithm: \n\n");
        printf("1. FCFS\n");
        printf("2. SJF\n");
        printf("3. RR\n");
        printf("4. Exit\n\n");
        printf("Enter your input: ");
        scanf("%d", &choice);

        if(choice == 4) break;

        int n;
        printf("Enter Number of Processes: ");
        scanf("%d", &n);
        int pro[n], bur[n];
        for (int i = 0; i < n; i++)
        {
            pro[i] = i;
            printf("Burst time for process %d: ", i + 1);
            scanf("%d", &bur[i]);
        }

        switch (choice)
        {
        case 1:
            printf("\n CPU Scheduling in FCFS algorithm:\n\n ");
            fcfs_avgTime(pro, n, bur);
            break;
        case 2:
            printf("\n CPU Scheduling in SJF algorithm:\n\n ");
            sjf(n, pro, bur);
            break;
        case 3:
            printf("\n CPU Scheduling in RR algorithm:\n\n ");
            rr_avgTime(pro, n, bur);
            break;
        default:
            printf("\nWrong choice\n");
            break;
        }
    }

    return 0;
}
