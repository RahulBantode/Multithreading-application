/*Program to create two thread under the main thread.
	1. 1st thread will count the even number from 1 to 500.
	2. 2nd thread will count the odd number from 1 to 500.
	
*/

#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<unistd.h>

void *Even_Display()
{
	int no = 500;
	
	for (int i=1; i <= no; i++)
	{
		if ( i % 2 == 0)
		{
			printf("Even number : %d\n",i);
		}
	}
	
	pthread_exit(NULL);
}

void *Odd_Display()
{
	int no = 500;
	
	for (int i=1; i <= no; i++)
	{
		if ( i % 2 != 0)
		{
			printf("Odd number : %d\n",i);
		}
	}
	
	pthread_exit(NULL);  //it a return status that thread object complete it execution.
}

int main( )
{
	int return_1 = 0, return_2 = 0;
	
	pthread_t thread_1,thread_2; //object creation of thread
	
	return_1 = pthread_create(&thread_1,  // thread - address of thread object where it is located
						NULL,       // attri - is the thread attribute object specifying the attibute for thread otherwise NULL
						Even_Display, // start - function (callback fun) from where the thread object start its execution
						NULL); // args - its argument pass to the thread fucntion
	if ( return_1 != 0)
	{
		printf("Error :  Unable to create thread \n");
	}
	
	return_2 = pthread_create(&thread_2,NULL,Odd_Display,NULL);
	if ( return_2 != 0)
	{
		printf("Error :  Unable to create thread \n");
	}
	
	//main thread is wait for the all threads execution completion
	pthread_join(thread_1,  //first argument is the thread object address to join when it comes
				NULL);  //second argument is if the thread function returns some value to main thread then it will collected here.
	pthread_join(thread_2,NULL);
	
	exit(0);
}
