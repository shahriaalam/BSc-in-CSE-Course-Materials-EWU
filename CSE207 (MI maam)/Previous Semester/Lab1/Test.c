/*
#include <stdio.h>
#include <stdlib.h>
struct course {
    int marks;
    char subject[30];
}*ptr;

int main() {
    //struct course *ptr;
    int i, noOfRecords;
    printf("Enter the number of records: ");
    scanf("%d", &noOfRecords);

    // Memory allocation for noOfRecords structures
    ptr = (struct course *)malloc(noOfRecords * sizeof(struct course));
    for (i = 0; i < noOfRecords; ++i) {
        printf("Enter the name of the subject and marks respectively:\n");
        scanf("%s %d", &(ptr + i).subject, &(ptr + i)->marks);
    }

    printf("Displaying Information:\n");
    for (i = 0; i < noOfRecords; ++i)
        printf("%s\t%d\n", (ptr + i)->subject, (ptr + i)->marks);

    return 0;
}//*/
/*#include <stdio.h>
struct person
{
   int age;
   float weight;
}p;

int main()
{
    struct person *personPtr, person1;
    personPtr = &person1;

    printf("Enter age: ");
    scanf("%d", &p.age);

    printf("Enter weight: ");
    scanf("%f", &personPtr->weight);

    printf("Displaying:\n");
    printf("Age: %d\n", personPtr->age);
    printf("weight: %f", personPtr->weight);

    return 0;
}*/
#include <stdio.h>

// student structure
struct student {
  char id[15];
  char firstname[64];
  char lastname[64];
  float points;
};

// function declaration
void getDetail(struct student *);
void displayDetail(struct student *);

int main(void) {

  // student structure variable
  //struct student std[3];

  // get student detail
  getDetail(std);

  // display student detail
  displayDetail(std);

  return 0;
}

// function definition


void getDetail(struct student *ptr) {

  int i;

  for (i = 0; i < 3; i++) {
    printf("Enter detail of student #%d\n", (i + 1));
    printf("Enter ID: ");
    scanf("%s", ptr->id);
    printf("Enter first name: ");
    scanf("%s", ptr->firstname);
    printf("Enter last name: ");
    scanf("%s", ptr->lastname);
    printf("Enter Points: ");
    scanf("%f", &ptr->points);

    // update pointer to point at next element
    // of the array std
    ptr++;
  }

}

void displayDetail(struct student *ptr) {

  int i;

  for (i = 0; i < 3; i++) {
    printf("\nDetail of student #%d\n", (i + 1));

    // display result via ptr variable
    printf("\nResult via ptr\n");
    printf("ID: %s\n", ptr->id);
    printf("First Name: %s\n", ptr->firstname);
    printf("Last Name: %s\n", ptr->lastname);
    printf("Points: %f\n", ptr->points);

    // update pointer to point at next element
    // of the array std
    ptr++;
  }

}
