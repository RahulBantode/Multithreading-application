/* Make Synchronization between the Threads 
   why need to create synchronization between the threads :-
   if our threads are going to access same resources which are global to all the thread.
   or our all the threads are going to access this resources at same time, then it may create conflict
   that to whom thread resource are allocated. for that purpose we need to create synchronization between the
   threads.
   In java to create thread synchronization :-
   1. the data which are globally accessible to all make it synchronize or make method as synchronize
      by creating the method as synchronize then if one thread is access the resource then it will lock for that thread only
  
	
	In our problem statment we declare on class DataAcess whose data are accessible for all the three threads
	so when which thread will scheduled we dont know so when which thread will accesss the data of that class
	we dont know so create one synchronized method in it.this method will lock the resources for the current
	thread until it completes it execution.
  */

class DataAccess
{
	synchronized public void Display(int value)
	{
		for(int i=1; i < 5; i++)
			System.out.println( i*value );
		
		try
		{
			Thread.sleep(400);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

class custom_thread_1 implements Runnable
{
	DataAccess t;
	custom_thread_1(DataAccess t)
	{
		this.t = t;
	}

	public void run()
	{
		t.Display(4);
	}
}

class custom_thread_2 implements Runnable
{
	DataAccess t;
	custom_thread_2(DataAccess t)
	{
		this.t = t;
	}

	public void run()
	{
		t.Display(30);
	}
}


class custom_thread_3 implements Runnable
{
	DataAccess t;
	custom_thread_3(DataAccess t)
	{
		this.t = t;
	}

	public void run()
	{	
		t.Display(100);
	}
}

class ThreadSynchronization
{
	public static void main(String [] args)
	{
		DataAccess da = new DataAccess();
		Thread t1 = new Thread(new custom_thread_1(da));
		Thread t2 = new Thread(new custom_thread_2(da));
		Thread t3 = new Thread(new custom_thread_3(da));		

		t1.start();
		t2.start();
		t3.start();

		//if(t1.isAlive() && t2.isAlive() && t3.isAlive()) this checking for thread is alive or not
		//By the help of following code the main thread will wait for all the thread to complete their execution
		//if we are not declare it in try catch block then it will give an exception as unreporetedexception.
		try
		{
			t1.join();
			t2.join();
			t3.join();
		}
		catch(Exception e)
		{
			System.out.println("Exception occurs : "+e);
		}

		System.out.println("End of the main thread\n");
	}
}