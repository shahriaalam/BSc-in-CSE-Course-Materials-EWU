#include<stdio.h>
#include<pthread.h>
#include<semaphore.h>
#include<stdlib.h>
sem_t sem1;
sem_t sem2;
sem_t sem3;
sem_t kill;
pthread_mutex_t lock1;
pthread_mutex_t lock2;
int reach=0;

void initSemaphore(int pat)
{

    sem_init(&sem1,0,pat);
    sem_init(&sem2,0,1);
    sem_init(&sem3,0,0);
    sem_init(&kill,0,0);
    pthread_mutex_init(&lock1,0);
    pthread_mutex_init(&lock2,0);
}
int p=0,count=0,ch=0,id,x=1;
void *Patient(void * arg)
{
    sem_wait(&sem1);

    int id = (int *)arg;

    pthread_mutex_lock(&lock2);
    //int id = x;
    //x++;
    if(count>ch){
        printf("No empty chairs. Patient %d leaving\n",id);
        pthread_mutex_unlock(&lock2);
        pthread_exit(id);
    }
    if(count!=0){
    printf("Patient %d is in waiting\n",id);
    }
    count++;

    pthread_mutex_unlock(&lock2);

    sem_wait(&sem2);
    //sleep(1);

    printf("Patient %d wakes up doctor.\n",id);
    p=id;
    sem_post(&sem3);
    sem_wait(&kill);
    printf("Patient %d Terminates.\n",id);
}
void *Doctor(void *arg)
{
    while(1)
    {

        sem_wait(&sem3);
        if(reach)
        {
            printf("All done\n");
            break;
        }
        //sleep(1);
        printf("Doctor giving treatment to patient %d\n",p);
        sleep(1);
        printf("Patient %d leaving\n",p);
        sem_post(&kill);
        sem_post(&sem2);

    }

}
int main()
{

    pthread_t doctor,*patientId;
    int patient,chair;
    printf("Enter number of patients: ");
    scanf("%d",&patient);
    printf("Enter number of chairs: ");
    scanf("%d",&chair);
    ch=chair;
    int i;

    initSemaphore(patient);


    patientId=(pthread_t*) malloc(sizeof(pthread_t) * patient);

    pthread_create(&doctor,NULL,Doctor,NULL);

    for(int i =0; i<patient; i++)
    {
        pthread_create(&patientId[i],NULL,Patient,(void*)i+1);
    }
    for(int i =0; i<patient; i++)
    {
        pthread_join(patientId[i],NULL);

    }
    reach=1;
    sem_post(&sem3);
    pthread_join(doctor,NULL);
}
