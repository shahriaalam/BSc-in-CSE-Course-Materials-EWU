#include<stdio.h>
#include<pthread.h>
#include<semaphore.h>
sem_t x1;
sem_t x2;
sem_t x3;
sem_t x4;
sem_t sp;
int cnt=0,flag_value=0;

void initSemaphore(){

    sem_init(&x1,0,1);
    sem_init(&x2,0,0);
    sem_init(&x3,0,0);
    sem_init(&x4,0,0);
    sem_init(&sp,0,0);
}
void *n(void * arg){
    sem_wait(&x1);
    printf("%s",(char*)arg);
    cnt=1;
    sem_post(&sp);
}
void *n1(void * arg){
    sem_wait(&x2);
    printf("%s",(char*)arg);
    cnt=2;
    sem_post(&sp);
}
void *n2(void * arg){
    sem_wait(&x3);
    printf("%s",(char*)arg);
    sem_post(&x4);

}
void *n3(void * arg){
    sem_wait(&x4);
    printf("%s",(char*)arg);
    flag_value=1;
    sem_post(&sp);

}
void *spPrnt(void *arg){
    while(flag_value==0){
    sem_wait(&sp);
    if(flag_value==1){
        printf("\n");
        break;
    }
    printf("%s",(char*)arg);
    if(cnt==1){
        sem_post(&x2);
    }
    else if(cnt==2){
        sem_post(&x3);
    }

    }
}

int main()
{
    initSemaphore();
    char *mes1="Are";
    char *mes2="Roses";
    char *mes3="Red";
    char *mes4="?";
    char *mes5=" ";
    pthread_t thrd1,thrd2,thrd3,thrd4,thrd5;
    pthread_create(&thrd1, NULL,n , (void*)mes1);
    pthread_create(&thrd2, NULL,n1 , (void*)mes2);
    pthread_create(&thrd3, NULL,n2 , (void*)mes3);
    pthread_create(&thrd4, NULL,n3 , (void*)mes4);
    pthread_create(&thrd5, NULL,spPrnt , (void*)mes5);

    pthread_join(thrd1,NULL);
    pthread_join(thrd2,NULL);
    pthread_join(thrd3,NULL);
    pthread_join(thrd4,NULL);
    pthread_join(thrd5,NULL);
}

