#include <stdio.h>
#include <stdlib.h>
void menu(void);
struct node{
	int i;
	struct node *lc;
	struct node *rc;
}*root = NULL,*parent;


void insert(void){

	struct node *ptr;
	int item,f=0;
	printf("\nEnter item: ");
	scanf("%d",&item);
	if(root==NULL){
		root = (struct node*)malloc(sizeof(sizeof(struct node)));
		root->i=item;
		root->rc = NULL;
		root->lc = NULL;
	}
	else{
		ptr = root;
		while(ptr != NULL && f==0){
			if(ptr->i>item){
				parent = ptr;
				ptr = ptr->lc;
			}
			else if(ptr->i<item){
				parent = ptr;
				ptr = ptr->rc;
			}

			else
				f=1;
		}

		if(f==1){

			printf("\nDATA ALREADY EXISIT");
		}
		else{

			ptr = (struct node *)malloc(sizeof(struct node));
			ptr->i = item;
			ptr->rc = NULL;
			ptr->lc = NULL;
			if(parent->i<item)
				parent->rc = ptr;
			else
				parent->lc = ptr;
		}
	}
}



void preorder(struct node *ptr){
	if(ptr !=NULL){
		printf("%d ",ptr->i);
		preorder(ptr->lc);
		preorder(ptr->rc);
	}
}

void inorder(struct node *ptr){
	if(ptr !=NULL){
    inorder(ptr->lc);
	  printf("%d ",ptr->i);
    inorder(ptr->rc);
	}
}

void postorder(struct node *ptr){
	if(ptr !=NULL){
    postorder(ptr->lc);
    postorder(ptr->rc);
 	  printf("%d ",ptr->i);
	}
}

int succ(struct node *temp){
	temp = temp->rc;
	while(temp != NULL){
		if(temp->lc == NULL)
			return temp->i;
		temp = temp->lc;
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
