//Program to create one thread - the thread function will accept the one argument and return that argument from function to the main thread


#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<unistd.h>

void * getter_function(void * value) //void * means this variable can access any data type value in it.
{
	int no ;
	printf("The argument passed from the main thread is : %d\n", (int)value);
	printf("Enter the value to returns value to main thread : ");
	scanf("%d",&no);
	
	pthread_exit(no);
}

int main()
{
	int return_1 ;
	pthread_t  thread_1;
	int value = 0;
	printf("Enter the some value : ");
	scanf("%d",&value);
	
	int *return_value ; //variable in which i am going to collect the value return from the function 
	
	return_1 = pthread_create(&thread_1,NULL,getter_function,(void *)value); 
	if ( return_1 != 0)
	{
		printf("Error : Unable to create a thread \n");
	}
	
	pthread_join(thread_1,&return_value);
	
	printf("The value returns from the thread is : %d",return_value);
	
	exit(0);
}
