package com.himanshu.jointhread;

import com.himanshu.threadbeans.JoinThread;

public class JoinThreadDemo {
	public static void main(String[] args) {
		JoinThread thread1 = new JoinThread();
		thread1.setName("Thread-1");
		JoinThread thread2 = new JoinThread();
		thread2.setName("Thread-2");
		System.out.println("Starting threads");
		thread1.start();
		thread2.start();
		try {
			//Thread.currentThread().join();	//This will create deadlock, as this thread waits on the same thread only
			thread1.join();		//This join happens sequentially, so once we are done with thread1 job, then we proceed to next statement.
			thread2.join();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Exiting main thread");
	}
}
