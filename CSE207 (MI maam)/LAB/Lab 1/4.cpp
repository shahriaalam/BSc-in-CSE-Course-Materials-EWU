#include <iostream>
#include<stdlib.h>
#include <cstdio>
using namespace std;

struct student
{
    char name[100];
    char id[100];
    float cgpa;
};



int main()
{
    struct student *p;
    int n;
    cout<<"Input total student number:\n";
    cin>>n;
    cout<< "Enter information of the students one by one:\n\n";
    p = (struct student *)malloc(n * sizeof(struct student));

    for(int i=0; i<n; i++)
    {
        cout<< "Student "<< i+1<<":"<<endl;
        cout<<"Name:\n";
        cin>>(p+i)->name;
        cout<<"ID:\n";
        cin>>(p+i)->id;
        cout<<"CGPA:\n";
        cin>>(p+i)->cgpa;
        cout<<"\n";
    }

    int k=0;
    for (int i=0; i<n; i++)
    {
        if((p)->cgpa < (p+i)->cgpa)
            {
                p->cgpa = (p+i)->cgpa;
                k=i;
            }
    }

    cout<<"\nWho has obtained highest CGPA:"<<endl;
    cout<<"Name: "<<(p+k)->name<<endl;
    cout<<"ID: "<<(p+k)->id<<endl;
    cout<<"CGPA: "<<(p+k)->cgpa<<endl;
    return 0;
}
