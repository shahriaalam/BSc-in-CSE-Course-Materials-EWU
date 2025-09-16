#include <stdio.h>
#include <stdlib.h>
struct Details
{
    float CGPA;
    char name[50];
    char id [14];
};
//void Check(struct Details *,int num,int k);

int main()
{
    struct Details *p;
    int i,num,x;
    int k=0;
    printf("How Many student are their in CSE207 Course in Summer 2020? :: ");
    scanf("%d",&num);
    p = (struct Details *)malloc(num * sizeof(struct Details));

    for (i = 0; i<num; i++)
    {
        printf("\nEnter The student [%d] name :: ",i+1);
        scanf("%s", &(p+i)->name);

        printf("Enter the Student [%d] Id :: ",i+1);
        scanf("%s", &(p+i)->id);

        printf("Enter the Student [%d] CGPA :: ",i+1);
        scanf("%f",&(p+i)->CGPA);
    }

    //Check(p, num,k);

    for (i = 0; i<num; i++)
    {
        if((p)->CGPA < (p+i)->CGPA)
            p->CGPA = (p+i)->CGPA;
        k=i;

    }
    printf("\n\n\t ::Who has obtained highest CGPA::");
    printf("\n\t\tName: %s", (p+k)->name);
    printf("\n\t\tStudent ID: %s", (p+k)->id);
    printf("\n\t\tCGPA: %f\n\n", p->CGPA);


}



/*void Check(struct Details *p,int num,int k)
{
    int i;
    for (i = 0; i<num; i++)
    {
        if((p)->CGPA < (p+i)->CGPA){
            p->CGPA = (p+i)->CGPA;

        }
k++;
    }


}
 */
