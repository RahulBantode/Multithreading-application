//Creating the thread and make the synchronization between those thread
//thread-1 is open the file and write some text in that file 
//thread-2 is open the file and read all the text from that file.

//for thread synchronization - we need to create pthread_mutex object which aquire lock on the thread means all the
//resources are lock in thread until the thread execution completes.

#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<unistd.h>
#include<fcntl.h>
#include<string.h>

pthread_mutex_t  lock ; //globally creaation of the thread lock.
int file_descriptor ;
char buffer[256];

void * Function_write()
{
	pthread_mutex_lock(&lock); //lock is acquire here
	char fname[20];
	printf("Enter the file-Name : ");
	scanf("%s",fname);
	file_descriptor = open(fname,O_RDWR,066);
	
	if(file_descriptor != 0)
	{
		printf("Enter the messege to write : ");
		scanf("%s",buffer);
		
		int size = write(file_descriptor,buffer,strlen(buffer));
		printf("The successfully written bytes into the file are : %d\n",size);
		strcpy(buffer," ");
	}
	else
	{
		printf("Unable to open the file\n");
	}
	
	pthread_mutex_unlock(&lock); //lock is release here
	
	pthread_exit(NULL);
}

void *Function_read()
{
	pthread_mutex_lock(&lock); //lock is acquire here
	char fname[20];
	printf("Enter the file-Name : ");
	scanf("%s",fname);
	file_descriptor = open(fname,O_RDWR,0666);
	
	if(file_descriptor != 0)
	{
		int size = read(file_descriptor,buffer,strlen(buffer));
		printf("The successfully read bytes from the file are : %d\n",size);
	}
	else
	{
		printf("Unable to open the file\n");
	}
	
	pthread_mutex_unlock(&lock); //lock is release here
	
	pthread_exit(NULL);
}

int main( )
{
	int return_1 , return_2;
	pthread_t thread_1,thread_2;
	
	
	if(pthread_mutex_init(&lock,NULL) != 0)
	{
		printf("Error :  The problem in mutext lock creation \n");
	}
	
	return_1 = pthread_create(&thread_1,NULL,Function_write,NULL);
	if(return_1 != 0)
	{
		printf("Error : Unable to create the thread \n");
	}
	
	return_2 = pthread_create(&thread_2,NULL,Function_read,NULL);
	if(return_2 != 0)
	{
		printf("Error : Unable to create the thread \n");
	}
	
	pthread_join(thread_1,NULL);
	pthread_join(thread_2,NULL);
	
	printf("Main thread is goin to terminate\n");
	
	exit(0);
}
