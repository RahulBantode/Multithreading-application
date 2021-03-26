//The program has basic demonstration of creation of thread.
//activeCount() - The method will return the count of active thread running in the program
//void run() - The abstract method of Thread class which we can modify it here. in which we are writing the
               //logic 
//start() - this method will start the execution of thread
//stop() - this method will stop the execution of thread
//sleep(long millis,int nanos) - this wiill sleep the thread till provided argument time
//currentThread() - this will return the name of current Thread.
import java.util.*;

class MyThread extends Thread
{
	int value_1,value_2;
	MyThread(int no1,int no2)
	{
		value_1 = no1;
		value_2 = no2;
	}

	public void run()
	{
		if(value_1 < value_2)
			System.out.println("Value second is greater : " + value_2);
		else
			System.out.println("Value first is greater : " + value_1);
	}
}

class Thread_1
{
	public static void main(String [] args)
	{
		MyThread t1 = new MyThread(5,6);
		t1.start(); //this is the method of Thread class which start the thread execution.

		System.out.println("The active thread running in program : "+t1.activeCount());
		//this method will return the active thread running in the program.
		//activeCount will return 2 - means one thread is which are we created and one is the main thread
		//every program has one thread running which known as main thread.

		System.out.println("The priority of thread : "+t1.getPriority());

		System.out.println("The main thread completes the execution");	
	}
}