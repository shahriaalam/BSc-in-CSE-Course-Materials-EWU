#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

int num1, num2, result;
pthread_mutex_t mutex;

void* input_thread(void* arg) {
    printf("Enter two numbers: ");
    scanf("%d %d", &num1, &num2);
    return NULL;
}

void* choice_thread(void* arg) {
    int choice;
    printf("Press 1 for subtraction or 2 for multiplication: ");
    scanf("%d", &choice);

    pthread_mutex_lock(&mutex);
    if (choice == 1) {
        result = num1 - num2;
    } else if (choice == 2) {
        result = num1 * num2;
    } else {
        printf("Invalid choice.\n");
    }
    pthread_mutex_unlock(&mutex);

    return NULL;
}

void* display_thread(void* arg) {
    pthread_mutex_lock(&mutex);
    printf("Result: %d\n", result);
    pthread_mutex_unlock(&mutex);

    return NULL;
}

int main() {
    pthread_t input_tid, choice_tid, display_tid;
    pthread_mutex_init(&mutex, NULL);

    pthread_create(&input_tid, NULL, input_thread, NULL);
    pthread_create(&choice_tid, NULL, choice_thread, NULL);
    pthread_create(&display_tid, NULL, display_thread, NULL);

    pid_t child_pid = fork();

    if (child_pid == 0) {
        // Child process
        pthread_join(input_tid, NULL);
        pthread_join(choice_tid, NULL);
        pthread_join(display_tid, NULL);
    } else {
        // Parent process
        wait(NULL);
        printf("All of my operations have been performed successfully!\n");
    }

    pthread_mutex_destroy(&mutex);

    return 0;
}
