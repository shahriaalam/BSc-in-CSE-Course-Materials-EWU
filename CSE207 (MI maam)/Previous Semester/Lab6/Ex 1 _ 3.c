#include <stdio.h>
#include <stdlib.h>
void menu(void);
struct node{
	int i;
	struct node *left;
	struct node *right;
}*root = NULL,*parent;


void insert(void){

	struct node *ptr;
	int item,f=0;
	printf("\nEnter item: ");
	scanf("%d",&item);
	if(root==NULL){
		root = (struct node*)malloc(sizeof(sizeof(struct node)));
		root->i=item;
		root->right = NULL;
		root->left = NULL;
	}
	else{
		ptr = root;
		while(ptr != NULL && f==0){
			if(ptr->i>item){
				parent = ptr;
				ptr = ptr->left;
			}
			else if(ptr->i<item){
				parent = ptr;
				ptr = ptr->right;
			}

			else
				f=1;
		}

		if(f==1){

			printf("\ntry again");
		}
		else{

			ptr = (struct node *)malloc(sizeof(struct node));
			ptr->i = item;
			ptr->right = NULL;
			ptr->left = NULL;
			if(parent->i<item)
				parent->right = ptr;
			else
				parent->left = ptr;
		}
	}
}



void preorder(struct node *ptr){
	if(ptr !=NULL){
		printf("%d ",ptr->i);
		preorder(ptr->left);
		preorder(ptr->right);
	}
}

void inorder(struct node *ptr){
	if(ptr !=NULL){
    inorder(ptr->left);
	  printf("%d ",ptr->i);
    inorder(ptr->right);
	}
}

void postorder(struct node *ptr){
	if(ptr !=NULL){
    postorder(ptr->left);
    postorder(ptr->right);
 	  printf("%d ",ptr->i);
	}
}

int succ(struct node *temp){
	temp = temp->right;
	while(temp != NULL){
		if(temp->left == NULL)
			return temp->i;
		temp = temp->left;
	}
}



void menu(void){
     int n,i;
     printf("\n1 for Insert\n2 for Preorder\n3 for Inorder\n4 for Postorder\n7 for Exit");
     printf("\nEnter Choice: ");
     scanf("%d",&n);
     switch(n){
                case 1:
                     insert();
                     menu();
                break;
	            case 2:
                	preorder(root);
                	printf("\n");
                	menu();
           		break;
           		case 3:
               		inorder(root);
                	printf("\n");
                	menu();
           		break;
           		case 4:
                	postorder(root);
                	printf("\n");
                	menu();
                case 5:
                     return ;
                break;
                default:
                        printf("\nInvalid Option");
                        menu();
                }
  }
int main(){
    menu();

    }
