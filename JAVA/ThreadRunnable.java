/*Implementing th thread using Runnable interface.

*/
import java.util.*;

class MyThread_1 implements Runnable
{
	Thread t;
	public void run()
	{
		System.out.println(t.currentThread());
		for(int i =100; i>=0; i--)
			System.out.println(i);
	}
}


class MyThread_2 implements Runnable
{
	Thread t;
	public void run()
	{
		System.out.println(t.currentThread());
		for(int i =1; i<=100; i++)
			System.out.println(i);
	}
}

class ThreadRunnable
{
	public static void main(String [] args)
	{	
		Thread t1 = new Thread(new MyThread_1());
		Thread t2 = new Thread(new MyThread_2());

		t1.start();
		t2.start();
	}
}