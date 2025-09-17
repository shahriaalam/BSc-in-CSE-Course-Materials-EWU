#include<stdio.h>

int g [100], h [100];

void print_gantt_chart(int p[], int n)
{
    int i, j;
    // print top bar
    printf(" ");
    for(i=0; i<n; i++) {
        for(j=0; j<g[i]; j++) printf("--");
        printf(" ");
    }
    printf("\n|");

    // printing process id in the middle
    for(i=0; i<n; i++) {
        for(j=0; j<g[i] - 1; j++) printf(" ");
        printf("P%d", i+1);
        for(j=0; j<g[i] - 1; j++) printf(" ");
        printf("|");
    }
    printf("\n ");
    // printing bottom bar
    for(i=0; i<n; i++) {
        for(j=0; j<g[i]; j++) printf("--");
        printf(" ");
    }
    printf("\n");

    // printing the time line
    printf("0");
    for(i=0; i<n; i++) {
        for(j=0; j<g[i]; j++) printf("  ");
        if(h[i] > 9) printf("\b"); // backspace : remove 1 space
        printf("%d", h[i]);

    }
    printf("\n");

}




void round_robin()
{

    int i, NOP, sum=0,count=0, y, quant, wt=0, h=0, at[10], g[10], temp[10];
    float avg_wt, avg_tat;
    printf(" Total number of process in the system: ");
    scanf("%d", &NOP);
    y = NOP;

for(i=0; i<NOP; i++)
{
printf("\n Enter the Arrival and Burst time of the Process[%d]\n", i+1);
printf(" Arrival time is: \t");
scanf("%d", &at[i]);
printf(" \nBurst time is: \t");
scanf("%d", &g[i]);
temp[i] = g[i];
}

printf("Enter the Time Quantum for the process: \t");
scanf("%d", &quant);


printf("\n Process No \t\t Burst Time \t\t TAT \t\t Waiting Time ");
for(sum=0, i = 0; y!=0; )
{
if(temp[i] <= quant && temp[i] > 0)
{
    sum = sum + temp[i];
    temp[i] = 0;
    count=1;
    }
    else if(temp[i] > 0)
    {
        temp[i] = temp[i] - quant;
        sum = sum + quant;
    }
    if(temp[i]==0 && count==1)
    {
        y--;
        printf("\nProcess No[%d] \t\t %d\t\t\t\t %d\t\t\t %d", i+1, g[i], sum-at[i], sum-at[i]-g[i]);
        wt = wt+sum-at[i]-g[i];
        h = h+sum-at[i];
        count =0;
    }
    if(i==NOP-1)
    {
        i=0;
    }
    else if(at[i+1]<=sum)
    {
        i++;
    }
    else
    {
        i=0;
    }
}

avg_wt = wt * 1.0/NOP;
avg_tat = h * 1.0/NOP;
printf("\n Average Turn Around Time: \t%f", avg_wt);
printf("\n Average Waiting Time: \t%f", avg_tat);

}




int main()
{
int n, wt[20], p[20], avwt=0, avtat=0,i,j;

	printf("Enter total number of process: ");
	scanf("%d",&n);

	printf("\nEnter process burst time\n");
for(i=0;i<n;i++)
{
	printf("p[%d]: ",i+1);
	scanf("%d",&g[i]);
	p[i]=i+1;
}

printf("\nSelect the Scheduling model:\n");
printf("1. FCFS\n2. SJF\n3. Round Robin\n");
int select;
scanf("%d",&select);

if(select==1)
{
	wt[0]=0;
	for(i=1;i<n;i++)
	{
		wt[i]=0;
		for(j=0;j<i;j++)
		{
			wt[i]+=g[j];
		}
	}

	printf("\nProcess\t\tBurst Time\tWaiting Time\tTurnaround Time");

	for(i=0;i<n;i++)
	{
		h[i]=g[i]+wt[i];
		avwt+=wt[i];
		avtat+=h[i];
	printf("\nP[%d]t\t%d\t\t%d\t\t%d",i+1,g[i],wt[i],h[i]);
	}

	avwt/=i;
	avtat/=i;
	printf("\n\nAverage waiting time: %d",avwt);
	printf("\nAverage Turnaround Time: %d\n",avtat);

}else if(select==2){

	for(i=0;i<n;i++)
	{
		int pos = i;
		for(j=i+1;j<n;j++)
		{
			if(g[j]<g[pos])
			pos=j;
		}
		int temp;
		temp=g[i];
		g[i]=g[pos];
		g[pos]=temp;

		temp=p[i];
		p[i]=p[pos];
		p[pos]=temp;
	}

	wt[0]=0;
	for(i=1;i<n;i++)
	{
		wt[i]=0;
		for(j=0;j<i;j++)
		{
			wt[i]+=g[j];
		}
	}

	printf("\nProcess\t\tBurst Time\tWaiting Time\tTurnaround Time");

	for(i=0;i<n;i++)
	{
		h[i]=g[i]+wt[i];
		avwt+=wt[i];
		avtat+=h[i];
	printf("\nP[%d]\t\t%d\t\t%d\t\t%d",p[i],g[i],wt[i],h[i]);
	}

	avwt/=i;
	avtat/=i;
	printf("\n\nAverage waiting time: %d",avwt);
	printf("\nAverage Turnaround Time: %d\n",avtat);

}else{
    round_robin();
}

print_gantt_chart(p, n);

return 0;

}
