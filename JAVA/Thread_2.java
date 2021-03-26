/*
Problem statment :-
Create three thread name as even odd multiplier
And start the execution of threads.

*/
import java.util.*;

class Even extends Thread
{
	int no = 0;
	Even(int value)
	{
		no = value;
	}

	public void run()
	{
		for(int i = 1; i <= no; i++)
			if(i % 2 == 0)
				System.out.println("Even Number : "+i);
	}
}

class Odd extends Thread
{
	int no = 0;
	Odd(int value)
	{
		no = value;
	}

	public void run()
	{
		for(int i = 1; i <= no; i++)
			if(i % 2 != 0)
				System.out.println("Odd Number : "+i);
	}
}

class Multiplier extends Thread
{
	int no = 0;
	Multiplier(int value)
	{
		no = value;
	}

	public void run()
	{
		for(int i =1; i <= no; i++)
			System.out.println("Multiplication :"+no*i);
	}
}


class Thread_2
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int para = 0;
		
		System.out.print("Enter the value : ");
		para = sc.nextInt();

		Even et = new Even(para);
		Odd  ot= new Odd(para);
		Multiplier mt = new Multiplier(para);

		et.start();
		ot.start();
		mt.start();

	}
}