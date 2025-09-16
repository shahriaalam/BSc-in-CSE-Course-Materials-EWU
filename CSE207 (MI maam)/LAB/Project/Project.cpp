#include<bits/stdc++.h>
using namespace std;
#include <stdlib.h>
#include <conio.h>
#include<math.h>

struct data
{
    int key;
    int value;
};

struct hashtable
{
    int flag;
    struct data *item;
};

struct hashtable *arr;
int maxx,prime;
int size = 0;

int hashfunction1(int key)
{
    return (key%maxx);
}

int hashfunction2(int key)
{
    return (prime-(key%prime));
}

void insert()
{
    int key,value;
    cout<<"Inserting element in Hash Table"<<endl;
    cout<<"Enter key: ";
    cin>>key;
    cout<<"Enter value: ";
    cin>>value;
    cout<<endl;

    int hash1=hashfunction1(key);
    int hash2=hashfunction2(key);
    int index=hash1;

    struct data *newitem=(struct data*) malloc(sizeof(struct data));
    newitem->key=key;
    newitem->value=value;

    if (size==maxx)
    {
        cout<<"\nHash Table is full, cannot insert more items."<<endl;
        cout<<"\n\t\tEnter any key to go to menu"<<endl;
        getch();
        system("cls");
        return;
    }

    while(arr[index].flag==1)
    {
        if(arr[index].item->key==key)
        {
            cout<<"\nKey already present. To update the value press '1'. If not then press '0'."<<endl;
            cout<<"Enter choice: ";
            int u ;
            cin>>u;
            system("cls");
            if(u==1)
            {
                arr[index].item->value=value;
                return;
            }
            else if(u==0)
            {
                return;
            }
        }
        index=(index+hash2)%maxx;
    }
    arr[index].item=newitem;
    arr[index].flag=1;
    size++;
    cout<<"\nKey "<<key<<" has been inserted."<<endl;
    cout<<"\n\t\tEnter any key to go to menu"<<endl;
    getch();
    system("cls");
}

void Delete(int key)
{
    int hash1=hashfunction1(key);
    int hash2=hashfunction2(key);
    int index=hash1;

    if(size==0)
    {
        cout<<"\nHash Table is empty."<<endl;
        return;
    }
    while(arr[index].flag!=0)
    {
        if(arr[index].flag==1  &&  arr[index].item->key==key)
        {
            arr[index].item=NULL;
            arr[index].flag=0;
            size--;
            cout<<"\nKey "<<key<<" has been removed."<<endl;
            return;
        }
        index=(index+hash2)%maxx;
    }
    cout<<"\nKey "<<key<<" does not exist."<<endl;
}

void search(int key)
{
    int hash1=hashfunction1(key);
    int hash2=hashfunction2(key);
    int index=hash1;

    if (size==0)
    {
        cout<<"\nHash Table is empty."<<endl;
        return;
    }
    while(arr[index].flag!=0)
    {
        if(arr[index].item->key==key)
        {
            cout<<"\nArray "<<index<<" has elements"<<endl;
            cout<<"Key "<<arr[index].item->key<<" and Value "<<arr[index].item->value<<endl;
            return;
        }
        index=(index+hash2)%maxx;

        if(index==hash1) break;
    }
    cout<<"\nKey "<<key<<" does not exist."<<endl;
}

int hashtable_size()
{
    return size;
}

void display()
{
    for (int i=0; i<maxx; i++)
    {
        if (arr[i].flag!=1)
        {
            cout<<"Array "<<i<<" has no elements."<<endl;
        }
        else
        {
            cout<<"*Array "<<i<<" has elements."<<endl;
            cout<<" Key "<<arr[i].item->key<< " and Value "<<arr[i].item->value<<endl;
        }
        cout<<endl;
    }
    cout<<"\n\t\tEnter any key to go to menu"<<endl;
    getch();
    system("cls");
}

int get_prime()
{
    for(int i=maxx-1;i>=1;i--)
    {
        int flag=0;
        for(int j=2;j<=(int)sqrt(i);j++)
        {
            if(i%j==0) flag++;
        }
        if(flag==0) return i;
    }
}

void set_array()
{
    for(int i=0; i<maxx; i++)
    {
        arr[i].item = NULL;
        arr[i].flag = 0;
    }
    prime = get_prime();
}





int main()
{
    int z,key,value,n,c,x;

    cout<<"Enter size of Array (It should be more than or equal 3): ";
    cin>>x;
    maxx=x;
    system("cls");
    arr=(struct hashtable*) malloc(maxx* sizeof(struct hashtable));
    set_array();

    while(1)
    {
        cout<<"\n\n#### Double hash tables ####"<<endl;
        cout<<"__________  Menu  __________"<<endl;
        cout<<"\n1. Inserting item in the Hash Table"
            "\n2. Delete item from the Hash Table"
            "\n3. Check the size of Hash Table"
            "\n4. Display Hash Table"
            "\n5. Search key in Hash Table"
            "\n6. Exit"<<endl;
        cout<<"Enter your choice: ";
        cin>>z;
        system("cls");
        switch(z)
        {
        case 1:
            insert();
            break;

        case 2:
            cout<<"***** Deleting in Hash Table *****"<<endl;
            cout<<"Enter the key to delete : ";
            cin>>key;
            Delete(key);

            cout<<"\n\t\tEnter any key to go to menu"<<endl;
            getch();
            system("cls");
            break;

        case 3:
            n=hashtable_size();
            cout<<"Size of Hash Table is: "<<n<<endl;

            cout<<"\n\t\tEnter any key to go to menu"<<endl;
            getch();
            system("cls");
            break;

        case 4:
            display();
            break;

        case 5:
            cout<<"***** Searching in Hash Table *****"<<endl;
            cout<<"Enter the key to search: ";
            cin>>key;
            search(key);

            cout<<"\n\t\tEnter any key to go to menu"<<endl;
            getch();
            system("cls");
            break;

        case 6 :
            exit(0);

        default:
            cout<<"Wrong Input\n"<<endl;
        }
    }
    return 0 ;
}
