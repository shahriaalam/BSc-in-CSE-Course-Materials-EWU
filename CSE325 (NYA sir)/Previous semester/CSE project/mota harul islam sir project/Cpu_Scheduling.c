//FCFS SJF RR non-preemptive algorithms!


void fcfs_WT(int processes[], int n,int bt[], int wt[]){
    wt[0]=0;
    for (int  i=1; i<n; i++ )
        wt[i]=bt[i-1]+wt[i-1];
}

void fcfs_avgTime( int processes[], int n, int bt[]){
    int wt[n],total_wt =0;
    fcfs_WT(processes, n, bt, wt);
    printf("Processes   Burst time   Waiting time \n");
    for (int  i=0; i<n; i++)
    {
        total_wt = total_wt + wt[i];
        printf("   %d ",(i+1));
        printf("        %d ", bt[i] );
        printf("             %d",wt[i] );
        printf("\n");
    }
    float s=(float)total_wt /(float)n;
    printf("\nAverage waiting time = %f\n",s);
    printf("\n");
}


void rrWT(int processes[], int n,int bt[], int wt[], int quantum){
    int left_bt[n];
    for (int i=0; i<n; i++)
        left_bt[i]=bt[i];
    int t=0;
    while (1)
    {
        int flag = 1;
        for (int i = 0 ; i < n; i++)
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
                    t=t+left_bt[i];
                    wt[i]=t-bt[i];
                    left_bt[i] = 0;
                }
            }
        }
        if (flag==1)
            break;
    }
}

void rr_avgTime(int processes[], int n, int bt[]){
    int quantum;
    printf("\nEnter time quantum: ");
    scanf("%d",&quantum);
    int wt[n], total_wt = 0;
    rrWT(processes, n, bt, wt, quantum);
    printf("Processes   Burst time   Waiting time \n");
    for (int  i=0; i<n; i++)
    {
        total_wt = total_wt + wt[i];
        printf("   %d ",(i+1));
        printf("        %d ", bt[i] );
        printf("          %d",wt[i] );
        printf("\n");
    }
    float awt=(float)total_wt / (float)n;
    printf("\nAverage waiting time = %f\n",awt);
}


void sjf(int n,int processes[],int bt[])
{
    int total=0,p,temp,wt[n];
    float avg_wt;
    for(int i=0; i<n; i++)
    {
        p=i;
        for(int j=i+1; j<n; j++)
        {
            if(bt[j]<bt[p])
                p=j;
        }
        temp=bt[i];
        bt[i]=bt[p];
        bt[p]=temp;

        temp=processes[i];
        processes[i]=processes[p];
        processes[p]=temp;
    }
    wt[0]=0;
    for(int i=1; i<n; i++)
    {
        wt[i]=0;
        for(int j=0; j<i; j++)
            wt[i]+=bt[j];
        total+=wt[i];
    }
    avg_wt=(float)total/(float)n;
    total=0;
    printf("\nProcess    Burst Time    Waiting Time");
    for(int i=0; i<n; i++)
    {
        printf("\n%d            %d              %d ",i+1,bt[i],wt[i]);
    }
    printf("\nAverage Waiting Time=%f\n",avg_wt);
}


#include<stdio.h>
int main(){
    int choice;

    while(1){
        int n;
        printf("Enter Number of Processes: ");
        scanf("%d",&n);
        int pro[n],bur[n];
        for(int i=0; i<n; i++){
            pro[i]=i;
            printf("Burst time for process %d: ",i+1);
            scanf("%d",&bur[i]);
        }
        printf("\nChoose an algorithm: \n");
        printf("1.FCFS\n");
        printf("2.SJF\n");
        printf("3.RR\n");
        printf("Press 4 to exit\n");
        scanf("%d",&choice);

        switch(choice){
        case 1:
            printf("\nCPU Scheduling in FCFS algorithm:\n ");
            fcfs_avgTime(pro,n,bur);
            break;
        case 2:
            printf("\nCPU Scheduling in SJF algorithm:\n ");
            sjf(n,pro,bur);
            break;
        case 3:
            printf("\nCPU Scheduling in RR algorithm:\n ");
            rr_avgTime(pro,n,bur);
            break;
        case 4:
            exit(1);
        default:
            printf("\nWrong choice\n");
            break;
        }
    }

    return 0;
}
