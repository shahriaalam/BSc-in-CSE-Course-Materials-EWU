#include<stdio.h>
#include<unistd.h>
int main(){
    pid_t n;
    int i;
    n = fork();

if(n > 0){

   printf("\n");

        for(i=1;i<=100;i++){
            if(i%2==0){
                printf("%d ",i);
            }
        }
    }
else{
    printf("\n");

        for(i=1;i<=100;i++){

            if(i%5==0){
                printf("%d ",i);
                }
            }
        }
  }
